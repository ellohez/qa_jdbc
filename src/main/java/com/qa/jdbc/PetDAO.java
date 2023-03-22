package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PetDAO {

	private String url = "";
	private String user = "";
	private String pwd = "";
	private Connection conn;

//	private Connection conn = new Connection();

	public PetDAO(String url, String user, String pwd) {
		super();
		this.url = url;
		this.user = user;
		this.pwd = pwd;

		try {
			this.conn = DriverManager.getConnection(this.url, this.user, this.pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int create(String name, int age, String colour, String breed) {
		try (PreparedStatement stmt = this.conn
				.prepareStatement("INSERT INTO pets VALUES (name, age, colour, breed) VALUES (? ? ? ?);")) {

			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, colour);
			stmt.setString(3, breed);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @return
	 */
	public void read() {

		try (Statement stmt = conn.createStatement();) {
			ResultSet results = stmt.executeQuery("SELECT * FROM pets");
			while (results.next()) {
				System.out.printf("%d, %s, %d, %s %s %n", results.getInt(1), results.getString("name"),
						results.getInt(3), results.getString("colour"), results.getString("breed"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
