package ServletPackage;

import java.sql.*;
//import java.util.Scanner;

public class Category {

	
	private String CategoryId;			//declaring the variables for the category class//
	private String CategoryName;
	public String test = "success";
	int pre=23000;
	
	public String insertNewCategory (String name) {
		CategoryName = name;
		pre = pre + 1000;
					//for auto generating a new category id.//
		CategoryId = "CA" + pre;
		
	try {
		 Class.forName("com.mysql.jdbc.Driver"); 
		 System.out.println("Driver loaded!");
		 //1. get a connection to database.
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root" , "root");
		
		//2.create a statement
		Statement mystmt = myconn.createStatement();
		
		//3.execute a SQl query. Insert values in the database table.
		String sql = "INSERT INTO Categories "+"(CategoryId,CategoryName)" + "VAlUES(?,?)";
		PreparedStatement ps = myconn.prepareStatement(sql);
		ps.setString(1, CategoryId);
		ps.setString(2, CategoryName);
		ps.executeUpdate();
		
		ResultSet myrs = mystmt.executeQuery("SELECT * from Categories");
		
		//4.process the result.
		
		while(myrs.next())	
		{
			System.out.println(myrs.getString("CategoryId")+","+myrs.getString("CategoryName"));
		}

	
	}
//	catch (ClassNotFoundException e) {
	//    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
	//}
 
	catch (SQLException e) {
	            e.printStackTrace();
	}
	catch(Exception exc){
		exc.printStackTrace();
	}
	
	return test;
	} 
	
	
	
}
	
	
	
	
	

	


