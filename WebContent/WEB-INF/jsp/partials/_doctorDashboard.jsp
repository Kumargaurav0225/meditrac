<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DoctorDashboard</title>
<link rel="stylesheet" href="/MediTrac/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/MediTrac/assets/css/bootstrap-paper.min.css" />
<link rel="stylesheet" href="/MediTrac/assets/css/style.css" />
<script src="/MediTrac/assets/js/jquery-2.1.3.min.js"></script>
<script src="/MediTrac/assets/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<img src="/MediTrac/assets/img/logo-meditrac.png"
				class="navbar-brand" />
		</div>
		<div id="bs-example-navbar-collapse-1"
			class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#"">Home</a></li>
				<li><a href="#">Appointments</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Patients
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">List Treated Patients</a></li>
						<li><a href="#">List Following Patients</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				
				<li><a data-toggle="dropdown" href="#" class="dropdown-toggle"><span
						class="glyphicon glyphicon-user nav-icon"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li><a href="#">Account Settings</a></li>
						<li class="divider"></li>
						<li><a href="/MediTrac/dashboard?action=logout">Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 user-dp">
					<img src="/MediTrac/assets/img/a.png" width="160px" height="160px" />
				</div>
				<div class="col-sm-4 user-details">
					<h3>Suman Kumar Das</h3>
					<table class="table">
						<tr>
							<td><h6>Doctor id:</h6></td>
							<td><h6>Gender: 21</h6></td>
						</tr>
						<tr>
							<td><h6>Age: 21</h6></td>
							<td><h6>Date Of Birth: 21</h6></td>
						</tr>
						<tr>
							<td><h6>Specialisation: 21</h6></td>
							<td><h6>Experience: 21</h6></td>
						</tr>
						<tr>
							<td><h6>Email Id: 21</h6></td>
							<td><h6>City: 21</h6></td>
						</tr>
						<tr>
							<td><h6>District: 21</h6></td>
							<td><h6>State: 2</h6></td>
						</tr>
						<tr>
							<td><h6>Phone: 21</h6></td>
							<td><h6></h6></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3">
				<form action="" method="post" class="form-group">
					<input type="text" name="p" placeholder="Search  Treated Patient"
						class="form-control" />
				</form>
			</div>
		</div>
	</div>

</body>
</html>