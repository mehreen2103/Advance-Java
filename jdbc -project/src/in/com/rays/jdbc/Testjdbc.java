package in.com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testjdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1. Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
		
		//3. Create statement
		Statement  stmt =conn.createStatement();
		
		//4. execute query and get resultset
		ResultSet rs= stmt.executeQuery("select * from employee");
		
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" +rs.getString(3));
			System.out.print("\t" +rs.getInt(4));
			System.out.println("\t" +rs.getInt(5));
			
			
		}
		
		conn.close();
	}

}
