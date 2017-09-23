<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoctorRegistration</title>
</head>
<body>
	<form name="RegHospital" action="DoctorController?action=registerDoctor&id="<%=request.getParameter("id") %> method="post">
		<div align="center">
			doctorName : <input type="username" name="doctorName" /><br/>
			<br/>
 			
 			Gender : <select name="gender">
						  <option value="Male">Male</option>
						  <option value="Female">Female</option>
					</select><br/>
					
			Specialisation:<input type="textarea" name="Specialisation" /><br/>		
			
			Experience:<input type="text" name="experience" /><br/>	
 
					
			Date of birth : <input type="text" name="dob" /><br/>
 
			Email Id  : <input type="text" name="email" /><br/>
 
			Phone Number : <input type="text" name="phone" /><br/>
			
			City  : <input type="text" name="city" /><br/>
 
			District  : <input type="text" name="district" /><br/>
			
			State     : <input type="text" name="state" /><br/>
			
			Post Code : <input type="text" name="ptc" /><br/>
 
		<input type="submit" value="Submit" />
		</div>
</body>
</html>
