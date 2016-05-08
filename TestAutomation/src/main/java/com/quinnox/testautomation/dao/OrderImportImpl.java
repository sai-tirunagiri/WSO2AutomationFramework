package com.quinnox.testautomation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.quinnox.testautomation.util.DBUtil;

public class OrderImportImpl implements OrderImport {
	@SuppressWarnings("rawtypes")
	private static Map m1 = new HashMap();
	private ResultSet resultSet;
	private Statement statement;
	private ResultSetMetaData resultSetColumnName;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getOrderHeaderDetails(){
		Connection conn = DBUtil.createConnection();
		
		String query = "select PO_Number,order_date,Fulfillment_Service_level,Customer_name,customer_email_address, po_amount,Total_tax_amount,first_name,last_name,country_code,external_order_ref from c_apps.c_ont_order_headers where po_number='123456789111'";
		try{
			statement = conn.createStatement();
			resultSet= statement.executeQuery(query);
		    resultSetColumnName = resultSet.getMetaData();
			int columnCount = resultSetColumnName.getColumnCount();
			
			while(resultSet.next()){
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(resultSetColumnName.getColumnName(i)+":"+resultSet.getObject(i));
				m1.put(resultSetColumnName.getColumnName(i), resultSet.getObject(i));
				}
			}
			return m1;
			//System.out.println(m1);
		}
		catch(SQLException sqlException){
			System.out.println(sqlException.getMessage());
		}
		finally{
			try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
		return null;
	}
}
