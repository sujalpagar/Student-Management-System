package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDbCollections {
	
	
	//Student Arraylist for Store Student Data from Database	
	public static List<Student> getStudent() throws SQLException{
		List<Student> student = new ArrayList<>();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from student_table order by last_name");
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);	
			
			//create Student.java Class Object
			Student std = new Student(id, fname, lname, email);
			
			//Add Student In ArrayList
			student.add(std);
			
			 //return student arraylist
		}
		return student;
	}

	
	//Add Student In Database Using JDBC
	public static void addStudent(Student std) throws SQLException {
		
		Connection con = null;
		PreparedStatement smt = null;
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		smt = con.prepareStatement("insert into student_table values(?,?,?,?)");
		smt.setInt(1, std.getId());
		smt.setString(2, std.getFname());
		smt.setString(3, std.getLname());
		smt.setString(4, std.getEmail());
		
		smt.execute();

	}

}
