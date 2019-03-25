/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PresentationLayer;

import FunctionLayer.InvoiceFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderFacade;
import FunctionLayer.User;
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
public class invoices  extends Command {
    
    /**
     shows the user the invoices of his or hers privious orders

     @param request servlet request
     @param response servlet response
     @throws LoginSampleException
     */

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        
        HttpSession session = request.getSession();
        session.setAttribute("house", request.getParameter("house"));
        User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        ArrayList orders = new ArrayList();
        try {
            // create order in database
            orders = InvoiceFacade.createOrder(session);
            
        } catch (Exception ex) {
            Logger.getLogger(invoices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        session.setAttribute("orders", orders);
        if ("emp".equals(user.getRole()))
        {
        return "allInvoices";
        }
        return "invoices";
    }
    
}


