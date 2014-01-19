/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class OrderBloodBL {
    String decrementQuantityQuery;
    static Connection connection;
    PreparedStatement stmt;
    private String quantityQuery;
    private String bloodType;
    private ResultSet rs;
    private int quant;
     private String code;
     private int bloodCount;
    private String quantitydecrementQuery;
    private int result;

    public String getDecrementQuantityQuery() {
        return decrementQuantityQuery;
    }

    public void setDecrementQuantityQuery(String decrementQuantityQuery) {
        this.decrementQuantityQuery = decrementQuantityQuery;
    }

    public int getBloodCount() {
        return bloodCount;
    }

    public void setBloodCount(int bloodCount) {
        this.bloodCount = bloodCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    

    public String getbloodType() {
        return bloodType;
    }

    public void setbloodType(String BloodType) {
        this.bloodType = BloodType;
    }

    public String getQuantityQuery() {
        return quantityQuery;
    }

    public void setQuantityQuery(String quantityQuery) {
        this.quantityQuery = quantityQuery;
    }

    public void decrementBloodQuantity() {
       
         quantityQuery = "select s.quantity, b.code from storesBBM as s, bloodBBM as b where b.Bloodgroup= ? and b.code=s.code";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(getQuantityQuery());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, getbloodType());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                quant = rs.getInt("quantity");
                setCode(rs.getString("code"));
                System.out.println(quant);
                System.out.println(getCode());

            }
        } catch (SQLException ex) {
            Logger.getLogger(DonateBloodBL.class.getName()).log(Level.SEVERE, null, ex);
        }

        quant = quant - getBloodCount();

        quantitydecrementQuery = "UPDATE storesBBM SET Quantity = ? WHERE code=?";
        try {
            stmt = connection.prepareStatement(quantitydecrementQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setInt(1, quant);
            stmt.setString(2, getCode());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
   
    
    
}
