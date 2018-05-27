<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.emp.rest.RestClient" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee list</title>
</head>
<body>
...
<table>
  <c:forEach items="${RestClient.getEmp()}" var="emp">
  <tr>
      <td><c:out value="${emp.id}" /></td><td><c:out value="  " /></td>
      <td><c:out value="${emp.name}" /></td><td><c:out value="  " /></td>
      <td><c:out value="${emp.jobDescription}" /></td><td><c:out value="  " /></td>
      <td><c:out value="${emp.monthSalary}" /></td><td><c:out value=" - " /></td>
      <td><c:out value="${emp.parentId}" /></td>
    </tr>
  </c:forEach>
</table>
...
<br><br/>
<form action="http://localhost:8080/hierarchy/index.jsp">
<input type="submit" value="Back"/>
</form>
</body>
</html>