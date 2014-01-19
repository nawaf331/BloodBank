/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class DeleteUser {

    private String deleteDonorQuery;
    private String deleteFromLogin;
    private String deleteMgrQuery;

    public String getDeleteMgrQuery() {
        return deleteMgrQuery;
    }

    public String getDeleteFromLogin() {
        return deleteFromLogin;
    }

    public String getDeleteDonorQuery() {
        return deleteDonorQuery;
    }
    PreparedStatement stmt;
    static Connection connection;
    int result;

    public void deletemgr() {
        deleteMgrQuery = "DELETE FROM bloodbankmanagerBBM WHERE emp_id = ?";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(getDeleteMgrQuery());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, Login.DONOR_ID);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDonor() {
        System.out.println("Login.DONOR_ID" + Login.DONOR_ID);
        connection = core.DBManager.con;
        deleteDonorQuery = "DELETE FROM donorBBM WHERE donor_id = ?";
        try {
            stmt = connection.prepareStatement(getDeleteDonorQuery());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.setString(1, Login.DONOR_ID);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        deleteFromLogin = "DELETE FROM loginBBM WHERE username = ?";


        try {
            stmt = connection.prepareStatement(getDeleteFromLogin());
            stmt.setString(1, Login.DONOR_ID);
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showConfirmDialog(null, "You are no more a registered\nmember of the blood bank system", "Quit", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
    }
}
