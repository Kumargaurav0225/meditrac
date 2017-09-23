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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<td><b>Licence Code</b></td>
				<td><b>Name</b></td>
				<td><b>City</b></td>
				<td><b>PIN</b></td>
				<td><b>Options</b></td>
			</tr>
		</thead>
		<tbody>
		<% 
			Session sess=Persistence.getSessionFactory().openSession();
			Criteria criteria = sess.createCriteria(Hospital.class);
			Iterator iterator = criteria.list().iterator();
			response.setContentType("text/html");
			while (iterator.hasNext()){
				Hospital hospital = (Hospital) iterator.next();     
		%>
				<tr>
					<td><%= hospital.getHosCode() %></td>
					<td><a href="HospitalController?action=details&id=<%= hospital.getInsertionId() %>"><%= hospital.getHosName() %></a></td>
					<td><%= hospital.getCity() %></td>
					<td><%= hospital.getZip() %></td>
					<td>
						<%if(hospital.getVerified().equals("FALSE")){ %>
						<form action="dashboard/admin?action=verify" method="post">
							<input type="hidden" name="hosId" value="<%= hospital.getInsertionId() %>">
							<input class="btn btn-sm" type="submit" value="Verify">
						</form>
						<%}else if((hospital.getBlacklisted().equals("FALSE"))){ %>
						<form action="dashboard/admin?action=blacklist" method="post">
							<input type="hidden" name="hosId" value="<%= hospital.getInsertionId() %>">
							<input class="btn btn-sm btn-danger" type="submit" value="Blacklist">
						</form>
						<%}else if((hospital.getBlacklisted().equals("TRUE"))){ %>
							<form action="dashboard/admin?action=unBlacklist" method="post">
							<input type="hidden" name="hosId" value="<%= hospital.getInsertionId() %>">
							<input class="btn btn-sm btn-success" type="submit" value="UnBlacklist">
						</form>
						<% }%>
						<form action="dashboard/admin?action=delete" method="post">
							<input type="hidden" name="hosId" value="<%= hospital.getInsertionId() %>">
							<input class="btn btn-sm btn-warning" type="submit" value="Delete">
						</form>
				</tr>	
		<% 
			}
		%>
		</tbody>
	</table>
</div>
</body>
</html>