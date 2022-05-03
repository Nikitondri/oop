<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 01.04.2022
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="controller" method="POST">
        <select name="CHOICE_TARIFF">
            <option value="CHILD_TARIFF">child tariff</option>
            <option value="FULL_UNLIMITED_TARIFF">full unlimited tariff</option>
            <option value="LIMIT_TARIFF">limit tariff</option>
            <option value="PENSION_TARIFF">pension tariff</option>
            <option value="UNLIMITED_INTERNET_TARIFF">unlimited internet tariff</option>
            <option value="UNLIMITED_MIN_TARIFF">unlimited min tariff</option>
        </select>
        <button type="submit" name="command" value="ADD_TARIFF">Add</button>
    </form>
    <form action="controller" method="POST">
        <input type="text" name="INDEX">
        <button type="submit" name="command" value="REMOVE_TARIFF">Delete</button>
    </form>
    <form action="controller" method="POST">
        <input type="text" name="INDEX">
        <input type="text" name="NAME_TARIFF">
        <button type="submit" name="command" value="SET_TARIFF">Set</button>
    </form>
    <form action="controller" method="POST">
        <input type="text" name="FILE_NAME">
        <button type="submit" name="command" value="SAVE_FILE">Save</button>
    </form>
    <table border="1">
        <tr>
            <td>Tariffs</td>
        </tr>
        <c:forEach items="${tariffs}" var="tarriff">
            <tr>
                <td> <c:out value="${tarriff}"/> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
