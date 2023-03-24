<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h1 style="text-align: center;">Add Student Form</h1>
		<br> <br>
	</div>
	<div>
		<div class="container col-md-6">
			<form action="StudentDataController" method="get">
				<div>
					<input type="hidden" name="operation" value="add-student">
				</div>
				<div class="form-group row">
					<label for="Student-id" class="col-sm-3 col-form-label">Enter
						ID : </label>
					<div class="col-sm-6">
						<input type="text" id="form2Example2" name="id"
							class="form-control" placeholder="ID" required="required"/>
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="Student-First-Name" class="col-sm-3 col-form-label">Enter
						First Name : </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="inputPassword"
							name="fname" placeholder="First Name" required="required">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="Student-Last-Name" class="col-sm-3 col-form-label">Enter
						Last Name : </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="inputPassword"
							name="lname" placeholder="Last Name" required="required">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="Stuent-Mail-Id" class="col-sm-3 col-form-label">Enter
						Email Id :</label>
					<div class="col-sm-6">
						<input type="email" class="form-control" id="inputPassword"
							name="email" placeholder="Email Id" required="required">
					</div>
				</div>
				<br>
				<div>
					<input value="Submit" type="submit" button type="button"
						class="btn btn-primary" style="width: 75%;"> </input>
				</div>
				<br> <br> <br>
				<div class="container">
					<a href="view-studentData.jsp">
						<button type="button" class="btn btn-secondary btn-lg btn-block"
							style="width: 70%">Back To Home</button>
					</a>
				</div>
			</form>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>