package project.connectionUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connections {
	
	public static Connection getConnection() {
		
		
	Connection con = null;
	Properties prop = new Properties();
	
	try {
		prop.load(new FileReader("C:\\Users\\Mac\\Desktop\\NewSpringTools\\project.revature\\src\\test\\resources\\application.properties"));
		
		con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Created");
	return con;
		
	}
	
	
}
