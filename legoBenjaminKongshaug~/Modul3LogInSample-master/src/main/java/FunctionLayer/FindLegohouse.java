/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FunctionLayer;

import static DBAccess.OrderMapper.house;

/**
 *
 * @author benja
 */
public class FindLegohouse {
    
    public LegoHouse findLegohouse(int id) throws Exception
    {
        
        return house(id);
    
    }
    
}
