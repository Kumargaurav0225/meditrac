<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HospitalRegistration</title>
</head>
<body>
	<form name="RegHospital" action="HospitalController?action=register" method="post">
		<div align="center">
			Hospital Name : <input type="username" name="hospitalname" /><br/>

			Hospital Licence: <input type="text" name="hospital_licence" /></br>
 
			Date of Establishment : <input type="text" name="doe" /></br>
 
			Email Id  : <input type="text" name="email" /></br>
 
			Telephone : <input type="text" name="tel" /></br>
			
			City  : <input type="text" name="city" /></br>
 
			District  : <input type="text" name="district" /></br>
			
			State     : <input type="text" name="state" /></br>
			
			Specialities:<input type="text" name="specialities" /></br>
 
			Post Code : <input type="text" name="zip" /></br>
 
		<input type="submit" value="Submit" />
		</div>
	</form>
</body>
</html>