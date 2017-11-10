package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet (description = "categories" , urlPatterns = {("/CategoryServlet")})
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Value successfully entered.");
		PrintWriter writer = response.getWriter();
		writer.println("<h3>Value submitted successfully. </h3>");
	
	}	*/


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	
		String CategoryName,result;
		
	//	System.out.println("Value successfully entered.");
		PrintWriter writer = response.getWriter();
		 
		CategoryName = request.getParameter("CategoryName");
		
		Category category = new Category();
		System.out.println("class instantiated");
		result =	category.insertNewCategory(CategoryName);
		System.out.println("resulti is obtained too");
		if (result == "success"){
			writer.println("<h3> Submitted successfully</h3>" );
		}
	
		else{
			writer.println("<h3> Not Submitted successfully</h3>" );
			return;
		}
		
	//System.out.println("value accepted " + CategoryName);
		//writer.println("<h3> Submitted successfully</h3>" );
    }

	

}
