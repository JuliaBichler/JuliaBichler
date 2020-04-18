package web;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBManager;  

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = request.getRequestDispatcher("loginpage./register");
		
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n=request.getParameter("usernamesignup");  
		String p=request.getParameter("passwordsignup"); 
		System.out.println(n);
		System.out.println(p);
		
		try
		{
			DBManager.getInstance().registerUser(n,p);
			response.sendRedirect("loginpage.jsp");

		} 
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
			RequestDispatcher d = request.getRequestDispatcher("loginpage.jsp");
			
			d.forward(request, response);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			RequestDispatcher d = request.getRequestDispatcher("loginpage.jsp");
			
			d.forward(request, response);
		}
    }
}


