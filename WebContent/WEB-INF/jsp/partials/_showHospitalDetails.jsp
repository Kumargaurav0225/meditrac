<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="proj.meditrac.entities.Member"%>
<%@page import="proj.meditrac.util.Utility"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="proj.meditrac.db.Persistence"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="proj.meditrac.entities.Hospital"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="org.hibernate.criterion.Criterion"%>
<%@ page import="org.hibernate.criterion.Restrictions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<title>Insert title here</title>
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
	<%
		Session sess = Persistence.getSessionFactory().openSession();
		Criteria criteria = sess.createCriteria(Hospital.class);
		Criterion criterionId = Restrictions.eq("insertionId", request.getParameter("id"));
		criteria.add(criterionId);
		Iterator iterator = criteria.list().iterator();
		response.setContentType("text/html");
		while (iterator.hasNext()) {
			Hospital hospital = (Hospital) iterator.next();
	%>
	<div class="container">
		<h2><a href="DoctorController?action=show&id=<%= hospital.getInsertionId() %>"><%=hospital.getHosName()%></a></h2>
		<table class="table table-bordered">
			<tbody>
			<thead>
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
					<td align="right">
						<%
							if (hospital.getVerified().equals("FALSE")) {
						%>
						<form action="dashboard/admin?action=verify" method="post">
							<input type="hidden" name="hosId"
								value="<%=hospital.getInsertionId()%>"> <input
								class="btn btn-sm" type="submit" value="Verify">
						</form> 
						<%
 							} else if ((hospital.getBlacklisted().equals("FALSE"))) {
 						%>
						<form action="dashboard/admin?action=blacklist" method="post">
							<input type="hidden" name="hosId"
								value="<%=hospital.getInsertionId()%>"> <input
								class="btn btn-sm btn-danger" type="submit" value="Blacklist">
						</form> 
						<%
 							} else if ((hospital.getBlacklisted().equals("TRUE"))) {
 						%>
						<form action="dashboard/admin?action=unBlacklist" method="post">
							<input type="hidden" name="hosId"
								value="<%=hospital.getInsertionId()%>"> <input
								class="btn btn-sm btn-success" type="submit" value="UnBlacklist">
						</form> 
						<%
 							}
 						%>
					</td>
					<td>
						<form action="dashboard/admin?action=delete" method="post">
							<input type="hidden" name="hosId"
								value="<%=hospital.getInsertionId()%>"> <input
								class="btn btn-sm btn-warning" type="submit" value="Delete">
						</form>
					</td>
				</tr>

			</thead>
			<%
				}
			%>
			</tbody>
		</table>
	</div>

</body>
</html>