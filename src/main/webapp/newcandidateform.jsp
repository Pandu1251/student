<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Arcus - Candidate Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">





</head>

<body>

	<%-- <header class="header_3 gradient-bg">
		<nav class="navbar navbar-expand-fmd navbar-dark"
			style="background-color: #1E2C76">
			<div class="navbar-brand">Arcus Candidate Management System</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Candidates List</a></li>
			</ul>
			
			<div class="ml-auto">
				<a href="logout" class="btn btn-danger">Logout</a>
			</div>
		</nav>
	</header> --%>

	<header class="header_3 gradient-bg">
		<nav class="navbar navbar-expand-fmd navbar-dark"
			style="background-color: #1E2C76">

			<div>
				<img src="<c:url value='/images/1.jpg'/>">
			</div>

			<div class="navbar-brand"
				style="font-size: 24px; font-weight: bold; color: #fff;">
				Arcus Candidate Management System</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/RegisterServlet"
					class="nav-link"
					style="color: #fff; font-weight: bold; background-color: #007bff; padding: 10px 20px; border-radius: 5px;">Candidates
						List</a></li>
			</ul>
			<div class="ml-auto">
				<a href="logout" class="btn btn-danger">Logout</a>
			</div>
		</nav>
	</header>






	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


				<form name="myform" action="Iron" method="post">





					<h2>
						<caption>Add New Candidate</caption>
					</h2>





					<fieldset class="form-group">
						<label>Name</label> 
						<input type="text"  class="form-control" name="name" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Gender</label>
						 <input type="text" class="form-control" name="gender" required>
					</fieldset>


					<fieldset class="form-group">
						<label>Email</label> 
						<input type="text" class="form-control" name="email" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Qualification</label> 
						<input type="text" class="form-control" name="qualification" required>
					</fieldset>

					<fieldset class="form-group">
						<label>State</label> 
						<input type="text" class="form-control" name="state" required>
					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>