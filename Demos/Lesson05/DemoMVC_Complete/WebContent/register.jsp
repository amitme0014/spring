<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Register Page</h1>

<c:url var="myAction" value="checkRegister.obj" />

<table>
<form:form method="post" modelAttribute="user" action="${myAction}">
<tr>
  <td>Enter User Name</td>
  <td><form:input path="userName"/></td>
  <td><form:errors path="userName" cssStyle="color:red"/></td>  
</tr>
<tr>
  <td>Enter Password</td>
  <td><form:input path="password"/></td>
  <td></td>
</tr>

<tr>
<td>Gender</td>
   <td>
    <form:radiobutton path="gender" value="M" label="M" />
    <form:radiobutton path="gender" value="F" label="F" />
   </td>
   <td></td>
</tr>
<tr>
   <td>Enter eMail</td>
   <td><form:input path="email"/></td>
   <td><form:errors path="email" cssStyle="color:red"/></td>
</tr>
<tr>
  <td>Select Skills</td>
  <td><form:checkboxes items="${skillList}" path="skillSet"/></td>
  <td></td>
</tr>
<tr>  
<td>Select Your City</td>
<td>
  <form:select path="city"> 
	<form:option value="" label="Please Select"/>
	<form:options items="${cityList}" />
  </form:select>
</td>
<td></td>
</tr>
<tr>
  <td colspan="3">
  <input type="submit" value="Register"/>
  </td>
</tr>
</form:form>
</table>
</body>
</html>