package project.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.connectionUtil.*;
import project.service.userService;

public class Test {
	public static void main(String[] args) {
	
	Connection conn = Connections.getConnection();
	
	/*
	 * try { PreparedStatement ps =
	 * conn.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?)");
	 * ps.setInt(1, 1); ps.setString(2, "Brandon"); ps.setString(3,"Mac");
	 * ps.setString(4," null"); ps.setString(5, "56444"); ps.setString(6,
	 * "bnslfsad");
	 * 
	 * ps.executeUpdate(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 */
	
	  userService us = new userService(); 
	  us.register();
	 
	 
}

	
	
}
