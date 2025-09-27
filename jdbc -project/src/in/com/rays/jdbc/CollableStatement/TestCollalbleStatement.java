package in.com.rays.jdbc.CollableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestCollalbleStatement {

	public static void main(String[] args) throws ClassNotFoundException, Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
		
		CallableStatement cbst = conn.prepareCall("{CALL searchEmployee()}");
		
		ResultSet rs = cbst.executeQuery();
		
		while (rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getInt(2));
		}
	}

}

