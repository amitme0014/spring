<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>

<body>
	<h2>Spring MVC file upload example</h2>
 	<form:form method="post" action="save.html"
        modelAttribute="uploadForm" enctype="multipart/form-data">
 		Please select a file to upload : 
 		<input type="file" name="file" />
		<input type="submit" value="upload" />
		<span><form:errors path="file" cssClass="error" />
		</span>

	</form:form>

</body>
</html>