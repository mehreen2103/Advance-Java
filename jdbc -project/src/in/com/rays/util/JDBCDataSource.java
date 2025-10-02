package in.com.rays.util;

import java.beans.PropertyVetoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//Step 1:- Make class final so child can not be created.
public final class JDBCDataSource {
	
	
	//Step 2:- Make self type of private static variable/attribute, static variable/attribute have one copy in there life time
		private static JDBCDataSource datasource = null;
	
		private static ComboPooledDataSource cpds= null;
		
    // Step 3:- Make default constructor private so other class can not be create instance of this class  	
	private JDBCDataSource() {
		
	}
	
	//Step 4:- Make a getInstance method, getInstance method return same type of instance
	
	private static JDBCDataSource getInstance() {
		if (datasource == null) {
			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			
			ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
			
			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("Password"));
				datasource.cpds.setAcquireIncrement(Integer.parseInt("acquireIncrement"));
				datasource.cpds.setInitialPoolSize(Integer.parseInt("initialPoolSize"));
				datasource.cpds.setMaxPoolSize(Integer.parseInt("maxPoolSize"));
				datasource.cpds.setMinPoolSize(Integer.parseInt("minPoolSize"));
			} catch ( PropertyVetoException e) {
				e.printStackTrace();
			}
					
		}
		
		return datasource;
		
		
}
	public static Connection getConnection() throws SQLException {
		return getInstance().cpds.getConnection();
		
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	public static void trnrollback(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}