package com.qa.jdbc;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			PetDAO petDB = new PetDAO("jdbc:mysql://localhost:3306/pet", "root", "pass");
			petDB.read();
			petDB.create("Gusty", 6, "Grey", "Heinz-57");
			petDB.read();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
