package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PetDAO {

	private String url = "";
	private String user = "";
	private String pwd = "";
//	private Connection conn = new Connection();

	public PetDAO(String url, String user, String pwd) {
		super();
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}

	/**
	 * @return
	 */
	public void read() {

		try (Connection conn = DriverManager.getConnection(this.url, this.user, this.pwd);) {
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM pet");
			while (results.next()) {
				System.out.printf("%d, %s, %d, %s %s %n", results.getInt(1), results.getString("name"),
						results.getInt(3), results.getString("colour"), results.getString("breed"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
