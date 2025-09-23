package in.com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class UserModel {

	private static String login;

	public int nextPK() throws ClassNotFoundException, SQLException {
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
		
		PreparedStatement pstmt =  conn.prepareStatement("select max(id) from users ");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			pk = rs.getInt(1);
		}
			conn.close();
			
			return pk + 1;
	}
	
	//<------------------------------Add a Record---------------------------------->//
	public void add (UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
		
		conn.prepareStatement("insert into users values (?,?,?,?,?)");
		
		PreparedStatement pstmt =  conn.prepareStatement("insert into users values(?,?,?,?,?)");
		
		int pk = nextPK();
		
		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
//		pstmt.setDate(6,new java.sql.Date(bean.getDob().getTime()));
		
		int i = pstmt.executeUpdate();
		System.out.println("data inserted Successfully"+ i);
		conn.close();
	}
//<*-------------------------Delete a Record---------------------------------*>//

	public void delete(UserBean bean) throws Exception {
		
       Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
		
		conn.prepareStatement("insert into users values (?,?,?,?,?)");
		
		PreparedStatement pstmt = conn.prepareStatement("Delete from users where id =?");
		
		pstmt.setInt(1,bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(" data Delete Successfully ");
		
		conn.close();
	}
	
	//<------------------------Update a Record-----------------------------------*>//
	
	public  void update(UserBean bean) throws Exception {
		
		    Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
			
			conn.prepareStatement("insert into users values (?,?,?,?,?)");
			
			PreparedStatement pstmt = conn.prepareStatement(
					 "update users set firstName = ?, lastName = ?, login = ?, password = ? where id =?");
   
			
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, bean.getId());
			
			int i = pstmt.executeUpdate();
			System.out.println("Data Updated Successfully");
			conn.close();
	}
	
	//<------------------------Find By Login---------------------------------->//
	
	
	public  UserBean findByLogin(String login)  throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
			
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("select * from users where login = ?");
		
		pstmt.setString(1, login);
		
		ResultSet  rs = pstmt.executeQuery();
		
		UserBean bean = null;
		
		while (rs.next()) {
			
			bean = new UserBean();
			
			bean.setId(rs.getInt(1));
			bean.setFirstName("Amit");
			bean.setLastName("Sharma");
			bean.setLogin("amit123");
			bean.setPassword("258635");
		}
		conn.close();
		return bean;
	}
	
}
