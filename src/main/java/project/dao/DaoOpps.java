package project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project.connectionUtil.Connections;
import project.models.*;

public class DaoOpps implements DaoInterface {

	public int insertT(Teller u) {

		try {

			Connection conn = Connections.getConnection();

			String columns = "first_name, last_name ,address, user_name ,pass, role_id";
			String sql = "INSERT INTO employee (" + columns + ") VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getAddress());
			stmt.setString(4, u.getUserName());
			stmt.setString(5, u.getPassWord());
			stmt.setInt(6, u.getRole().getId());

			return stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	public int insertC(Customer u) {

		try {

			Connection conn = Connections.getConnection();

			String columns = "first_name, last_name ,address ,user_name, pass, role_id, balance, acc_type";
			String sql = "INSERT INTO customers (" + columns + ") VALUES (?, ?, ?, ?, ?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getAddress());
			stmt.setString(4, u.getUserName());
			stmt.setString(5, u.getPassWord());
			stmt.setInt(6, u.getRole().getId());
			stmt.setDouble(7, u.getBalance());
			stmt.setInt(8, u.getAccType());

			return stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	public int insertB(BankAdmin u) {

		try {

			Connection conn = Connections.getConnection();

			String columns = "first_name, last_name ,address, user_name ,pass, role_id";
			String sql = "INSERT INTO employee (" + columns + ") VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getAddress());
			stmt.setString(4, u.getUserName());
			stmt.setString(5, u.getPassWord());
			stmt.setInt(6, u.getRole().getId());

			return stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	public List<Customer> findAllC() {

		List<Customer> allUsers = new ArrayList<Customer>();

		Connection conn = Connections.getConnection();
		String sql = "SELECT * FROM customers INNER JOIN roles ON customers.role_id = roles.id";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String userName = rs.getString("user_name");
				String pass = rs.getString("pass");
				int roleId = rs.getInt("role_id");
				String roleName = rs.getString("role_name");
				double balance = rs.getDouble("balance");
				int accType = rs.getInt("acc_type");

				Role r = new Role(roleId, roleName);
				Customer c = new Customer(id, firstName, lastName, address, userName, pass, r, balance, accType);

				allUsers.add(c);
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return new ArrayList<Customer>();
		}

		return allUsers;
	}

	public List<Teller> findAllT() {

		List<Teller> allUsers = new ArrayList<Teller>();

		Connection conn = Connections.getConnection();
		String sql = "SELECT * FROM employee INNER JOIN roles ON employee.role_id = roles.id";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String userName = rs.getString("user_name");
				String pass = rs.getString("pass");
				int roleId = rs.getInt("role_id");
				String roleName = rs.getString("role_name");

				Role r = new Role(roleId, roleName);
				Teller c = new Teller(id, firstName, lastName, address, userName, pass, r);

				allUsers.add(c);
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return new ArrayList<Teller>();
		}

		return allUsers;
	}

	public List<BankAdmin> findAllB() {

		List<BankAdmin> allUsers = new ArrayList<BankAdmin>();

		Connection conn = Connections.getConnection();
		String sql = "SELECT * FROM employee INNER JOIN roles ON employee.role_id = roles.id";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String userName = rs.getString("user_name");
				String pass = rs.getString("pass");
				int roleId = rs.getInt("role_id");
				String roleName = rs.getString("role_name");

				Role r = new Role(roleId, roleName);
				BankAdmin c = new BankAdmin(id, firstName, lastName, address, userName, pass, r);

				allUsers.add(c);
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return new ArrayList<BankAdmin>();
		}

		return allUsers;
	}

	public Customer findByIdC(int id) {

		Customer u = new Customer();

		Connection conn = Connections.getConnection();
		String sql = "SELECT * FROM customers INNER JOIN roles ON customers.role_id = roles.id WHERE customers.id = "
				+ id + "";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setAddress(rs.getString("address"));
				u.setUserName(rs.getString("user_name"));
				u.setPassWord(rs.getString("pass"));
				u.setRole(new Role(rs.getInt("role_id"), rs.getString("role_name")));
				u.setBalance(rs.getDouble("balance"));
				u.setAccType(rs.getInt("acc_type"));
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return u;
	}

	public Teller findByIdT(int id) {

		Teller u = new Teller();

		Connection conn = Connections.getConnection();
		String sql = "SELECT * FROM employee INNER JOIN roles ON employee.role_id = roles.id WHERE employee.id = " + id
				+ "";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setAddress(rs.getString("address"));
				u.setUserName(rs.getString("user_name"));
				u.setPassWord(rs.getString("pass"));
				u.setRole(new Role(rs.getInt("role_id"), rs.getString("role_name")));
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return u;
	}

	public BankAdmin findByIdB(int id) {

		BankAdmin u = new BankAdmin();

		Connection conn = Connections.getConnection();
		String sql = "SELECT * FROM employee INNER JOIN roles ON employee.role_id = roles.id WHERE employee.id = " + id
				+ "";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setAddress(rs.getString("address"));
				u.setUserName(rs.getString("user_name"));
				u.setPassWord(rs.getString("pass"));
				u.setRole(new Role(rs.getInt("role_id"), rs.getString("role_name")));
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return u;
	}

	public Customer findByUsernameC(String username) {

		Customer u = new Customer();

		Connection conn = Connections.getConnection();

		String sql = "SELECT * FROM customers INNER JOIN roles ON customers.role_id = roles.id WHERE customers.user_name = ? ";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstName(username);
				u.setLastName(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setUserName(rs.getString(5));
				u.setPassWord(rs.getString(6));
				u.setRole(new Role(rs.getInt("role_id"), rs.getString("role_name")));
				u.setBalance(rs.getDouble("balance"));
				u.setAccType(rs.getInt("acc_type"));
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return u;

	}

	public Teller findByUsernameT(String username) {

		Teller u = new Teller();

		Connection conn = Connections.getConnection();

		String sql = "SELECT * FROM employee INNER JOIN roles ON employee.role_id = roles.id WHERE employee.user_name = ? ";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstName(username);
				u.setLastName(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setUserName(rs.getString(5));
				u.setPassWord(rs.getString(6));
				u.setRole(new Role(rs.getInt("role_id"), rs.getString("role_name")));
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return u;

	}

	public BankAdmin findByUsernameB(String username) {

		BankAdmin u = new BankAdmin();

		Connection conn = Connections.getConnection();

		String sql = "SELECT * FROM employee INNER JOIN roles ON employee.role_id = roles.id WHERE employee.user_name = ? ";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstName(username);
				u.setLastName(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setUserName(rs.getString(5));
				u.setPassWord(rs.getString(6));
				u.setRole(new Role(rs.getInt("role_id"), rs.getString("role_name")));
			}

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return u;

	}

	public double withdraw(double amount, int customerId) {

		Connection conn = Connections.getConnection();

		String sql = "UPDATE customers SET balance = balance - ? WHERE id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, customerId);

			ps.executeUpdate(); // this is the line that affects the DB
			// log.info("performed update against DB)

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return amount;

	}

	public double deposit(double amount, int customerId) {

		Connection conn = Connections.getConnection();

		String sql = "UPDATE customers SET balance = balance + ? WHERE id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, customerId);

			ps.executeUpdate(); // this is the line that affects the DB
			// log.info("performed update against DB)

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return amount;

	}


	public int delete(Customer u) {

		int idToDelete = u.getId();

		Connection conn = Connections.getConnection();
		String sql = "DELETE FROM customers WHERE id = " + idToDelete + "";

		return 0;
	}

	public int delete(Teller u) {

		int idToDelete = u.getId();

		Connection conn = Connections.getConnection();
		String sql = "DELETE FROM employee WHERE id = " + idToDelete + "";

		return 0;
	}

	public int delete(BankAdmin u) {

		int idToDelete = u.getId();

		Connection conn = Connections.getConnection();
		String sql = "DELETE FROM employee WHERE id = " + idToDelete + "";

		return 0;
	}

	
}
