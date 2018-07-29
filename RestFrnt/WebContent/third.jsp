<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.io.*" %>
 <%@page import="com.emp.rest.RestClient" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee list</title>
		<meta charset="utf-8">
		<style type="text/css">
		  
			.node {
		    cursor: pointer;
		  }
		
		  .overlay{
		      background-color:#EEE;
		  }
		   
		  .node circle {
		    fill: #fff;
		    stroke: steelblue;
		    stroke-width: 1.5px;
		  }
		   
		  .node text {
		    font-size:10px; 
		    font-family:sans-serif;
		  }
		   
		  .link {
		    fill: none;
		    stroke: #ccc;
		    stroke-width: 1.5px;
		  }
		
		  .templink {
		    fill: none;
		    stroke: red;
		    stroke-width: 3px;
		  }
		
		  .ghostCircle.show{
		      display:block;
		  }
		
		  .ghostCircle, .activeDrag .ghostCircle{
		       display: none;
		  }
		
		</style>
		<script type="text/javascript"></script>
		<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
		<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="dndTree.js"></script> 
</head>
<body>
...
<table>
  <c:forEach items="${RestClient.getAllEmp()}" var="emp">
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

<div id="tree-container"></div>

</body>
</html>