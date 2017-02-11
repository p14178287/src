package pkgDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAOfunctions {

	private static Connection myConnection;
	private static PreparedStatement myPreparedStatement;
	private ResultSet myResultSet;

	public static Connection connectDB() throws FileNotFoundException, IOException {

		try {
			// get the database properties for connection within a text file
			Properties property = new Properties();
			// folder where the text file is located has been specified as sql
			property.load(new FileInputStream("sql/ToolHiredb.properties"));
			String user = property.getProperty("user");
			String password = property.getProperty("password");
			String dburl = property.getProperty("dburl");

			Connection myConnection = DriverManager.getConnection(dburl, user, password);

			System.out.println("Connection Okay"); // for debugging

			return myConnection;

		} catch (SQLException ex) {
			System.out.println("error connecting!");
		}

		return null;
	}

	/*
	 * Instead of doing fresh connection to the database every time you need to
	 * use a controller use the static method to pass on the connection around
	 * the event handlers that way the user will need to connect once to the
	 * database.
	 */
	public static final Connection passDBconnection() {
		return myConnection;
	}

	/**
	 * Sends the parameters captured from the user and checks them against the
	 * values in the database by sending a query to check. If they match then
	 * authentication is successful.
	 * 
	 * @param username
	 * @param password
	 * @param userlevel
	 * @return
	 */
	public boolean isUser(String username, String password, String userlevel) { // AUTHENTICATE
		try {
			String query = "SELECT * FROM dbusers WHERE Name=? and Password=? and userlevel=?";
			myConnection = connectDB();
			myPreparedStatement = myConnection.prepareStatement(query);
			myPreparedStatement.setString(1, username);
			myPreparedStatement.setString(2, password);
			myPreparedStatement.setString(3, userlevel);
			myResultSet = myPreparedStatement.executeQuery();
			while (myResultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static void closeDB(Connection myConnection, Statement myStatement, ResultSet myResult) throws SQLException {

		if (myResult != null) {
			myResult.close();
		}

		if (myStatement != null) {
			myStatement.close();
		}

		if (myConnection != null) {
			myConnection.close();
		}
	}

	public boolean isUsernameValid(String username, String userlevel) {
		// check if username is the same as the one entered first
		try {
			String query = "SELECT Name, Userlevel FROM dbusers WHERE Name = ? and Userlevel = ?";
			myConnection = connectDB();
			myPreparedStatement = myConnection.prepareStatement(query);
			myPreparedStatement.setString(1, username);
			myPreparedStatement.setString(2, userlevel);
			myResultSet = myPreparedStatement.executeQuery();
			while (myResultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public boolean updateNewpassword(String newPassword, String username, String userlevel) {
		try {
			String query = "UPDATE dbusers SET Password = ? WHERE Name=? and Userlevel=?";
			myConnection = connectDB();
			myPreparedStatement = myConnection.prepareStatement(query);
			myPreparedStatement.setString(1, newPassword);
			myPreparedStatement.setString(2, username);
			myPreparedStatement.setString(3, userlevel);
			myPreparedStatement.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
		}
		return false;

	}
	// ******* FUNCTIONS TO UPDATE DATABASE ************/

	// TODO: finish populating all parameters into a query
	public static void updateNewValuesEntered(Integer uniqueCustomerID, String updatedCustomerFirstName,
			String updatedCustomerLastName, String updatedCustomerAddress, String updatedCustomerEmail,
			Integer updatedCustomerPhoneNumber) {
		try {
			String query = "UPDATE customer SET dbCustomerFirstName = ?, dbCustomerLastName = ?, dbCustomerAddress = ?, dbCustomerEmail = ?, dbCustomerPhoneNumber = ? WHERE dbcustomerID = ?";
			// myConnection = connectDB();
			myPreparedStatement = myConnection.prepareStatement(query);
			myPreparedStatement.setString(1, updatedCustomerFirstName);
			myPreparedStatement.setString(2, updatedCustomerLastName);
			myPreparedStatement.setString(3, updatedCustomerAddress);
			myPreparedStatement.setString(4, updatedCustomerEmail);
			myPreparedStatement.setInt(5, updatedCustomerPhoneNumber);
			myPreparedStatement.setInt(6, uniqueCustomerID);
			myPreparedStatement.executeUpdate();
			System.out.println("successful update");
		} catch (Exception e) {
			System.out.println("error inserting values");
			System.err.println(e);
		}
	}

	public void insertNewCustomer(Integer id, String newCustomerFirstName, String newCustomerLastName,
			String newCustomerAddress, String newCustomerEmail, Integer newCustomerPhoneNumber) {
		try {
			String query = "INSERT INTO customer (dbCustomerID, dbCustomerFirstName, dbCustomerLastName, dbCustomerAddress, dbCustomerEmail, dbCustomerPhoneNumber) "
					+ " VALUES (?, ?, ?, ?, ?, ?)";
					//+ "VALUES (dbCustomerID = ?, dbCustomerFirstName = ?, dbCustomerLastName = ?, dbCustomerAddress = ?, dbCustomerEmail = ?, dbCustomerPhoneNumber = ?)";
			myConnection = connectDB();
			myPreparedStatement = myConnection.prepareStatement(query);
			myPreparedStatement.setInt(1, id);
			myPreparedStatement.setString(2, newCustomerFirstName);
			myPreparedStatement.setString(3, newCustomerLastName);
			myPreparedStatement.setString(4, newCustomerAddress);
			myPreparedStatement.setString(5, newCustomerEmail);
			myPreparedStatement.setInt(6, newCustomerPhoneNumber);
			myPreparedStatement.executeUpdate();
			System.out.println("successful update");
		} catch (Exception e) {
			System.out.println("error inserting values");
			System.err.println(e);
		}

		// return false;
	}

	// ******* FUNCTIONS TO QUERY DATABASE ************/

	private void QueryDB() {
		Statement myStatement = null;
		ResultSet myResult = null;
	}

}
