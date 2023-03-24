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
	private static Connection con = null;
	private static Statement smt = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	
	//Student Arraylist for Store Student Data from Database	
	public static List<Student> getStudent() throws SQLException{
		List<Student> student = new ArrayList<>();
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		smt = con.createStatement();
		rs = smt.executeQuery("select * from student_table order by last_name");
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);	
			
			//create Student.java Class Object
			Student std = new Student(id, fname, lname, email);
			
			//Add Student In ArrayList
			student.add(std);
			
			 
		}
		//return student arraylist
		return student;
	}

	
	//Add Student In Database Using JDBC
	public static void addStudent(Student std) throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		ps = con.prepareStatement("insert into student_table values(?,?,?,?)");
		ps.setInt(1, std.getId());
		ps.setString(2, std.getFname());
		ps.setString(3, std.getLname());
		ps.setString(4, std.getEmail());
		
		ps.execute();

	}


	public static Student getStudent(String id) throws SQLException {
		
		int idNo = Integer.parseInt(id);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		ps = con.prepareStatement("select * from student_table where id=?");
		ps.setInt(1, idNo);
		rs = ps.executeQuery();
		   
		while(rs.next()) {
			int stdId = rs.getInt(1);
			String stdFname = rs.getString(2);
			String stdLname = rs.getString(3);
			String stdEmail = rs.getString(4);
			
			
			Student std = new Student(stdId, stdFname, stdLname, stdEmail);
			
			return std;
			
		}
		return null;
	}


	public static void updateStudent(Student std) throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		ps = con.prepareStatement("update student_table set first_name=?, last_name=?, email=? where id=?;");
		ps.setString(1, std.getFname());
		ps.setString(2, std.getLname());
		ps.setString(3, std.getEmail());
		ps.setInt(4, std.getId());
		
		ps.execute();
		
	}


	public static String deleteStudent(int id) throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		ps = con.prepareStatement("delete from student_table where id=?");
		ps.setInt(1, id);
		ps.execute();
		return null;
	}

}
