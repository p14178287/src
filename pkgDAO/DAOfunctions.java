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

public class ConnectDAO {

	// private Button btnCancel;

	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private Connection myConnection;
	private PreparedStatement myPreparedStatement;
	private ResultSet myResultSet;
	public static String ActiveUser = "";

	// private String = "";
	public static String ACTIVEUSER = "";

	public Connection connectDB() throws FileNotFoundException, IOException {
		try {
			// get the database properties for connection within a text file
			Properties property = new Properties();
			// folder where the text file is located has been specified as sql
			// folder
			property.load(new FileInputStream("sql/ToolHiredb.properties"));
			String user = property.getProperty("user");
			String password = property.getProperty("password");
			String dburl = property.getProperty("dburl");

			Connection myConnection = DriverManager.getConnection(dburl, user, password);

			System.out.println("Connection Okay");

			return myConnection;

		} catch (SQLException ex) {
			System.out.println("error connecting!");
		}
		return null;
	}

	/**
	 * Sends the parameters captured from the user and checks it against the
	 * values in the database by send a query to check. If they match then
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

	private void QueryDB() {
		Statement myStatement = null;
		ResultSet myResult = null;
	}

}
