package in.com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1. Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/adv","root","root");
		
		//3. Create statement
		Statement  stmt =conn.createStatement();
		
		//4. execute query and get resultset
		int i = stmt.executeUpdate("delete from table( )");
		
		System.out.println("Data deleted successfully" + i );
		 
		conn.close();
  }
}
