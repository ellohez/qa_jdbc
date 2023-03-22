package com.qa.jdbc;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PetDAO petDB = new PetDAO("jdbc:mysql://localhost:3306/pets", "root", "pass");
		petDB.read();
	}

}
