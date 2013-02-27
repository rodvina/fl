<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Forms Library</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/Master.css" />" type="text/css" media="screen" />
</head>
<body>
<h1>
	Forms Library
</h1>


<p>Click <a href="<c:url value="/search" />"/> to start searching</a> now!</p>
<c:out value="${action }"/>
</body>
</html>
