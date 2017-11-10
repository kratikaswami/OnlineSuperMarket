package ServletPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class FoodItems {

	
			private String FoodItemId;				// Declaring the variables related to the food items. // 
			private String Name;
			
						
			
			public String test = "success";
			int pre=100;
			
			public String insertNewFoodItem (String name) {
				Name = name;
				pre = pre + 10;
							//for auto generating a new category id.//
				FoodItemId = "FI" + pre;
				
			try {
				 Class.forName("com.mysql.jdbc.Driver"); 
				 System.out.println("Driver loaded!");
				 //1. get a connection to database.
				Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root" , "root");
				
				//2.create a statement
				Statement mystmt = myconn.createStatement();
				
				//3.execute a SQl query. Insert values in the database table.
				String sql = "INSERT INTO FoodItems "+"(FoodItemId,Name)" + "VAlUES(?,?)";
				PreparedStatement ps = myconn.prepareStatement(sql);
				ps.setString(1, FoodItemId);
				ps.setString(2, Name);
				ps.executeUpdate();
				
				ResultSet myrs = mystmt.executeQuery("SELECT * from FoodItems");
				
				//4.process the result.
		/*		
				while(myrs.next())	
				{
					System.out.println(myrs.getString("CategoryId")+","+myrs.getString("CategoryName"));
				}
*/
			
			}
//			catch (ClassNotFoundException e) {
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
