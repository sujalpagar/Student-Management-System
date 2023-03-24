<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data Managment</title>
<link type="text/css" rel="stylesheet " href="css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Dr.DY Patil College Of Engineering And Innovation</h2>
		</div>
	</div>
	<div>
		<a href="add-student.jsp">
			<div class="button">
				<br>
				<button type="button" class="btn btn-primary">Add Student</button>
			</div>
		</a>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email ID</th>
					<th>Action</th>
				</tr>
				<tr>
					<!-- Use Loop Featching And Add Data In Table -->
					<c:forEach var="tempStudent" items="${student}">
					
						<!-- SetUp Link Differently For Eash Student -->
						<c:url var="updateLink" value="StudentDataController">
							<c:param name="operation" value="update-student-onScreen"></c:param>
							<c:param name="student-id" value="${tempStudent.id}"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="StudentDataController">
							<c:param name="operation" value="delete-student"></c:param>
							<c:param name="student-id" value="${tempStudent.id}"></c:param>
						</c:url>
						<!-- End -->
						
						<tr>
							<td>${tempStudent.id}</td>
							<td>${tempStudent.fname}</td>
							<td>${tempStudent.lname}</td>
							<td>${tempStudent.email}</td>
							<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>

</body>
</html>