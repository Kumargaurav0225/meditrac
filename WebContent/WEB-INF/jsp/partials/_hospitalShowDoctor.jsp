<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="proj.meditrac.entities.Doctor"%>
<%@page import="proj.meditrac.entities.Hospital"%>
<%@page import="proj.meditrac.util.Utility"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="proj.meditrac.db.Persistence"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="org.hibernate.criterion.Criterion"%>
<%@ page import="org.hibernate.criterion.Restrictions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
<style>
	form {width:100px;margin:0px;display:inline-block;}
	form input[type="submit"] {width:100px;}
</style>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Meditrac</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Home</a></li>
                <li><a href="#">Facilities</a></li>
                <li><a href="#">Sitemap</a></li>
                <li><a href="#">About</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Hello Sam</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
	<h1>Verification Requests</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<td><b>Doctor Name</b></td>
				<td><b>Specialisation</b></td>
				<td><b>State</b></td>
				<td><b>City</b></td>
				<td><b>District</b></td>
				<td><b>PIN</b></td>
				<td><b>Experience</b></td>
				<td><b>DOB</b></td>
				<td><b>Email</b></td>
				<td><b>Gender</b></td>
				<td><b>Phone</b></td>
				<td>Options</td>
			</tr>
		</thead>
		<tbody>
		<% 
			Session sess=Persistence.getSessionFactory().openSession();
			Criteria criteria = sess.createCriteria(Doctor.class);
			Criterion criterionId = Restrictions.eq("reffId", 102);
			criteria.add(criterionId);
			Iterator iterator = criteria.list().iterator();
			response.setContentType("text/html");
			while (iterator.hasNext()){
				Doctor doctor = (Doctor) iterator.next();     
		%>
				<tr>
					<td><%= doctor.getdoctorName() %></td>
					<td><%= doctor.getSpecialisation() %></td>
					<td><%= doctor.getState() %></td>
					<td><%= doctor.getCity()%></td>
					<td><%= doctor.getDistrict() %></td>
					<td><%= doctor.getPtc() %></td>
					<td><%= doctor.getExperience()%></td>
					<td><%= doctor.getDob()%></td>
					<td><%= doctor.getEmail() %></td>
					<td><%= doctor.getGender() %></td>
					<td><%= doctor.getPhone()%></td>
					<td>
						<form name="RegDoctor" action="HospitalController?action=delete" method="post">
							<input type="hidden" name="id" value="<%= doctor.getdID() %>">
							<input class="btn btn-sm btn-warning" type="submit" value="Delete">
						</form>
					</td>
				</tr>	
				
		<% 
			}
		%>
		</tbody>
	</table>
</div>
</body>
</html>