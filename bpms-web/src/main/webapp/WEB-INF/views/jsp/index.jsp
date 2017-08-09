<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring MVC Servlet 3.0</title>
</head>
	<body>
		<h2>Spring has found ...</h2>
		<c:choose>
			<c:when test="${not empty items}">
				<ul>
					<c:forEach var="item" items="${items}">
						<li>${item.description}</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<h6>Nothing</h6>
			</c:otherwise>
		</c:choose>
	</body>
</html>