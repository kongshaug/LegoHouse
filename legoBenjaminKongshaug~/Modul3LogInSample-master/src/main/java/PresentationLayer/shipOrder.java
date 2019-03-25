/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderFacade;
import FunctionLayer.ShipFacade;
import FunctionLayer.User;
import static java.lang.Integer.parseInt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benja
 */
public class shipOrder extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String id = request.getParameter("houseId");
        
        int integerId;
        
        integerId = Integer.parseInt(id + "");
       
        ShipFacade.ship(integerId);
        String view;
        view = new invoices().execute( request, response );
        return view;
    }
    
}
