package in.com.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBCDataSource {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 100; i++) {
			testsearch();
			System.out.println("No. of connection: " + i);
		}
	}
	
	public static void testsearch() {
		
		Connection conn = null;
		
		try {
			
		conn = 	JDBCDataSource.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs =  stmt.executeQuery("select * from user where id = 1");
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
