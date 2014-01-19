/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Administrator
 */
public interface IDBManager {

    static final String DBURL = "jdbc:oracle:thin:@129.0.10.100:1521:orasrv";
    //static Connection con=null;
    static final String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
    static final String USER = "oracle1";
    static final String PASS = "oracle1";
}
