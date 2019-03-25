/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PresentationLayer;

import FunctionLayer.LegoHouse;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import static FunctionLayer.brickCalculator.getBricksNeeded;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benja
 */
public class CalculateLego extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String hight = request.getParameter( "hight" );
        String width = request.getParameter( "width" );
        String depth = request.getParameter("depth");
        
       
        LegoHouse house = new LegoHouse( hight, width, depth);
        HttpSession session = request.getSession();
        session.setAttribute( "LegoHouse", house );
        getBricksNeeded(session);
        User user = (User) session.getAttribute("user");
        return "customerpage";
    }

}

