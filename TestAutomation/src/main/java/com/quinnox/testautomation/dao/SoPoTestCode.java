package com.quinnox.testautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quinnox.testautomation.util.DBUtil;

public class SoPoTestCode {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	String query;
	
	public String getHeaderTableDataForGivenHeaderID(String txnOntHeaderID)
    {
		connection = DBUtil.createConnection();
		String query = "select * from c_apps.c_ont_3b11_so_headers where TXN_ONT_HEADER_ID='"+txnOntHeaderID+"'";
		String headerJson = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			headerJson = ResultSetConverter.convert(resultSet).toString();
			return headerJson.toLowerCase();
		} catch (SQLException ex) {
			System.out.println("SQLException raised during query execution: "
					+ ex.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException ex) {
				System.out.println("SQLException raised while closing resultset: "
						+ ex.getMessage());
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException ex) {
				System.out.println("Exeption raised while closing the statement: "
						+ ex.getMessage());
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException ex) {

				System.out.println("SQLException raised while closing the connection: "
						+ ex.getMessage());
			}
		}
		return headerJson;
	}
}
