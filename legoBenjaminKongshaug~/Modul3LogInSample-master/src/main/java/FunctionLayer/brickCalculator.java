/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FunctionLayer;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import static javax.swing.Spring.width;

/**
 *
 * @author benja
 */
public class brickCalculator {
    
    
    public static void getBricksNeeded(HttpSession session){
        
        //the mesurments of the house
        LegoHouse house = (LegoHouse) session.getAttribute("LegoHouse");
        //the map to put the legobricks in
        HashMap map = new HashMap();
        int hight = 0, width = 0, depth = 0;
       try{
     hight = Integer.parseInt(house.getHight());
     width = Integer.parseInt(house.getWidth());
     depth = Integer.parseInt(house.getDepth());
       }
       catch (NumberFormatException e)
       {
           //set exception on session to be printet : "messurments need to be in numbers"
       }
       if (hight < 1 || width < 3 || depth < 3  )
           
       {
       session.setAttribute("inputError", "you need to enter a digit thats bigger the 3 for the wall's and bigger then 0 for the hight");
           
       }
       //finds the briks needed to take up all the space -2 for each row to overlap with the next rows on the side next to it and on top of it
       
     int firstFour = (width-2) / 4;
     int firstTwo = ((width-2) % 4) / 2;
     int firstOne = ((width-2) % 2);
     
     int secondFour = (depth-2) / 4;
     int secondTwo = ((depth-2) % 4) / 2;
     int secondOne = ((depth-2) % 2) ;
     
     //all the different kind of bricks needed for one layer
     
     int allFour = firstFour * 2 + secondFour * 2;
      int allTwo = firstTwo * 2 + secondTwo * 2;
       int allOne = firstOne * 2 + secondOne * 2;
       // all the different kind of bricks needed all in all
       
      int allFourWithHight = allFour* hight;
      int allTwoWithHight = allTwo* hight;
      int allOneWithHight = allOne* hight;
      
     
     // puts all the bricks need to bouild the house in the map
    map.put("firstFour", firstFour); 
    map.put("firstTwo", firstTwo);
    map.put("firstOne", firstOne);
    
    map.put("secondFour", secondFour);
    map.put("secondTwo", secondTwo);
    map.put("secondOne", secondOne);
    
    map.put("allFour", allFour);
    map.put("allTwo", allTwo);
    map.put("allOne", allOne);
     
    map.put("allFourWithHight", allFourWithHight);
    map.put("allTwoWithHight", allTwoWithHight);
    map.put("allOneWithHight", allOneWithHight);
     
     session.setAttribute("bricks", map);
     
     
     
    }
    
  
    
}

