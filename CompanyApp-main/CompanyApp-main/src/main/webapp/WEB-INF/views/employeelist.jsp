<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 

    <h1 align="center">employee list</h1>
    <div align="left">
		<form action="search" method="get">
		<table>
		<tr>
		<td>Search</td>
		<td><input type="text" name="id"></td>
		</tr>
		<tr>
		<td><input type="submit" value="search"></td>
		</tr>
		</table>
		</form>
	</div>
     
    <div align="center">
        <table>
           <tr>
            <th>Name</th>
            <th>ProjectDetails</th>
            <th>Mail Id</th>
            <th>phone number</th>
           </tr>
            <c:forEach items="${employeeList}" var="emp">
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.project}</td>
                    <td>${emp.mailId}</td>
                    <td>${emp.phoneNo}</td>
                    <td><a href="updateEmployee?employeeId=${emp.employeeId}">edit</a>
                    <td><a href="deleteEmployee/${emp.employeeId}">delete</a>
                </tr>
            </c:forEach>
        </table>
    </div>
    
</body>
</html>