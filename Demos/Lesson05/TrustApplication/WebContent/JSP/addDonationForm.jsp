<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donor Application</title>
</head>
<body>
<center>
<h1 style="color:#0066CC">
Welcome to IGate Trust
</h1>
	<br/><br/>
	
<!--This code below displays the form to add a Donation to the database	-->
<h3>Please Enter the Donation Details</h3>
<c:url var="myAction" value="/addDonation.obj"></c:url> 
	<form:form action="${myAction}" method="post" modelAttribute="donor">
	<table bgcolor="#DCDCDC">

		<tr>
			<td>Donor Name:<span style="color:red;">*</span></td>
			<td><form:input path="donorName" /></td>
			<td style="color: red;"><form:errors path="donorName"></form:errors></td>

		</tr>

		<tr>
			<td>Donor Phone Number:<span style="color:red;">*</span></td>
			<td><form:input path="donorPhoneNumber" /></td>
			<td style="color: red;"><form:errors path="donorPhoneNumber"></form:errors></td>

		</tr>

		<tr>
			<td>Donor Address:<span style="color:red;">*</span></td>
			<td><form:input path="donorAddress" /></td>
			<td style="color: red;"><form:errors path="donorAddress"></form:errors></td>

		</tr>

		<tr>
			<td>Donation Amount:<span style="color:red;">*</span></td>
			<td><form:input path="donationAmount" /></td>
			<td style="color: red;"><form:errors path="donationAmount"></form:errors></td>

		</tr>

		
		<tr>
			<td colspan="2"><input type="submit" name="submit"
				value="Add Donation"></input></td>
		</tr>
	</table>

</form:form><br>
<a href="showHomePage.obj">Back To HomePage</a>
</center>
</body>
</html>