package in.com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws ClassNotFoundException, Exception  {
		
	try {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
		
		//conn.setAutoCommit(false);;
	
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into employee values (10,'Ankit' , 'Tencent', 100000,1) ");
		i = stmt.executeUpdate("insert into employee values (11,'Ankit' , 'Tencent', 100000,1) ");
		i = stmt.executeUpdate("insert into employee values (12,'Ankit' , 'Tencent', 100000,1) ");
		
		//conn.commit();
		
		conn.close();
		System.out.println("transaction is committed");
		
	}catch(Exception e){
		
		System.out.println("Transaction is rolled back");
	
	}
	}
}
