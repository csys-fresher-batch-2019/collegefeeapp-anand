package sxc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnect {

public static Connection getConnection()throws Exception {
// TODO Auto-generated method stub
Class.forName("oracle.jdbc.driver.OracleDriver");

//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.201:1521:XE", "system", "oracle");
Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:XE", "system", "oracle");
return connection;
}

}