<%@ page pageEncoding="utf-8"%>
<%
    String basePath = 
            request.getScheme() + "://" + 
            request.getServerName() + ":" + 
            request.getServerPort() + 
            request.getContextPath() + "/";
%>
<!doctype html>
<html>
    <head>
        <base href="<%= basePath%>">
        <meta charset="utf-8">
    </head>
    <body>
        <h1>服务器升级维护中</h1>
        <a href="home">返回首页</a>
    </body>
</html>