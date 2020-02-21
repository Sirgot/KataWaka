<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
    <head>
        <title>WakaHome</title>
        <link rel="stylesheet" type="text/css" href="c:url value'/resources/waka.Css' />" >
    </head>
    <body>
        <h1>Waka home</h1>
<%--        Link to other pages pag 166--%>
<%--        <a href="<c:url value='../resources/waka.css' />" >Waka</a>--%>
<%--        <a href="<c:url value='/waka/input' />" >Waka</a>--%>
    <form id="WakaHome" action="" method="post" >
        <h1>Something in the form</h1>
        <h2>${message}</h2>
    </form>
    </body>
</html>