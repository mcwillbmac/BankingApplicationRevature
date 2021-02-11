package project.connectionUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import jdk.internal.org.jline.utils.Log;

public class Connections {
	
	
	private static Logger log = Logger.getLogger(Connection.class);
	
	public static Connection getConnection() {
		
		
	Connection con = null;
	Properties prop = new Properties();
	
	try {
		prop.load(new FileReader("C:\\Users\\Mac\\Desktop\\NewSpringTools\\project.revature\\src\\test\\resources\\application.properties"));
		
		con = DriverManager.getConnection
				(prop.getProperty("url"), 
				prop.getProperty("username"), 
				prop.getProperty("password"));
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("no connection.");
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	System.out.println("We are live in the database.");
	System.out.println();
	System.out.println();
	
	return con;
		
	}
	
	
}
