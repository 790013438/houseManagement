<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>Hello, ${name}!</h1>
        <ul>
            <c:forEach items="${fruits}" var="fruit">
                <li>${fruit}</li>
            </c:forEach>
        </ul>
    </body>
</html>
