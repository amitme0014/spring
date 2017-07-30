<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Login PAGE</h1>
<c:url var="myAction" value="checkLogin.obj" />
<table>
<form:form method="post" modelAttribute="login" action="${myAction}">
<tr>
<td>Enter Name</td>
<td><form:input path="userName"/></td>
<td><form:errors path="userName" style="color:red"/></td>
</tr>
<td>Enter Password</td>
<td><form:password path="password"/></td>
<td><form:errors path="password" style="color:red"/></td>
<tr>
<td colspan="2"><input type="submit" value="Login"/></td>
</tr>
</form:form>
</table>
<br/>
<br/>

New User&nbsp;&nbsp;<a href="showRegister.obj">Click Here</a>

</body>
</html>