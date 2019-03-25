/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FunctionLayer;

import DBAccess.OrderMapper;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benja
 */
public class InvoiceFacade {
    public static ArrayList createOrder( HttpSession session) throws LoginSampleException, Exception {
        return OrderMapper.getcustomerInovices( session );
    } 
    
}
