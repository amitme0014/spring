<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donors Application</title>
</head>
<body>
<center>
<h1 style="color: #0066CC">IGate Trust</h1>
</center>
<c:url var="myAction" value="viewDonation.obj"></c:url>
<form:form action="${myAction}" method="post" modelAttribute="donor">
	<center>
	<h2>Enter the Donation ID</h2>
	<br>
	<form:input path="donorId"></form:input> <br>
	<input type="submit" value="Search" /></center>
</form:form>

<c:if test="${isFirst!=true}">
	<u>
	<h2 align="center">Donor Information</h2>
	</u>
	<table border="1" align="center">
		<tr>
			<th bgcolor="bisque">Donor Id</th>
			<th bgcolor="bisque">Donor Name</th>
			<th bgcolor="bisque">Address</th>
			<th bgcolor="bisque">Phone Number</th>
			<th bgcolor="bisque">Donated Amount(in Rs.)</th>
			<th bgcolor="bisque">Donation Date</th>
		</tr>
		<tr>
			<td><c:out value="${dBean.donorId}" /></td>
			<td><c:out value="${dBean.donorName}" /></td>
			<td><c:out value="${dBean.donorAddress}" /></td>
			<td><c:out value="${dBean.donorPhoneNumber}" /></td>
			<td><c:out value="${dBean.donationAmount}" /></td>
			<td><c:out value="${dBean.donationDate}" /></td>
		</tr>
		<tr>
			<td colspan="5" align="center"><a href="showHomePage.obj.obj">Click
			Here To Go to Home</a></td>
		</tr>
	</table>

</c:if>
</body>
</html>