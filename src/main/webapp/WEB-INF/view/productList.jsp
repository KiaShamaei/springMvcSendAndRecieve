
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>produt List ...</h1>
<ul>
    <c:forEach var="item" items="${list}">
        <li id="${item.id}">${item.name}</li>
    </c:forEach>
</ul>

</body>
</html>
