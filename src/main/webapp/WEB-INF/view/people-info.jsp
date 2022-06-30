<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>People Info</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="post" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2> ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()" class="btn btn-outline-primary">Logout</a>
        </h2>
    </c:if>
</div>



	<div class="container" style="margin-top: 50px;">
		<div class="row">
		<div class="col-3">
		<h1>People Information</h1>
		</div>
		
		
		<div class="col-3 text-center">
		<button type="button" class="btn btn-outline-primary" onclick="window.location.href = 'addNewPeople'">Add people</button>
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
  <c:forEach var="people" items="${infos}">
  
  <c:url var="chengePeople" value="/chenge">
  <c:param name="peopleId" value="${people.id}"/>
  </c:url>
  <c:url var="deletePeople" value="/delete">
  <c:param name="peopleId" value="${people.id}"/>
  </c:url>
  
    <tr>
      <th scope="row">${number = number+1 }</th>
      <td> <img alt="photo" src="${contextPath}/${people.imgUrl}" height="25" width="25"></td>
      <td>${people.name}</td>
      <td>${people.surname}</td>
      <td>${people.age}</td>
      
      <td>${people.address}</td>
      <td>${people.message}</td>
      <td> <fmt:formatDate value="${people.birthday}" pattern="dd-MM-yyyy"/> </td>
      <td>
      <a href="${chengePeople}" >
      <img alt="chenge" src="${contextPath}/loadFiles/chenge.png">
      </a>
       / 
       <a href="${deletePeople }">
      <img alt="delete" src="${contextPath}/loadFiles/delete.png"> 
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