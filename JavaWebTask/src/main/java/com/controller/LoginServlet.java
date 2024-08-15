package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.dao.CustomerDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("customerID"));
		System.out.println(request.getParameter("password"));
		if (request.getParameter("customerID") != null && request.getParameter("password") != "") {
			int customerID = Integer.parseInt(request.getParameter("customerID"));
			System.out.println("Customer id " + customerID);
			HttpSession session = request.getSession();
			session.setAttribute("customerID", customerID);
			String customerPassword = request.getParameter("password");
			System.out.println("Customer Password " + customerPassword);
			Customer customer = new Customer(customerID, customerPassword);
			String result = null;
			try {
				result = CustomerDao.validateLogin(customer);
				System.out.println("Result " + result);
				if (result == null) {
					request.setAttribute("status", "wrongPassword");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} else {
					session.setAttribute("customerName", result);
					response.sendRedirect("home.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		} else {
			request.setAttribute("fieldEmpty", "true");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
