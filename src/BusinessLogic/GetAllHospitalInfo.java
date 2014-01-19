/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class GetAllHospitalInfo {

    PreparedStatement stmt;
    static Connection connection;
    private ResultSet rs;

    public ResultSet getRs() {
        return rs;
    }
    private String query;
    // private javax.swing.JTable infotable;

    public void getTableFilled() {

        query = "SELECT name AS NAME, Address AS ADDRESS, Phone_no AS 'PHONE NUMBER' FROM hospitalBBM";
        connection = core.DBManager.con;
        try {
            stmt = connection.prepareStatement(query);
        } catch (SQLException ex) {
            System.out.println("connection error in GetAllDonorInfo");
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Execute error in GetAllDonorInfo");
        }

    }
}
