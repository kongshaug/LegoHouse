/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FunctionLayer;

/**
 *
 * @author benja
 */
public class LegoHouse {
    private String hight;
    private String width;
    private String depth;
    boolean shippingStatus;
    String email;
    int id;

    public LegoHouse( String hight, String width, String depth) {
       this.hight = hight;
       this.depth = depth;
       this.width = width;
       this.shippingStatus = false;
       this.email = "unknown";
       
    }

    public String getHight() {
        return hight;
    }

    public String getWidth() {
        return width;
    }

    public String getDepth() {
        return depth;
    }

    public boolean getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(boolean shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
