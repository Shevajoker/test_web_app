<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
	
	<style><%@include file="/WEB-INF/view/css/styleFile.css"%></style>
	

<title>Вход в аккаунт</title>



</head>

<body>

	<div class="container">

		<div class="row justify-content-center">
 
<div class="col-4 ">

			<form:form method="POST" action="${contextPath}/login"
				class="form-signin">
				
				<h2 class="form-heading">Вход</h2>


				<div class="form-group">
<div class="mb-3">
					<input name="username" type="text" class="form-control"
						placeholder="Username" autofocus="true" />
	</div>		
				<div class="mb-3">
						<input name="password"
						type="password" class="form-control" placeholder="Password" /> 
						</div>
						<div class="mb-3 justify-content-center">
						<input
						class="btn btn-lg btn-primary form-control d-grid gap-2" type="submit" value="Вход">
						</div>
					<h4 class="text-center registrationHref">
						<a href="${contextPath}/registration">Зарегистрируйтесь</a>
					</h4>
				</div>
				<div class="mb-3 text-center">
				<c:if test="${message != null}">
					<span class="alert alert-danger form-control">${message}</span>
				</c:if>
				<c:if test="${error != null}">
					<span class="alert alert-danger form-control">${error}</span>
				</c:if>
				</div>
			</form:form>
			</div>

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>