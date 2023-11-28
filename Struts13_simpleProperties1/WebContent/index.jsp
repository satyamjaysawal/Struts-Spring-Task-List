<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
    <title>Index Page</title>
</head>
<body>
    <h2>Index Page</h2>

    <html:form action="/greet" method="post" styleId="greetForm">
        <html:text property="name" />
        
        <html:submit value="Submit" />
    </html:form>

</body>
</html>
