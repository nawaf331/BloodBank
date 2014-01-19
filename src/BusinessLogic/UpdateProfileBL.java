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
 * @author Administrator
 */
public class UpdateProfileBL {

    static Connection connection;
    PreparedStatement stmt;
    ResultSet rs;
    String username;
    String name;
    String phone_no;
    String address;
    String SelectInfoSql;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelectInfoSql() {
        return SelectInfoSql;
    }

    public void setSelectInfoSql(String SelectInfoSql) {
        this.SelectInfoSql = SelectInfoSql;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void fnGetUserProfile() {
        SelectInfoSql = "select * from DonorBBM where Donor_id= ? ";
        try {
            connection = core.DBManager.con;
            stmt = connection.prepareStatement(getSelectInfoSql());
            stmt.setString(1, Login.DONOR_ID);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            while (rs.next()) {
                setUsername(rs.getString("Donor_id"));
                setName(rs.getString("Name"));
                setPhone_no(rs.getString("Phone_num"));
                setAddress(rs.getString("Address"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
