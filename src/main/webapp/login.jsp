<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	text-align: center;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	font-weight: bold;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	padding: 10px 15px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

.error-message {
	color: red;
}
</style>
</head>
<body>

	<header>

		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #1E2C76">

			<div>
				<%-- <img src="<c:url value='/images/1.jpg'/>"> --%>
				<img src="<%= request.getContextPath() %>/images/1.jpg">

			</div>

			<div class="navbar-brand">Arcus Candidate Management System</div>




		</nav>
	</header>
	<div class="container">
		<h2>Login</h2>
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<label for="username">Username:</label> 
				<input type="text" id="username" name="username" required>
			</div>

			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" id="password" name="password" required>
			</div>

			<div class="form-group">
				<input type="submit" value="Login">
			</div>
		</form>

		<%
		if (request.getAttribute("loginFailed") != null) {
		%>
		<p class="error-message">Login failed. Please check your
			credentials.</p>
		<%
		}
		%>
	</div>
</body>
</html>
