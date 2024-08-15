package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.dao.CustomerDao;

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("id"));
		out.println(request.getParameter("id"));
		
//		try {
			String customerID = request.getParameter("id");
			String customerName = request.getParameter("name");
			String customerEmail = request.getParameter("email");
			String customerPassword = request.getParameter("password");
			String customerAddress = request.getParameter("address");
			String customerContact = request.getParameter("contact");
			PrintWriter printWriter = response.getWriter();
			printWriter.println("Your id is " + customerID + " Email is " + customerEmail + " and password is " + customerPassword + " " + customerAddress + " " +
					customerContact + " " + customerName);
			if(CustomerDao.validateEmail(customerEmail) && CustomerDao.validatePassword(customerPassword) &&
					CustomerDao.validateFields(request.getParameter("id"), customerName, customerPassword, customerAddress, customerContact)) {
				
				request.setAttribute("status", "success");
				request.setAttribute("customerID", customerID);
				String encryptedPassword = CustomerDao.encrypt(customerPassword);
				Customer customer = new Customer(Integer.parseInt(customerID), customerName, customerEmail, encryptedPassword, 
						customerAddress, customerContact);
				CustomerDao.registerCustomer(customer);
				RequestDispatcher rDispatcher = request.getRequestDispatcher("/register.jsp");
				rDispatcher.forward(request, response);
			}
			else if(!CustomerDao.validateFields(request.getParameter("id"), customerName, customerPassword, customerAddress, customerContact)) {
				request.setAttribute("status", "fillDetails");
				RequestDispatcher rDispatcher = request.getRequestDispatcher("/register.jsp");
				rDispatcher.forward(request, response);
			}
			else if(!CustomerDao.validateEmail(customerEmail)) {
				request.setAttribute("status", "emailError");
				RequestDispatcher rDispatcher = request.getRequestDispatcher("/register.jsp");
				rDispatcher.forward(request, response);
			}
			else if(!CustomerDao.validatePassword(customerPassword)) {
				System.out.println(customerPassword);
				request.setAttribute("status", "passwordError");
				RequestDispatcher rDispatcher = request.getRequestDispatcher("/register.jsp");
				rDispatcher.forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
