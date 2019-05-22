<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
message: ${message}<br/>
content: ${content}<br/>

FreeMarker模板引擎
<h1>${resource.name}</h1>
<h1>${resource.website}</h1>
<h1>${resource.language}</h1>
</body>
</html>