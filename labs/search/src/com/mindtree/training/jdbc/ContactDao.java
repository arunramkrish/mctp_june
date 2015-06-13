package com.mindtree.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mindtree.training.entity.Contact;

public class ContactDao {
	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/contactsdb";
	private static String userName = "root";
	private static String password = ""; //Welcome123
	
	static {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ContactDao() {
		// TODO Auto-generated constructor stub
	}
	
	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, password);
	}

	public void add(Contact c) {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement("insert into contacts (name, phone, dob) values (?, ?, ?)");
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getPhoneNo());
			stmt.setDate(3, new java.sql.Date(c.getDateOfBirth().getTime()));
			
			int numRowsInserted = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public List<Contact> get(String name) {
		List<Contact> contacts = new ArrayList<Contact>();
		
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement("select name, phone, dob from contacts where name = ?");
			stmt.setString(1, name);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Contact c = new Contact();
				
				c.setName(rs.getString("name"));
				c.setPhoneNo(rs.getString("phone"));


				contacts.add(c);
			}
			
			return contacts;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Contact c = new Contact("Arun", "954314", new Date());
		
		ContactDao dao = new ContactDao();
		dao.add(c);
		
		List<Contact> contacts = dao.get("Saravana");
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}
