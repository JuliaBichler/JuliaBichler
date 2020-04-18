package web;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBManager;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = request.getRequestDispatcher("loginpage");
		
		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String n=request.getParameter("username");  
		String p=request.getParameter("password");
		System.out.println(n);
		System.out.println(p);
		p.toString();
		
		try
		{
			if(DBManager.getInstance().userExists(n, p)==true)
			{
				System.out.println("User erfolgreich eingeloggt");
				HttpSession session = request.getSession();
				session.setAttribute("user", n);
				
				RequestDispatcher d = request.getRequestDispatcher("index.jsp");
				
				d.forward(request, response);
			}
			else
			{
				RequestDispatcher d = request.getRequestDispatcher("loginpage.jsp");
				
				d.forward(request, response);
			}
		} catch (SQLException e)
		{
			System.out.println("catch1");
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			System.out.println("catch2");
			e.printStackTrace();
		}	
	}
}
