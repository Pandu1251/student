<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Arcus - Candidate Management System</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        </head>

        <body>

	<header>

		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #1E2C76">

			<div>
				<img src="<c:url value='/images/1.jpg'/>">
			</div>

			<div class="navbar-brand">Arcus Candidate Management System</div>

			<!-- <ul class="navbar-nav ml-auto">
            Add the Logout button here
            <li class="nav-item">
                <a href="logout" class="nav-link">Logout</a>
            </li>
      		  </ul> -->

			<!-- 	  <div class="container text-right">
                   <a href="logout" class="btn btn-danger">Logout</a>
			  </div> -->
			<!--  <div class="container text-left">
   					 <a href="logout" class="btn btn-danger">Logout</a>
					</div> -->

			<div class="ml-auto">
				<a href="out" class="btn btn-danger">Logout</a>

			</div>


		</nav>
	</header>
	<br>
            

            <div class="row">
            

                <div class="container">
                    <h3 class="text-center">Candidates List</h3>
                    <hr>
                  
                    <div class="container text-left">
                    <a href="/Newjspproject/newcandidateform.jsp" class="btn btn-success">Add New Candidate</a>

             	      
                    </div>
                    
                 <!--    <div class="container text-left">
             	     <a href="LogoutServlet" class="btn btn-success">Logout</a>
                    </div> -->
                   
                    
                    
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                 <th>Gender</th>
                                  <th>Email</th>
                                <th>Qualification</th>
                                <th>State</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                       
                            <c:forEach var="candidate" items="${listCandidate}">

                                <tr>
                                    <td>
                                        <c:out value="${candidate.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidate.name}" />
                                    </td>
                                      <td>
                                        <c:out value="${candidate.gender}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidate.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidate.qualification}" />
                                    </td>
                                    
                                     <td>
                                        <c:out value="${candidate.state}" />
                                    </td>
                                    
                                    <td>
                                   
                                    
                                   <a href="fire?id=<c:out value='${candidate.id}' />" class="btn btn-primary">Edit</a>

								   <a href="water?id=<c:out value='${candidate.id}' />" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this candidate?');">Delete</a>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>
        