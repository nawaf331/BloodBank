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
public class fillDonorMainPage {

    private String lastDonationQuery;
    PreparedStatement stmt;
    static Connection connection;
    ResultSet rs;
    private java.sql.Date lastDonationDate;
    private String sLastDonationDate;
    private String nameOfTheUser;
    private String sNameOftheUser;
    private String sNameOfTheMgr;
    private String getMgrQuery;
    private String BBName;

    public String getBBName() {
        return BBName;
    }

    public void setBBName(String BBName) {
        this.BBName = BBName;
    }

    public String getGetMgrQuery() {
        return getMgrQuery;
    }

    public void setGetMgrQuery(String getMgrQuery) {
        this.getMgrQuery = getMgrQuery;
    }

    public String getsNameOfTheMgr() {
        return sNameOfTheMgr;
    }

    public void setsNameOfTheMgr(String sNameOfTheMgr) {
        this.sNameOfTheMgr = sNameOfTheMgr;
    }

    public String getsNameOftheUser() {
        return sNameOftheUser;
    }

    public void setsNameOftheUser(String sNameOftheUser) {
        this.sNameOftheUser = sNameOftheUser;
    }

    public String getNameOfTheUser() {
        return nameOfTheUser;
    }

    public void setNameOfTheUser(String nameOfTheUser) {
        this.nameOfTheUser = nameOfTheUser;
    }

    public String getsLastDonationDate() {
        return sLastDonationDate;
    }

    public void setsLastDonationDate(String sLastDonationDate) {
        this.sLastDonationDate = sLastDonationDate;
    }

    public String getLastDonationQuery() {
        return lastDonationQuery;
    }

    public void fnGetLastDonationDate() {
        lastDonationQuery = "SELECT Donating_date FROM donatesBBM WHERE donor_id = ?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(getLastDonationQuery());
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, Login.DONOR_ID);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                lastDonationDate = rs.getDate("donating_date");
            }
            if (lastDonationDate != null) {
                setsLastDonationDate(lastDonationDate.toString());
            } else {
                setsLastDonationDate("'Never Before'");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fnGetNameOfTheUser() {
        nameOfTheUser = "SELECT name FROM donorBBM WHERE donor_id = ?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(getNameOfTheUser());
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, Login.DONOR_ID);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                sNameOftheUser = rs.getString("name");
            }
            if (getsNameOftheUser() == null) {
                setsNameOftheUser("User");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fnGetMgrName() {
        getMgrQuery = "SELECT bbm.Emp_name, bb.bname FROM bloodbankmanagerBBM AS bbm, registersBBM AS r, worksforBBM AS w, donorBBM AS d, bloodbankBBM AS bb WHERE ";
        getMgrQuery = getMgrQuery + "d.Donor_id= ? AND d.Donor_id=r.Donor_id AND r.Bno=w.Bno AND w.Emp_id=bbm.Emp_id";


        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(getGetMgrQuery());
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, Login.DONOR_ID);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                setBBName(rs.getString("bname"));
                setsNameOfTheMgr(rs.getString("emp_name"));
            }
            if (getsNameOftheUser() == null) {

                setsNameOfTheMgr("Admin");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
