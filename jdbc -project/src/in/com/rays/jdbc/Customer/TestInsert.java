package in.com.rays.jdbc.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into customer values(10,'Shalini','8256562568','Mohan Nagar')");

		System.out.println("Data insert successfully  " + i);

		conn.close();
	}
}
