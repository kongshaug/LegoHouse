/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LegoHouse;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import static FunctionLayer.brickCalculator.getBricksNeeded;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benja
 */
public class OrderMapper {

    public static void OrderMap(HttpSession Session) throws Exception {
        try {
            Connection con = Connector.connection();
//            
           User user = (User) Session.getAttribute("user");
            LegoHouse house = (LegoHouse) Session.getAttribute("LegoHouse");
            
            String email = user.getEmail();
       
            String wight = house.getWidth();
            String depth = house.getDepth();
            String hight = house.getHight();

           String SQL = "INSERT INTO legohouse.mesurments (email, shippingStatus, wigth, depth, hight) " + "VALUES (?,?, ?, ?, ?);";
                      
          PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, email);
            ps.setBoolean(2, false );
            ps.setString(3, wight);
            ps.setString(4, depth);
            ps.setString(5, hight);


            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static ArrayList getcustomerInovices(HttpSession Session) throws Exception {
        ArrayList <LegoHouse> orders = new ArrayList();
        try {
            
           User user = (User) Session.getAttribute("user");
            LegoHouse housef = (LegoHouse) Session.getAttribute("LegoHouse");
         
            String email = user.getEmail();
       
            String wight;
            String depth;
            String hight;
            boolean shippingStatus;
            String aemail;
            int id;
            String query = "SELECT * FROM `legohouse`.`mesurments` where email = '"+email+"';";
            Connection con = Connector.connection();
            if ("emp".equals(user.getRole()))
            {
            query = "SELECT * FROM `legohouse`.`mesurments`;";
            }
            
         
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

           

            while (rs.next()) {
                id = rs.getInt("id");
                shippingStatus = rs.getBoolean("shippingStatus");
                wight = rs.getString("wigth");
                depth = rs.getString("depth");
                hight = rs.getString("hight");
                aemail = rs.getString("email");
                LegoHouse house = new LegoHouse(hight, wight, depth);
                house.setId(id);
                house.setEmail(aemail);
                if (shippingStatus)
                {
                house.setShippingStatus(true);
                }
                orders.add(house);
            }
            
           

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        
   
        
        return orders;
    }
    
    
    
    
    
    
public static void getEmployeeInovices(HttpSession Session) throws Exception {
        try {
//            Connection con = Connector.connection();
//            
           User user = (User) Session.getAttribute("user");
            LegoHouse house = (LegoHouse) Session.getAttribute("LegoHouse");
            String email = user.getEmail();
       
            String wight = house.getWidth();
            String depth = house.getDepth();
            String hight = house.getHight();

//            String SQL = "INSERT INTO `legohouse`.`mesurments` VALUES "
//                    + "(?,?, ?, ?, ?);";
            
//             String SQL = "INSERT INTO `legohouse`.`mesurments` VALUES "
//                    + "('tututu', false, '?', '2', '3');";    
//            PreparedStatement ps = con.prepareStatement(SQL);

  //          ps.setString(1, email);
//            ps.setString(2, "false" );
//            ps.setString(3, wight);
//            ps.setString(4, depth);
//            ps.setString(5, hight);

//              ps.executeQuery();
              
              Connection con = Connector.connection();
            String SQL = "INSERT INTO `legohouse`.`mesurments` VALUES ('"+email+"', false, '"+wight+"', '"+depth+"', '"+hight+"');";
            PreparedStatement ps = con.prepareStatement( SQL );
           
       
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


public static void ship(int id) throws Exception {
        try {

              Connection con = Connector.connection();
            String SQL = "UPDATE `mesurments` SET `shippingStatus` = true WHERE id = "+ id +";";
            PreparedStatement ps = con.prepareStatement( SQL );
           
       
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

public static LegoHouse house(int id) throws Exception {
        
        try {
            
           
            LegoHouse theHouse = null;
            String wight;
            String depth;
            String hight;
            boolean shippingStatus;
            String aemail;
           
            String query = "SELECT * FROM `legohouse`.`mesurments` where id = '"+id+"';";
            Connection con = Connector.connection();
            
            
         
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

           

            while (rs.next()) {
                
                shippingStatus = rs.getBoolean("shippingStatus");
                wight = rs.getString("wigth");
                depth = rs.getString("depth");
                hight = rs.getString("hight");
                aemail = rs.getString("email");
                LegoHouse house = new LegoHouse(hight, wight, depth);
                house.setId(id);
                house.setEmail(aemail);
                if (shippingStatus)
                {
                house.setShippingStatus(true);
                }
                return house;
            }
            
           

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        
   
        
        return null;
    }

}