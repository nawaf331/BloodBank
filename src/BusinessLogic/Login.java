/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class Login {

    static String DONOR_ID;
    static Connection connection;

    public static void setDONOR_ID(String username) {
        DONOR_ID = username;
    }
    Statement stmt;
    ResultSet rs;
    String sql;
    private String EnteredName;
    private String EnteredPassword;
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEnteredName() {
        return EnteredName;
    }

    public void setEnteredName(String EnteredName) {
        this.EnteredName = EnteredName;
    }

    public String getEnteredPassword() {
        return EnteredPassword;
    }

    public void setEnteredPassword(String EnteredPassword) {
        this.EnteredPassword = EnteredPassword;
    }

    public boolean isValidLogin() {
        sql = "SELECT * FROM loginBBM";
        //core.DBManager connector=new core.DBManager();\
        connection = core.DBManager.con;
        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Login.java -> createStatement-> " + ex.getMessage());
        }
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Login.java -> executeQuery -> " + ex.getMessage());
        }
        try {
            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");

                if (getEnteredName().equals(user) && getEnteredPassword().equals(pass)) {
                    String type = rs.getString("usertype");
                    setUserType(type);
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Login.java -> rs.next() in while -> " + ex.getMessage());
        }
        return false;
    }
}
