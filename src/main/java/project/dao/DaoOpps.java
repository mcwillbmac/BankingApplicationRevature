package project.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import project.connectionUtil.Connections;
import project.models.*;

public class DaoOpps implements DaoInterface {
	
	public int insert(User u) {

		try {
			
			Connection conn = Connections.getConnection();

			
			String columns = "first_name, last_name ,user_name ,password ,address";
			String sql = "INSERT INTO users (" + columns + ") VALUES (?, ?, ?, ?, ?)";
			

			// Step 3a: Obtain Statement Object
			// PreparedStatement is a sub interface of Statement that provides extra
			// security to prevent SQL injection.
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Step 3b: Inject values to replace all the ? marks
			stmt.setString(1, u.getUserName()); // replace 1st ? mark with u.getUsername()
			stmt.setString(2, u.getPassWord()); // replace 2nd ? mark with u.getPassword()
			stmt.setString(3, u.getFirstName()); // replace 3rd ? mark with u.getFirstName()
			stmt.setString(4, u.getLastName());
			stmt.setString(5, u.getAddress());
			 // this is returning the int value for the Role id of the Role object

			// Step 4: Execute the statement;
			return stmt.executeUpdate(); // this will return the number of statements executed (1)

		} catch (SQLException e) {
			// Step 5: Perform any exception handling in an appropriate means
			e.printStackTrace();
		}

		// otherwise we return 0 if we cannot insert a row into the database
		return 0;
	}
	
	public int insertC(Customer u) {

		try {
			
			Connection conn = Connections.getConnection();

			
			String columns = "id,first_name, last_name ,user_name ,pass ,address";
			String sql = "INSERT INTO customers (" + columns + ") VALUES (?, ?, ?, ?, ?, ?)";
			

			// Step 3a: Obtain Statement Object
			// PreparedStatement is a sub interface of Statement that provides extra
			// security to prevent SQL injection.
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Step 3b: Inject values to replace all the ? marks
			stmt.setInt(1, u.getId());
			stmt.setString(2, u.getFirstName()); // replace 1st ? mark with u.getUsername()
			stmt.setString(3, u.getLastName()); // replace 2nd ? mark with u.getPassword()
			stmt.setString(4, u.getUserName()); // replace 3rd ? mark with u.getFirstName()
			stmt.setString(5, u.getPassWord());
			stmt.setString(6, u.getAddress());
			 

			// Step 4: Execute the statement;
			return stmt.executeUpdate(); // this will return the number of statements executed (1)

		} catch (SQLException e) {
			// Step 5: Perform any exception handling in an appropriate means
			e.printStackTrace();
		}

		// otherwise we return 0 if we cannot insert a row into the database
		return 0;
	}
	
	public int insertB(BankAdmin u) {

		try {
			
			Connection conn = Connections.getConnection();

			
			String columns = "id,first_name, last_name ,user_name ,password ,address";
			String sql = "INSERT INTO customers (" + columns + ") VALUES (?, ?, ?, ?, ?, ?)";
			

			// Step 3a: Obtain Statement Object
			// PreparedStatement is a sub interface of Statement that provides extra
			// security to prevent SQL injection.
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Step 3b: Inject values to replace all the ? marks
			stmt.setInt(1, u.getId());
			stmt.setString(2, u.getUserName()); // replace 1st ? mark with u.getUsername()
			stmt.setString(3, u.getPassWord()); // replace 2nd ? mark with u.getPassword()
			stmt.setString(4, u.getFirstName()); // replace 3rd ? mark with u.getFirstName()
			stmt.setString(5, u.getLastName());
			stmt.setString(6, u.getAddress());
			 // this is returning the int value for the Role id of the Role object

			// Step 4: Execute the statement;
			return stmt.executeUpdate(); // this will return the number of statements executed (1)

		} catch (SQLException e) {
			// Step 5: Perform any exception handling in an appropriate means
			e.printStackTrace();
		}

		// otherwise we return 0 if we cannot insert a row into the database
		return 0;
	}
	

	

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
