<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- forward 시킨 것이므로 http://localhost:8080/member 그대로 나옴 --%>
    <h1><%= request.getAttribute("fullName")%>님 환영합니다.</h1>
    <h2>1. ${name}</h2>
    <h2>1. ${param.name}</h2><%-- parameter --%>
    <h2>1. ${fullName}</h2><%-- request attribute (not from session!!) (우선순위: page > request > session > context) --%>

    <h2>2. ${member}</h2><%-- attribute --%>

    <%-- 동일한 키 값을 가지게 될 경우 작은 영역부터 넓은 영역으로 우선순위를 가진다. --%>
    <%-- page > request > session > context --%>
    <h2>3. ${requestScope.fullName}</h2>
    <h2>3. ${sessionScope.fullName}</h2>
</body>
</html>
