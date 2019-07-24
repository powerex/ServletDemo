<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сесії</title>

</head>
<body>

<p><c:out value = "${requestScope.dataForView}"/></p>

<br />
<form method="post" action="">
    <input type="text" name="data" />
    <input type="submit" value="Надіслати" />
</form>

</body>
</html>