package com.jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
			
				//1] Retrive Data
				case "showList" :
					listStudent(request, response);
					break;					
				
				//2] Add Data
				case "add-student" : 
					addStudent(request,response);
					break;
					
				//3] Update Data
				case "update-student-onScreen" : 
					updateStudent(request,response);
					break;
				
				case "update-student-inDb":
					updateStudentDb(request,response);
					break;
					
				//4] Delete Student
				case "delete-student" :
					deleteStudent(request,response);
					
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

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Get Student ID
		int id = Integer.parseInt(request.getParameter("student-id"));
		
		//Delete From Database
		String std = StudentDbCollections.deleteStudent(id);
		
		//Back To Main Page
		listStudent(request, response);
		
	}

	private void updateStudentDb(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Get Data From Form
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		
		//Add Data In Student Class
		Student std = new Student(id, fname, lname, email);
		
		//Update Student In Database 
		StudentDbCollections.updateStudent(std);
		
		//After Update Open Student View Page 
		listStudent(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		// Read Student Id From Form
		String idNo = request.getParameter("student-id");
		
		//student data
		Student std = StudentDbCollections.getStudent(idNo);
		
		//set Attribute
		request.setAttribute("student", std);
		
		//dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-student.jsp");
		dispatcher.forward(request, response);
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
