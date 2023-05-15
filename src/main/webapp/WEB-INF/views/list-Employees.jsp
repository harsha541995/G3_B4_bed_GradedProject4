<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Employees Directory</title>
</head>

<body>

	<div class="container">

		<h3>Employees Directory</h3>
		<hr>

		<!-- Add a search form -->


				<div class="card-body">
			<form action="/employeemgmt/employee/search" method="POST">
				<input type="text" name="searchText" style="width:80%;" placeholder="Enter text to search" />
				<button type="submit" class="btn btn-primary">
					Search
				</button>
			</form>
		</div>


		<form action="/employeemgmt/books/search" class="form-inline">

			<!-- Add a button -->
			<a href="/employeemgmt/employee/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Employee </a> 
				
				<a href="/employeemgmt/employee/showFormForAddUser"
				class="btn btn-primary btn-sm mb-3 mx-auto"> Add User </a> 
				
			<a href="/employeemgmt/logout" 
					class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a> 



		</form>
		
		

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Employees}" var="tempEmployee">
					<tr>
						<td><c:out value="${tempEmployee.firstName}" /></td>
						<td><c:out value="${tempEmployee.lastName}" /></td>
						<td><c:out value="${tempEmployee.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/employeemgmt/employee/showFormForUpdate?employeeId=${tempEmployee.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/employeemgmt/employee/delete?employeeId=${tempEmployee.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>


