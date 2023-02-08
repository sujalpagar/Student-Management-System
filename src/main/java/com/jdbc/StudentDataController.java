package com.jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Input Operation (add,delete,update,retrive)
		String input = request.getParameter("operation");
		
		//If Input Empty Then Only Show List 
		if (input == null){
			input = "showList";
		}
		
		try {
			//Execute Operation
			switch(input) {
			
				//Retrive Data
				case "showList" :
					listStudent(request, response);
					break;					
				
				//Add Data
				case "add-student" : addStudent(request,response);
					break;
				
				//If Cases Goes Fail It Will Print Student List Only 
				default:
					listStudent(request, response);
				}
			}
		
		//Throw The Error
		catch (Exception e) {
			throw new ServletException(e); 
		}

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Read Student Information From JSP Form 
		int idNo = Integer.parseInt(request.getParameter("id"));
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String mailID = request.getParameter("email");
		
		//Store Data in Student Object
		Student std = new Student(idNo, fName, lName, mailID);
		
		//add Data In Database
		StudentDbCollections.addStudent(std);
		
		//Data Send Back To Main Page
		listStudent(request, response);
		
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Get Data From Helper Class And Set Attribute
		List<Student> std = StudentDbCollections.getStudent();
		request.setAttribute("student", std);

		// content type on web page
		response.setContentType("text");

		// Create Request Dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-studentData.jsp");

		// forword dispatcher
		dispatcher.forward(request, response);

	}

}
