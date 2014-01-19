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
public class DonateBloodBL {

    PreparedStatement stmt;
    static Connection connection;
    ResultSet rs;
    int result;
    private String bloodtype;
    String quantityQuery;
    int quant;
    private String code;
    String quantityIncrementQuery;
    private int bloodCount;

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

    public String getQuantityQuery() {
        return quantityQuery;
    }

    public void setQuantityQuery(String quantityQuery) {
        this.quantityQuery = quantityQuery;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void incrementBlood() {
        quantityQuery = "select s.quantity, b.code from storesBBM as s, bloodBBM as b where b.Bloodgroup= ? and b.code=s.code";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(getQuantityQuery());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, getBloodtype());
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

        quant++;

        quantityIncrementQuery = "UPDATE storesBBM SET Quantity = ? WHERE code=?";
        try {
            stmt = connection.prepareStatement(quantityIncrementQuery);
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

    public void transferBlood() {

        quantityQuery = "select s.quantity, b.code from storesBBM as s, bloodBBM as b where b.Bloodgroup= ? and b.code=s.code";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(getQuantityQuery());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, getBloodtype());
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

        quant = quant + getBloodCount();

        quantityIncrementQuery = "UPDATE storesBBM SET Quantity = ? WHERE code=?";
        try {
            stmt = connection.prepareStatement(quantityIncrementQuery);
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
