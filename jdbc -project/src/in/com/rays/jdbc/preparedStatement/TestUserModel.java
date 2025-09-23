package in.com.rays.jdbc.preparedStatement;

import java.sql.SQLException;

import in.com.rays.jdbc.TestDelete;

public class TestUserModel {
	
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//TestDelete();
		
		testfindByLogin();
		
	}
  
	//--------------------Add a record-------------------//
	public static void testAdd() throws Exception {
	
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		
		bean.setFirstName("Aisha");
		bean.setLastName("Memon");
		bean.setLogin("aish124@gmail.com");
		bean.setPassword("789456");
		
		model.add(bean);
		
	}
	
	//-------------------Delete a record----------------//
	public static void TestDelete() throws Exception {
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(2);
		
		model.delete(bean);
	}

	//--------------------Update a record--------------------------//
	
	public  static void Testupdate() throws Exception {
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Sajal");
		bean.setLastName("Mirza");
		bean.setLogin("Sajal321@gmail.com");
		bean.setPassword("465123");
		
		model.update(bean);
	}
	
	///<----------------Finf by login--------------------------->//
	
	public static void testfindByLogin() throws Exception {
		

		UserModel model = new UserModel();

		UserBean existsBean = model.findByLogin("lucky@gmail.com");

		if (existsBean != null) {
			
			System.out.println("login id is already exist");
			
		} else {
			System.out.println("no record found");
		}

	}
}
