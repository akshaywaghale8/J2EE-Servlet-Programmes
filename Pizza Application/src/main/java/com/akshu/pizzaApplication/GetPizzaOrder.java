package com.akshu.pizzaApplication;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GetPizzaOrder
 */
public class GetPizzaOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPizzaOrder() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserBean ub = new UserBean();
		ub.setName(request.getParameter("name"));
		ub.setAddress(request.getParameter("address"));
		ub.setAppetizer(request.getParameter("appetizer"));
		ub.setCardNumber(request.getParameter("cardNumber"));
		ub.setCrust(request.getParameter("crust"));
		ub.setToppings(request.getParameterValues("toppings"));
		ub.setCardType(request.getParameter("cardType"));
		
		request.setAttribute("userBean", ub);
		
		 RequestDispatcher rd = request.getRequestDispatcher("showOrder.jsp");
		rd.forward(request, response);
	}

}
