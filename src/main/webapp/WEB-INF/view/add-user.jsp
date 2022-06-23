<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-3">
				<h1>Add new user.</h1>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 50px">
		<div class="row justify-content-center">





			<div class="col-3">



				<form:form action="saveUser" modelAttribute="userInfo"
					enctype="multipart/form-data">
					<form:hidden path="id" />

					<div class="mb-3">
						<form:label path="name" class="form-label">Имя</form:label>
						<form:input path="name" class="form-control" />
					</div>

					<div class="mb-3">
						<form:label path="surname" class="form-label">Фамилия</form:label>
						<form:input path="surname" class="form-control" />
					</div>

					<div class="mb-3">
						<form:label path="age" class="form-label">Возраст</form:label>
						<form:input path="age" class="form-control" />
					</div>
					<div class="mb-3">
					<label class="form-label">Дата рождения</label>
					<input type="date" class="form-control"/>
					</div>

					<div class="mb-3">
						<form:label path="address" class="form-label">Адрес</form:label>
						<form:input path="address" class="form-control" />
					</div>

					<div class="mb-3">
						<form:label path="message" class="form-label">Сообщение</form:label>
						<form:textarea path="message" class="form-control" />
					</div>


					<div class="mb-3">
						<c:if test="${userInfo.imgUrl != null}">
							<img alt="photo" src="${userInfo.imgUrl}" height="25" width="25">
						</c:if>
						<input type="file" name="img" class="form-control"
							value="${userInfo.imgUrl }" />
					</div>

					<button type="submit" class="btn btn-outline-success">Сохранить</button>
					<a class="btn btn-outline-danger"
						href="${pageContext.request.contextPath}/users">close</a>
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