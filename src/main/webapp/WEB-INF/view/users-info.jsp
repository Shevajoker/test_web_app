<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users Info</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

	<div class="container" style="margin-top: 50px;">
		<div class="row">
		<div class="col-3">
		<h1>Users Information</h1>
		</div>
		
		
		<div class="col-3 text-center">
		<button type="button" class="btn btn-outline-primary" onclick="window.location.href = 'addNewUser'">Add</button>
		</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
		<div class="col">
		<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Photo</th>
      <th scope="col">Name</th>
      <th scope="col">Surname</th>
      <th scope="col">Age</th>
      <th scope="col">Address</th>
      <th scope="col">Message</th>
      <th scope="col">Birthday</th>
      <th scope="col">-/-</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${infos}">
  
  <c:url var="chengeUserInfo" value="/chenge">
  <c:param name="userInfoId" value="${user.id}"/>
  </c:url>
  <c:url var="deleteUserInfo" value="/delete">
  <c:param name="userInfoId" value="${user.id}"/>
  </c:url>
  
    <tr>
      <th scope="row">${number = number+1 }</th>
      <td> <img alt="photo" src="${user.imgUrl}" height="25" width="25"></td>
      <td>${user.name}</td>
      <td>${user.surname}</td>
      <td>${user.age}</td>
      
      <td>${user.address}</td>
      <td>${user.message}</td>
      <td>${user.birthday}</td>
      <td>
      <a href="${chengeUserInfo}" >
      <img alt="chenge" src="${pageContext.request.contextPath}/loadFiles/chenge.png">
      </a>
       / 
       <a href="${deleteUserInfo }">
      <img alt="delete" src="${pageContext.request.contextPath}/loadFiles/delete.png"> 
      </a>
      </td>

      
    </tr>
    </c:forEach>
  </tbody>
</table>
		</div>
		</div>
	</div>





	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>