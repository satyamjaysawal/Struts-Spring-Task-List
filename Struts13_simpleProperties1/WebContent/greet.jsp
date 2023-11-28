<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
<title>Greeting Page</title>
</head>
<body>
	<h2>Greeting Page</h2>
	<p>${requestScope.greetingMessage} +"hii "+${name}</p>
	<p>${name}</p>



</body>
</html>
