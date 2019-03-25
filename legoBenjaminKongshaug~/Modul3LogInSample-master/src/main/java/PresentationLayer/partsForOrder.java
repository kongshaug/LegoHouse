/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PresentationLayer;

import FunctionLayer.FindLegohouse;
import FunctionLayer.InvoiceFacade;
import FunctionLayer.LegoHouse;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import static FunctionLayer.brickCalculator.getBricksNeeded;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benja
 */
public class partsForOrder  extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        
         String email = request.getParameter( "email" );
        HttpSession session = request.getSession();
        
        String StringID = request.getParameter("seeParts");
        String a = "65";
        
       int ida = Integer.parseInt(a);
       
        int id = Integer.parseInt(StringID.trim());
        
        FindLegohouse find = new FindLegohouse();
        try {
            LegoHouse house = find.findLegohouse(id);
            session.setAttribute("LegoHouse", house);
        } catch (Exception ex) {
            Logger.getLogger(partsForOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getBricksNeeded(session);
        
        
        
        
        return "SeeParts";
    }
    
    
}
