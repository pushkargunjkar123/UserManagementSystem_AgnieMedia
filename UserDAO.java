package net.javaguides.usermanagement.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import com.sun.corba.se.pept.transport.Connection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

//DAO class provides CRUD database operations for table users in database
public class UserDAO {
	private String jdbcURL = "jdbc:mysl://localhost:3306//pushkar?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
			
	private static final String INSERT_pushkar_SQL = "INSERT INTO pushkar" + " (fname,lname,dob,city,mobilenumberr) + (?, ?, ?, ?, ?);";


	private static final String SELECT_USER_BY_fname = "select fname, lname, dob, city,mobilenumber from pushkar where fname=?";
	private static final String SELECT_ALL_pushkar = "select * from pushkar";
	private static final String DELETE_pushkar_SQL = "delete from pushkar where fname=?;";

	private static final String UPDATE_pushkar_SQL = "update pushkar set fname = ?, lname =?,dob = ?, city = ?, mobilenumber = ? where fname=?;";		
			
			
	protected Connection getConnection() {
	 Connection connection = null;

	try {

	Class.forName ("com.mysql.jdbc.Driver");

	connection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);;
	} catch (SQLException e)
	{ //TODO Auto-generated catch block
		e.printStackTrace();
	

	} catch (ClassNotFoundException e) 
	{// TODO Auto-generated catch block
			
		e.printStackTrace();
	}
		return connection;
			
     }
	

	// Create or insert user 
	 public void insertUser(User user) throws SQLException {
	        System.out.println(INSERT_pushkar_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_pushkar_SQL)) {
	            preparedStatement.setString(1, user.getFullName());
	            preparedStatement.setString(2, user.getName());
	            preparedStatement.setString(3,  ((Object) user).getDateob());
	            preparedStatement.setString(4, ((net.javaguides.usermanagement.model.user) user).getCity());
	            preparedStatement.setInteger(5, ((Object) user).getMobileNumbers());
	            
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        
	        
	        
	        
	        
	        
	        
	        public User selectUser(int id) {
	            User user = null;
	            // Step 1: Establishing a Connection
	            try (Connection connection = getConnection();
	                // Step 2:Create a statement using connection object
	                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_fname);) {
	                String fname;
					preparedStatement.setString(1, fname);
	                System.out.println(preparedStatement);
	                // Step 3: Execute the query or update query
	                ResultSet rs = preparedStatement.executeQuery();

	                // Step 4: Process the ResultSet object.
	                while (rs.next()) {
	                    String fname= rs.getString("fname");
	                    String lname = rs.getString("lname");
	                    String dob = rs.getString("dob");
	                    String city = rs.getString("city");
	                    int mobilenumber = rs.getInt("mobilenumber");
	                    user = new User(fname,lname , dob,city,mobilenumber);
	                }
	            } catch (SQLException e) {
	                printSQLException(e);
	            }
	            return user;
	            
	            
	            public List < User > selectAllUsers() {

	                // using try-with-resources to avoid closing resources (boiler plate code)
	                List < User > users = new ArrayList < > ();
	                // Step 1: Establishing a Connection
	                try (Connection connection = getConnection();

	                    // Step 2:Create a statement using connection object
	                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_pushkar);) {
	                    System.out.println(preparedStatement);
	                    // Step 3: Execute the query or update query
	                    ResultSet rs = preparedStatement.executeQuery();

	                    // Step 4: Process the ResultSet object.
	                    while (rs.next()) {
	                        String fname = rs.getString("fname");
	                        String lname = rs.getString("lname");
	                        String dob = rs.getString("dob");
	                        String city = rs.getString("city");
	                        Int mobilenumber = rs.getInt("mobilenumber");
	                        users.add(new User(fname,lname,dob,city,mobilenumber));
	                    }
	                } catch (SQLException e) {
	                    printSQLException(e);
	                }
	                return users;
	            }

	            public boolean deleteUser(String fname) throws SQLException {
	                boolean rowDeleted;
	                try (Connection connection = getConnection(); 
	                PreparedStatement statement = connection.prepareStatement(DELETE_pushkar_SQL);) {
	                    statement.setString(1, fname);
	                    rowDeleted = statement.executeUpdate() > 0;
	                }
	                return rowDeleted;
	            }

	            public boolean updateUser(User user) throws SQLException {
	                boolean rowUpdated;
	                try (Connection connection = getConnection();
	                		PreparedStatement statement = connection.prepareStatement(UPDATE_pushkar_SQL);) {
	                    statement.setString(1, user.getFullName());
	                    statement.setString(2, user.getName());
	                    statement.setString(3, ((Object) user).getDateob());
	                    statement.setString(3, net.javaguides.usermanagement.model.user.getCity());
	                    statement.setInt(4, net.javaguides.usermanagement.model.user.getMobilenumber());

	                    rowUpdated = statement.executeUpdate() > 0;
	                }
	                return rowUpdated;
	            }

	            private void printSQLException(SQLException ex) {
	                for (Throwable e: ex) {
	                    if (e instanceof SQLException) {
	                        e.printStackTrace(System.err);
	                        System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                        System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                        System.err.println("Message: " + e.getMessage());
	                        Throwable t = ex.getCause();
	                        while (t != null) {
	                            System.out.println("Cause: " + t);
	                            t = t.getCause();
	                        }
	                    }
	                }
	            }
}


	
		
	
	