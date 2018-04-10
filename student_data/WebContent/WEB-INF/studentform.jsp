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
<h1>Add new Student</h1>
<form:form method="post" action="/student_data/save">
  <table>
   <tr>
     <td>Name :</td>
     <td><form:input path="name"/></td>
   </tr>
                                          
   <tr>
   <td>Course :</td>
   <td><form:input path="course"/></td> 
   </tr>

   <tr>
   <td>Number :</td>
   <td><form:input path="number"/></td>
   </tr>
   
   <tr>
   <td><input type="submit" value="save"/></td>
   </tr>
  </table>

</form:form>




</body>
</html>