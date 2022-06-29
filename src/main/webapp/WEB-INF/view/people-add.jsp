<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>





<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add People</title>
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
				<h1>Add new people.</h1>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 50px">
		<div class="row justify-content-center">





			<div class="col-3">



				<form:form id="savePeopleForm" method="POST" action="${contextPath}/savePeople"  modelAttribute="peopleInfo"
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
					<input type="date" class="form-control" name="birthday" value="${peopleInfo.birthday}"/>
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
						<c:if test="${peopleInfo.imgUrl != null}">
							<img alt="photo" src="${peopleInfo.imgUrl}" height="25" width="25">
							<br>
						</c:if>
						<input type="file" name="img" class="form-control" accept="image/jpeg,image/png,image/gif" id="inp"
							value="${peopleInfo.imgUrl }" />
					</div>
					
					
					
					<input type="submit" class="btn btn-outline-success" value="Сохранить">
					<a class="btn btn-outline-danger"
						href="${contextPath}/info">Закрыть</a>
				</form:form>


			</div>


		</div>
	</div>


<script type="text/javascript">
const dT = new DataTransfer();
dT.items.add(new File(['foo'], '${peopleInfo.imgUrl }'));
inp.files = dT.files;
</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>