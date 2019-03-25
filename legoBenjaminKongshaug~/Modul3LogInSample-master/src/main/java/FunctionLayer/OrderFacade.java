/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FunctionLayer;

import DBAccess.OrderMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benja
 */
public class OrderFacade {
    
     public static void createOrder(HttpSession session) throws LoginSampleException {
         try {
             //    User user = new User(email, password, "customer");
             OrderMapper.OrderMap(session);
         } catch (Exception ex) {
             // write exeption for something going wrong when creating order in database
           
             Logger.getLogger(OrderFacade.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
}
