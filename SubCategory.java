package ServletPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class SubCategory extends Category {

	private String SubCategoryId;			//declaring the variables for the category class//
	private String SubCategoryName;
	private String CateId;
	String test = "success";
	
	int pre= 100;
	
	public String insertNewSubCategory (String name, String catId) {
		SubCategoryName = name;
		CateId = catId;
		pre = pre + 100;
					//for auto generating a new category id.//
		SubCategoryId = "CA" + pre;
		
	try {
		 Class.forName("com.mysql.jdbc.Driver"); 
		 System.out.println("Driver loaded!");
		 //1. get a connection to database.
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root" , "root");
		
		//2.create a statement
		Statement mystmt = myconn.createStatement();
		
		//3.execute a SQl query. Insert values in the database table.
		String sql = "INSERT INTO SubCategories "+"(SubCategoryId,CategoryId,SubCategoryName)" + "VAlUES(?,?,?)";
		PreparedStatement ps = myconn.prepareStatement(sql);
		ps.setString(1, SubCategoryId);
		ps.setString(2, CateId);
		ps.setString(3, SubCategoryName);
		ps.executeUpdate();
		
		//ResultSet myrs = mystmt.executeQuery("SELECT * from Categories");
		
		//4.process the result.
		
	/*	while(myrs.next())	
		{
			System.out.println(myrs.getString("CategoryId")+","+myrs.getString("CategoryName"));
		}
*/
	
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
	
			
			
