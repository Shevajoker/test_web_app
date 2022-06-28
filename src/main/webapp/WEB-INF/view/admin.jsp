<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null }">
			<form action="${contextPath}/logout" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			</form>
			

			<h2>Admin - ${pageContext.request.userPrincipal.name}  |  <a onclick="document.forms['logoutForm'].submit()"> Выход </a></h2>
		</c:if>
	</div>

</body>
</html>