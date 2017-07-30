<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
th {
	color: grey;
	font-size: 16pt;
}
</style>
</head>
<body>
<center>
<h1 style="color:#0066CC">
IGate Trust
</h1><br>
<h1>Donors List</h1>

<table border=1>
	<tr>
		<th bgcolor="bisque">Donor Id</th>
		<th bgcolor="bisque">Donor Name</th>
		<th bgcolor="bisque">Phone Number</th>
		<th bgcolor="bisque">Donor Address</th>
		<th bgcolor="bisque">Donated Amount</th>
		<th bgcolor="bisque">Date of Donation</th>
	</tr>
	<c:forEach var="donorList" items="${list}">
		<tr>
			<td>${donorList.donorId}</td>
			<td>${donorList.donorName}</td>
			<td>${donorList.donorPhoneNumber}</td>
			<td>${donorList.donorAddress}</td>
			<td>${donorList.donationAmount}</td>
			<td>${donorList.donationDate}</td>
		</tr>
	</c:forEach>
	<tr>
			<td colspan="5" align="center"><a href="showHomePage.obj.obj">Click
			Here To Go to Home</a></td>
		</tr>
</table>
</center>
</body>
</html>