<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>Index</h1>
<%--${saludo} // permite retornar en raw las variables--%>
<p>
    Mensaje: ${saludo}
</p>

<hr>
<ul>
<c:forEach items="${productos}" var="producto">
    <li>
            ${producto.nombre}
    </li>
</c:forEach>
</ul>
</body>
</html>
