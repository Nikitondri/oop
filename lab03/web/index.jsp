<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 01.04.2022
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <form action="controller" method="post">
          <button class="buttonStart" type="submit" name="command" value="CREATE_TABLE">Create</button>
      </form>
      <form action="controller" method="post" enctype='multipart/form-data'>
          <button class="buttonStart" type="submit" name="command" value="LOAD_FILE">Load</button>
          <input type="file" name="file" accept=".json" readonly>
      </form>
  </body>
</html>
