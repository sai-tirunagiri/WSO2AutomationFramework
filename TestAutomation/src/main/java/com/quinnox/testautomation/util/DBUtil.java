package com.quinnox.testautomation.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection createConnection() {
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			
			System.out.println("Driver loaded and connecting...");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ebsracv3-uat.am.mot-mobility.com:1525/utoa081","webm","Motobtp$$");
			System.out.println("Connection to DB success!");
			return con;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
