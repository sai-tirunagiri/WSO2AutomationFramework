package com.quinnox.testautomation.util;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.pool.OracleDataSource;

public class DBUtil {
	public static Connection createConnection() {
		try{  
			//load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			OracleDataSource ods = new OracleDataSource();
			
			System.out.println("Driver loaded and connecting...");
			//create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ebsdb4-uat.am.mot-mobility.com:1525/utoa081","webm","Motobtp$$");
			System.out.println(con);
			System.out.println("Connected!");
			return con;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
