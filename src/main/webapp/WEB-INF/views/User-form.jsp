<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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

<title>Save User</title>
</head>

<body>

	<div class="container">

		<h3>Employee Directory</h3>
		<hr>

		<p class="h4 mb-4">User</p>

		<form action="/employeemgmt/employee/saveUser" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${User.id}" />

			<div class="form-inline">
				<input type="text" name="username" value="${User.username}"
					class="form-control mb-4 col-4" placeholder="user name">



			</div>

			<div class="form-inline">

				<input type="text" name="password" value="${User.password}"
					class="form-control mb-4 col-4" placeholder="password">



			</div>


			
			
			<div class="form-check">
  <input class="form-check-input" type="radio" name="role" id="flexRadioDefault1" value = "ADMIN">
  <label class="form-check-label" for="flexRadioDefault1">
    Admin
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="role" id="flexRadioDefault2" value ="USER" checked>
  <label class="form-check-label" for="flexRadioDefault2">
User  </label>
</div>
			
			
			
			
			
	

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/employeemgmt/employee/list">Back to Employees List</a>

	</div>
</body>

</html>









