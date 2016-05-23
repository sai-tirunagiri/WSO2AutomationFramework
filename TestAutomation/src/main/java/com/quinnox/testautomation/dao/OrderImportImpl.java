package com.quinnox.testautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.quinnox.testautomation.util.DBUtil;

public class OrderImportImpl implements OrderImport {
	@SuppressWarnings("rawtypes")
	private static HashMap m1 = new HashMap();
	private ResultSet resultSet;
	private PreparedStatement statement;
	private ResultSetMetaData resultSetColumnName;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap getOrderHeaderDetails() {
		Connection conn = DBUtil.createConnection();

		String query = "select PO_Number as ecommOrderId,order_date as createdAt,Fulfillment_Service_level as shippingMethod,Customer_name as lastName,customer_email_address as customerEmail, po_amount as totalPrice,Total_tax_amount as tax,first_name as firstName,last_name as lastName,country_code as countryCode,external_order_ref as ecommOrderId from c_apps.c_ont_order_headers where po_number='IND123456789777'";
		try {
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
			resultSetColumnName = resultSet.getMetaData();
			int columnCount = resultSetColumnName.getColumnCount();

			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					// System.out.println(resultSet.getString(3));
					// System.out.println(resultSetColumnName.getColumnName(i).toLowerCase()+","
					// +resultSet.getObject(i));
					m1.put(resultSetColumnName.getColumnName(i).toLowerCase(), resultSet.getObject(i));
				}
			}
			return m1;
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
			;
		}
		return null;
	}

	@Override
	public HashMap<String, Integer> getLineItemsDetails() {
		Connection conn = DBUtil.createConnection();
		HashMap<String, Integer> lineOrdersMap = new HashMap<String, Integer>();
		String item_number = null;
		int unit_price = 0;
		String query = "select item_number,unit_price from c_apps.c_ont_order_lines where order_id='54790477'";
		try {
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
			resultSetColumnName = resultSet.getMetaData();
			int columnCount = resultSetColumnName.getColumnCount();

			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					if (resultSetColumnName.getColumnName(i).equalsIgnoreCase("ITEM_NUMBER")) {
						item_number = resultSet.getString(i);
					} else {
						unit_price = resultSet.getInt(i);
					}
					lineOrdersMap.put(item_number, unit_price);

				}
			}
			return lineOrdersMap;
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
			;
		}
		return null;
	}
}