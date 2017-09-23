<%@page import="java.util.ArrayList"%>
<%@page import="proj.meditrac.entities.Hospital"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<title>Hey See This</title>
</head>
<body>
	<div class="container">
		<h1>Search</h1>
		<form class="form-inline" action="AdminController">
			<input type="hidden" name="action" value="search">
			<div class="form-group">
				<input type="text" class="form-control" name="query"
					placeholder="Search">
			</div>
			<div class="form-group">
				<select class="form-control" name="searchType">
					<option value="hosName">Hospital Name</option>
					<option value="state">State</option>
					<option value="city">City</option>
					<option value="email">Email</option>
					<option value="district">District</option>
					<option value="specialities">Specialities</option>
					<option value="zip">Postal Code</option>
					<option value="Telephone">Telephone</option>
					<option value="hosCode">Hospital Licence</option>
				</select>
			</div>
			<button class="btn btn-primary" type="submit" class="form-control">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
		</form>

		<div>
			<%
				List<Hospital> hospitals = null;
				if (request.getAttribute("list") != null) {
					hospitals = (List<Hospital>) request.getAttribute("list");
					for (Hospital hospital : hospitals) {
			%>

			<div class="container">
				<h2 align="center"><%=hospital.getHosName()%></h2>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td><b>Hospital Licence</b></td>
							<td><%=hospital.getHosCode()%></td>
						</tr>
						<tr>
							<td><b>Date of Establishment</b></td>
							<td><%=hospital.getDate()%></td>
						</tr>
						<tr>
							<td><b>Email Id</b></td>
							<td><%=hospital.getEmail()%></td>
						</tr>
						<tr>
							<td><b>Telephone</b></td>
							<td><%=hospital.getTelephone()%></td>
						</tr>
						<tr>
							<td><b>State</b></td>
							<td><%=hospital.getState()%></td>
						</tr>
						<tr>
							<td><b>City</b></td>
							<td><%=hospital.getCity()%></td>
						</tr>
						<tr>
							<td><b>District</b></td>
							<td><%=hospital.getDistrict()%></td>
						</tr>
						<tr>
							<td><b>Postal Code</b></td>
							<td><%=hospital.getZip()%></td>
						</tr>
						<tr>
							<td><b>Specialist</b></td>
							<td><%=hospital.getSpecialities() %></td>
						</tr>
					</tbody>
				</table>
			</div>
			<%
				}
			}
			%>
		</div>
	</div>
</body>
</html>