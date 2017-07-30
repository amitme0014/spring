<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login PAGE</h1>

<c:url var="myAction" value="/checkLogin.obj" />

<form:form action="${myAction}" modelAttribute="login" method="get">
Enter Name <form:input path="userName"/><br/>
Enter Password <form:input path="password"/><br/>
<input type="submit" value="Login"/>
</form:form>
</body>
</html>