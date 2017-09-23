<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="RegHospital" action="PatientController?action=register" method="post">
		<div align="center">
			Patient Name : <input type="text" name="patientName" /><br/>
			<br/>
 			
 			Gender : <select name="gender">
						  <option value="Male">Male</option>
						  <option value="Female">Female</option>
					</select><br/>
					
			Date of birth : <input type="text" name="dob" /><br/>
 
			Email Id  : <input type="text" name="email" /><br/>
 
			Phone Number : <input type="text" name="phone" /><br/>
			
			City  : <input type="text" name="city" /><br/>
 
			District  : <input type="text" name="district" /><br/>
			
			State     : <input type="text" name="state" /><br/>
			
			Complication:<input type="textarea" name="complication" /><br/>			
 
			Post Code : <input type="text" name="ptc" /><br/>
 
		<input type="submit" value="Submit" />
		</div>
	</form>
</body>
</html>