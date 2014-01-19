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
public class fillMgrMainBL {

    private String lastDonationQuery;
    PreparedStatement stmt;
    static Connection connection;
    ResultSet rs;
    private int DonorCount;
    private int HospitalCount;
    private int APcount;
    private int ANcount;
    private int BPcount;
    private int BNcount;
    private int OPcount;
    private int ONcount;
    private int ABPcount;
    private int ABNcount;
    private String sNameOftheMgr;

    public String getsNameOftheMgr() {
        return sNameOftheMgr;
    }

    public void setsNameOftheMgr(String sNameOftheMgr) {
        this.sNameOftheMgr = sNameOftheMgr;
    }

    public int getABNcount() {
        return ABNcount;
    }

    public void setABNcount(int ABNcount) {
        this.ABNcount = ABNcount;
    }

    public int getABPcount() {
        return ABPcount;
    }

    public void setABPcount(int ABPcount) {
        this.ABPcount = ABPcount;
    }

    public int getANcount() {
        return ANcount;
    }

    public void setANcount(int ANcount) {
        this.ANcount = ANcount;
    }

    public int getAPcount() {
        return APcount;
    }

    public void setAPcount(int APcount) {
        this.APcount = APcount;
    }

    public int getBNcount() {
        return BNcount;
    }

    public void setBNcount(int BNcount) {
        this.BNcount = BNcount;
    }

    public int getBPcount() {
        return BPcount;
    }

    public void setBPcount(int BPcount) {
        this.BPcount = BPcount;
    }

    public int getONcount() {
        return ONcount;
    }

    public void setONcount(int ONcount) {
        this.ONcount = ONcount;
    }

    public int getOPcount() {
        return OPcount;
    }

    public void setOPcount(int OPcount) {
        this.OPcount = OPcount;
    }

    public int getHospitalCount() {
        return HospitalCount;
    }

    public void setHospitalCount(int HospitalCount) {
        this.HospitalCount = HospitalCount;
    }

    public int getDonorCount() {
        return DonorCount;
    }

    public void setDonorCount(int DonorCount) {
        this.DonorCount = DonorCount;
    }
    private String query;

    public void getNoOfDonors() {
        query = "select count(donor_id) from registersbbm";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                DonorCount = rs.getInt("count(donor_id)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getNoOfHospitals() {
        query = "select count(Name) from hospitalBBM";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                HospitalCount = rs.getInt("count(Name)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEachBloodData() {
        getCountOfAP();
        getCountOfAN();
        getCountOfBP();
        getCountOfBN();
        getCountOfOP();
        getCountOfON();
        getCountOfABP();
        getCountOfABN();
    }

    private void getCountOfAP() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "AP");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                APcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getCountOfAN() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "AN");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                ANcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getCountOfBP() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "BP");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                BPcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getCountOfBN() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "BN");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                BNcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getCountOfOP() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "ON");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                OPcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getCountOfABP() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "ABP");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                ABPcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getCountOfABN() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "ABN");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                ABNcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getCountOfON() {
        query = "select Quantity from storesBBM where Code=?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, "ON");
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                ONcount = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillMgrMainBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getNameOfTheMgr() {

        query = "SELECT emp_name FROM bloodbankmanagerBBM WHERE Emp_id = ?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
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
                sNameOftheMgr = rs.getString("Emp_name");
            }
            if (getsNameOftheMgr() == null) {
                setsNameOftheMgr("Manager");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fillDonorMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
