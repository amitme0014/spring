<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>

<h1>In Login PAGE</h1>
<c:url var="url" value="/afterlogin.html" />
<form:form  modelAttribute="log" action="${url}" method="post">
 <form:label path="userName">Username</form:label>
 <form:input path="userName"/>
 <font color="red"><form:errors path="userName"/></font><br/>
 
 <form:label path="password">Password</form:label>
 <form:input path="password"/>
 <font color="red"><form:errors path="password"/></font><br/>
 
 <input type="submit" value="Login"/>
</form:form>
</body>
</html>