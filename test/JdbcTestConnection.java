package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTestConnection {
	
	

	public static void main(String[] args) {
		
		// 1. Get connection to database
		try {
			
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ToolHiredb", "admin", "samaita32");
			
			// 2. Create a statement
			Statement myStatement = myConnection.createStatement();
			
			// 3. Submitt SQL query
			ResultSet myResult = myStatement.executeQuery("select * from Customer where dbcustomerno = 1;");
			 
			// 4. Process result set
			while (myResult.next()) {
				System.out.println(myResult.getString("dbCustomerFirstName") + ", " + myResult.getString("dbCustomerLastName"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		

	}

}
