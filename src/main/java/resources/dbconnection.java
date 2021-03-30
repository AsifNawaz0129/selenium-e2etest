package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnection {
	
	public void makeConnection() throws SQLException {
		String host="localhost";
		String port="3306";
		String Db= "qadbt";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+Db, "root", "root");
		Statement s = con.createStatement();
		ResultSet rs= s.executeQuery("select * from EmployeeInfo where name='asif'");
		while(rs.next()) {
			System.out.print(rs.getString("name"));
		}
	}

}
