package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InitializeDBServlet")
public class InitializeDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean result;
		
	
		PrintWriter writer = response.getWriter();
		 
		
		
		InitializeDB indb = new InitializeDB(); 
		System.out.println("class instantiated");
		result = indb.deleteDatabase();
		System.out.println("result is obtained too");
		if (result){
			writer.println("<h3> Deleted successfully</h3>" );
			return;
		}
	
		else{
			writer.println("<h3> Not Deleted successfully</h3>" );
			return;
		}
	}

}
