/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class UserRegistration {

    /**
     * @param args the command line arguments
     */
    //static String DONOR_ID;
    String username;
    String Password;
    PreparedStatement stmt;
    static Connection connection;
    String insertUserInfoSql;
    int result;

    public void setUsername(String username) {
        this.username = username;
        Login.DONOR_ID = this.username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public static void setConnection(Connection connection) {
        UserRegistration.connection = connection;
    }

    public void setInsertUserInfoSql(String insertUserInfoSql) {
        this.insertUserInfoSql = insertUserInfoSql;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return Password;
    }

    public Statement getStmt() {
        return stmt;
    }

    public static Connection getConnection() {
        return connection;
    }

    public String getInsertUserInfoSql() {
        return insertUserInfoSql;
    }

    public int getResult() {
        return result;
    }

    public boolean fnToInsertUser() {
        result = 0;
        setInsertUserInfoSql("INSERT INTO LoginBBM VALUES(?,?,?)");

        try {
            connection = core.DBManager.con;
            stmt = connection.prepareStatement(getInsertUserInfoSql());
            stmt.setString(1, getUsername());
            stmt.setString(2, getPassword());
            stmt.setString(3, "D");      //we can Insert only Donor Through this form
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        try {
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return result == 1;
    }
}
