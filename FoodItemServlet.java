package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodItemServlet
 */
@WebServlet("/FoodItemServlet")
public class FoodItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String ItemName,result;
		
		//	System.out.println("Value successfully entered.");
			PrintWriter writer = response.getWriter();
			 
			ItemName = request.getParameter("ItemName");
			
			FoodItems food = new FoodItems();
			System.out.println("class instantiated");
			result =	food.insertNewFoodItem(ItemName);
			System.out.println("resulti is obtained too");
			if (result == "success"){
				writer.println("<h3> Submitted successfully</h3>" );
			}
		
			else{
				writer.println("<h3> Not Submitted successfully</h3>" );
				return;
			}
		
		
	}

}
