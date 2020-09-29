<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practice week #1: Student Management</title>
</head>

<body>
	<!-- List of students section -->
	<div align="left">
        <table border="1" cellpadding="5">
            <caption><h2>List of students</h2></caption>
            <tr>
                <th>Name</th>
                <th>Math</th>
                <th>English</th>
                <th>Physical</th>
                <th>GPA</th>
            </tr>
            
            <%-- <c:forEach items="${listStudent}" var="student">
                <tr>
                    <td><c:out value="${student.getName()}" /></td>
                    <td><c:out value="${student.getMathScore()}" /></td>
                    <td><c:out value="${student.getEnglishScore()}" /></td>
                    <td><c:out value="${student.getPhysicalScore()}" /></td>
                    <td><c:out value="${student.getGPA()}" /></td>   
                </tr>
            </c:forEach> --%>
        </table>
    </div>
    <!-- Special students's information section -->
	<%-- <p>Largest GPA: ${smartestStudent.getName()}</p>
	<p>Lowest GPA: ${stupidStudent.getName()}</p> --%>
	<p>JSON: ${listStudent}</p>
	<h3>Add new student</h3>
	<form action="index" method="post">
		<p>Name: </p>
        <input type="text" name="studentNameInput">
        <p>Age: </p>
        <input type="text" name="studentAgeInput">
        <p>Classes: </p>
        <input type="text" name="studentClassesInput">
        <p>Province: </p>
        <input type="text" name="studentProvinceInput">
        <p>Math score: </p>
        <input type="text" name="mathScoreInput">
        <p>English score: </p>
        <input type="text" name="englishScoreInput">
        <p>Physical score: </p>
        <input type="text" name="physicalScoreInput">
        <input type="submit"/>
	</form>
	</body>
</html>