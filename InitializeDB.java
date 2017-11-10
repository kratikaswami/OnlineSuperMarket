package ServletPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDB {

		
	
	
	public boolean deleteDatabase () {
		
		
	try {
		 Class.forName("com.mysql.jdbc.Driver"); 
		 System.out.println("Driver loaded!");
		 //1. get a connection to database.
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root" , "root");
		
		//2.create a statement
		Statement mystmt = myconn.createStatement();
		
		//3.execute a SQl query. Insert values in the database table.
		String sql = "DROP DATABASE sampledb";
		PreparedStatement ps = myconn.prepareStatement(sql);
		ps.executeUpdate();
		
		ResultSet myrs = mystmt.executeQuery("SHOW DATABASES");
		
		//4.process the result.
		
	
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
	
	return true;
	
	}
}
