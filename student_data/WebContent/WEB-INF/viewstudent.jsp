<%@page import="org.json.JSONObject"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student List</h1>

<table border="2" width="70%" cellpadding="2">

   <tr>
   <th>ID</th>
   <th>NAME</th>
   <th>COURSE</th>
   <th>NUMBER</th>
   </tr>
<c:forEach var="st" items="${list}">
   <tr>
   <td>${st.id}</td>
   <td>${st.name}</td>
   <td>${st.course}</td>
   <td>${st.number}</td>
   <td><a href="/student_data/delete/${st.id }">delete</a></td>
   </tr> 


</c:forEach>
</table><br>
<a href="studentform">add new student</a>
</body>
</html>