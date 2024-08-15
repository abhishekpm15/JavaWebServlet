package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Customer;

public class CustomerDao {
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:/Users/abhishekpm/MySQLiteDB");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}
	
	public static int registerCustomer(Customer customer) {

		int status = 0;
		try {
			Connection connection = CustomerDao.getConnection();
			System.out.println("conncetion " + connection);
			String queryString = "insert into Registration values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, customer.getCustomerID());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setString(4, customer.getCustomerPassword());
			preparedStatement.setString(5, customer.getCustomerAddress());
			preparedStatement.setString(6, customer.getCustomerContact());
			status = preparedStatement.executeUpdate();
			if (status > 0) {
				System.out.println("Data inserted Successfully");
			} else {
				System.out.println("Error couldn't insert Data");
			}
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return status;

	}
	
	public static boolean validateEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}
		if (!email.contains("@")) {
			return false;
		}
		String[] parts = email.split("@");
		if (parts.length != 2) {
			return false;
		}
		String domain = parts[1];
		if (!domain.contains(".")) {
			return false;
		}
		return true;
	}

	public static boolean validatePassword(String password) {
		if (password == null || password.isEmpty()) {
			System.out.println("Null");
			return false;
		}

		if (password.length() < 8 || password.length() > 20) {
			System.out.println("length");
			return false;
		}

		boolean hasDigit = false;
		boolean hasLowercase = false;
		boolean hasUppercase = false;
		boolean hasSpecialChar = false;

		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				hasDigit = true;
			} else if (Character.isLowerCase(c)) {
				hasLowercase = true;
			} else if (Character.isUpperCase(c)) {
				hasUppercase = true;
			} else if (!Character.isLetterOrDigit(c)) {
				hasSpecialChar = true;
			}
		}

		return hasDigit && hasLowercase && hasUppercase && hasSpecialChar;
	}

	public static boolean validateFields(String id, String name, String password, String address, String contact) {
		if (id == null || name.isEmpty() || password.isEmpty() || address.isEmpty() || contact.isEmpty()) {
			return false;
		}
		return true;
	}

	public static String encrypt(String password) {
		StringBuilder encryptedPassword = new StringBuilder();

		for (char c : password.toCharArray()) {
			if (Character.isLetter(c)) {
				char base = Character.isUpperCase(c) ? 'A' : 'a';
				encryptedPassword.append((char) ((c - base + 2) % 26 + base));
			} else {
				encryptedPassword.append(c);
			}
		}

		return encryptedPassword.toString();
	}

	public static String decrypt(String encryptedPassword) {
		StringBuilder decryptedPassword = new StringBuilder();

		for (char c : encryptedPassword.toCharArray()) {
			if (Character.isLetter(c)) {
				char base = Character.isUpperCase(c) ? 'A' : 'a';
				decryptedPassword.append((char) ((c - base - 2 + 26) % 26 + base));
			} else {
				decryptedPassword.append(c);
			}
		}

		return decryptedPassword.toString();
	}
	
	
//	public static int validateLogin(Customer customer) throws ClassNotFoundException, SQLException {
//
//		Connection con = getConnection();
//		String str = "select CustomerID , CustomerPassword from Registration";
//		PreparedStatement pr = con.prepareStatement(str);
//		ResultSet r = pr.executeQuery();
//		int c = 0;
//		while (r.next()) {
//			if (r.getInt("CustomerID") == (customer.getCustomerID()) && r.getString("CustomerPassword").equals(customer.getCustomerPassword())) {
//				c++;
//			}
//		}
//		pr.close();
//		con.close();
//		return c;
//
//	}

	public static String validateLogin(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String sqlString = "select * from Registration where customerID = ?";
		PreparedStatement statement = con.prepareStatement(sqlString);
		statement.setInt(1, customer.getCustomerID());
		ResultSet resultSet = statement.executeQuery();
		String customerEncryptedPassword = "";
		String customerName = null;
		while(resultSet.next()) {
			customerEncryptedPassword = resultSet.getString(4);
			customerName = resultSet.getString(2);
		}
		if(CustomerDao.decrypt(customerEncryptedPassword).equals(customer.getCustomerPassword())) {
			System.out.println("Customer Encrypted Password true" + customerEncryptedPassword);
			return customerName;
		}
		System.out.println("Customer Encrypted Password false" + customerEncryptedPassword);
		if (statement != null)
			statement.close();
		if (con != null)
			con.close();
		return null;
		
	}
	
	
	
}
