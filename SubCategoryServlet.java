package ServletPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "For SubCategory", urlPatterns = { "/SubCategoryServlet" })
public class SubCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String cName,result,cId;
		
	//	System.out.println("Value successfully entered.");
		//PrintWriter writer = response.getWriter();
		 
		cName = request.getParameter("SubCategoryName");
		cId = request.getParameter("CategoryId");
		SubCategory scategory = new SubCategory();
		System.out.println("class instantiated");
		result =	scategory.insertNewSubCategory(cName,cId);
		System.out.println("resulti is obtained too");
		if (result == "success"){
			response.sendRedirect("Success.html");
			return;
		}
	
		else{
			response.sendRedirect("index.html");
			return;
		}
	
	}

}
