<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>

<spring:url value="css/bootstrap.css" var="bootStrap"></spring:url>
<spring:url value="js/bootstrap.min.js" var="bootStrapJS"></spring:url>
<spring:url value="js/jquery.min.js" var="jquery"></spring:url>

<link rel="stylesheet" href="${bootStrap}">
<script src="${jquery}"></script>
<script src="${bootStrapJS}"></script>
</head>
<body>
	<div class="container-fluid">


		<h1 class="well">Employee Directory</h1>



		<form:form class="form-horizontal" modelAttribute="employee"
			action="save.html" method="post">
			<div class="form-group">
				<label for="fname" class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-5">
					<form:input path="firstName" class="form-control" id="fname" required="true" placeholder="First Name" />
				</div>
			</div>
			<div class="form-group">
				<label for="lname" class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-5">
					<form:input path="lastName" class="form-control" id="lname" required="true" placeholder="Last Name" />
				</div>
			</div>
			<div class="form-group">
				<label for="desig" class="col-sm-2 control-label">Designation</label>
				<div class="col-sm-5">
					<form:select class="form-control" path="designation" required="true">
						<form:option value="">Please Select Designation</form:option>
						<form:options items="${designations}" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="salary" class="col-sm-2 control-label">Salary</label>
				<div class="col-sm-5">
					<form:input path="salary" class="form-control" id="salary" required="true" placeholder="Salary" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-default">Add</button>
				</div>
			</div>
		</form:form>
		<!-- alert logic -->
		<c:if test="${param.message ne null}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${param.message}
			</div>
		</c:if>
		
		<h3 class="well">Current List of Employees:</h3>
		<c:if test="${empList ne null}">
			<table class="table table-bordered">
				<tr class="info">
					<th>#</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Designation</th>
					<th>Salary</th>
				</tr>
				<c:forEach items="${empList}" var="employee">
					<tr>
						<th>${employee.employeeId}</th>
						<th>${employee.firstName}</th>
						<th>${employee.lastName}</th>
						<th>${employee.designation}</th>
						<th>${employee.salary}</th>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>