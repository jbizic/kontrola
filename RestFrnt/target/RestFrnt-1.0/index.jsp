<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees form</title>
</head>
<body>

<form action="http://localhost:8080/RestBack/webapi/myresource" method="post">
Name:<br/>
<input type="text" name="name"/><br><br/>
Job desription:<br/>
<input type="text" name="jobDescription"/><br><br/>
  Month salary:<br/>
  <input type="text" name="monthSalary"/><br><br/>
<input type="submit" value="Save"/>
</form><br/>
<form action="http://localhost:8080/hierarchy/third.jsp">
<input type="submit" value="Employees list"/>
</form>
</body>
</html>