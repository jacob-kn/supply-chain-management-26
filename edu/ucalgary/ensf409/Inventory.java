package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * Provides methods to access and update the inventory database.
 * @author 		Jacob Nguyen <a href="mailto:jacob.nguyen@ucalgary.ca">
 * 								jacob.nguyen@ucalgary.ca</a>
 * @version		1.5
 * @since 		1.0
 */
public class Inventory {
	private final String DBURL;
	private final String USERNAME;
	private final String PASSWORD;
	
	private Connection dbConnect;
	private ResultSet results;
	/**
    	 * Constructor. Initializes three public final String data members DBURL,
    	 * USERNAME, and PASSWORD with the provided database and user information.
    	 * @param dbUrl		database url.
    	 * @param userName	user's account username.
    	 * @param password	user's account password.
    	 */
	public Inventory(String dbUrl, String userName, String password) {
		this.DBURL = dbUrl;
		this.USERNAME = userName;
		this.PASSWORD = password;
	}
	/**
	 * Default constructor. Initializes the data members DBURL, USERNAME, 
	 * and PASSWORD with the default values
	 * DBURL = "jdbc:mysql://localhost/inventory"
	 * USERNAME = "scm"
	 * Password = "ensf409"
	 */
	public Inventory() {
		this("jdbc:mysql://localhost/inventory", "scm", "ensf409");
	}
	/**
    	 * Getter method for the database url data member.
     	 * @return	database url.
    	 */
    	public String getDburl(){
        	return DBURL;
    	}
    	/**
     	 * Getter method for username.
     	 * @return	user's account username.
     	 */
    	public String getUsername(){
        	return USERNAME;
    	}
    	/**
	 * Getter method for password.
	 * @return	user's account password.
	 */
    	public String getPassword(){
        	return PASSWORD;
    	}
	/**
	 * Creates connection to the database
	 */
	public void initializeConnection() {
		try {
			// initializes Connection datamember
			dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Closes the ResultSet and Connection data members.
	 */
	public void close() {
		try {
			// closes resources
			results.close();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Retrieves table of the specified furniture category from the database
	 * and parses the data into a 2D String array. The outer array
	 * corresponds to each column of the table (e.g. index [1][] will have
	 * the elements from the Type column), and the inner array indicates
	 * the row of each column.
	 * @param category	furniture category. E.g. chair, desk, filing, etc.
	 * @return	a two-dimensional array of Strings that represents the specified
	 * 			furniture category.
	 */
	public String[][] showTable(String category) {
		initializeConnection();
		String[][] table = null;
		try {
			Statement selectTable = dbConnect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			results = selectTable.executeQuery("SELECT * FROM " + category);
			ResultSetMetaData rsmd = results.getMetaData();
			// initialize table with the amount of columns from the table
			table = new String[rsmd.getColumnCount()][];
			// move cursor to get the number of rows
			results.last();
			int rows = results.getRow();
			// move cursor back to start
			results.beforeFirst();
			for (int i = 0; i < table.length; i++) {
				// initialize inner arrays with row count
				table[i] = new String[rows];
			}
			// fill array
			while (results.next()) {
				for (int i = 0; i < table.length; i++) {
					table[i][results.getRow() - 1] = results.getString(i + 1);
				}
			}
			selectTable.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return table;
	}
	/**
	 * Deletes the specified furniture items from the specified category
	 * table of the database.
	 * @param category	category of furniture item.
	 * @param id	array of furniture item ID's to be removed.
	 */
	public void removeFurniture(String category, String[] id) {
		for (int i = 0; i < id.length; i++) {
			// calls single String argument version of this method
			this.removeFurniture(category, id[i]);
		}
	}
	/**
	 * Deletes the specified furniture item from the specified category
	 * table of the database.
	 * @param category	category of furniture item.
	 * @param id	ID of furniture item to be removed.
	 */
	public void removeFurniture(String category, String id) {
		initializeConnection();
		try {
			// deletes item from the specified category using the primary key
			String query = "DELETE FROM " + category + " WHERE ID = ?";
			PreparedStatement deleteStmt = dbConnect.prepareStatement(query);
			deleteStmt.setString(1, id);
			deleteStmt.execute();
			deleteStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
