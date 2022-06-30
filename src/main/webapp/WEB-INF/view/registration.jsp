<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<style><%@include file="/WEB-INF/view/css/styleFile.css"%></style>

<title>Регистрация</title>
</head>
<body>

<div class="container">

<div class="row justify-content-center">
<div class="col-4">

<form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-heading">Регистрация аккаунта.</h2>
        
        <div class="mb-3">
        <spring:bind path="username">
            
                <form:input  type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                            <div class="form-text">Более 3 и менее 20 символов</div>
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>
        </div>
<div class="mb-3">
        <spring:bind path="password">
            
                <form:input   type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <div class="form-text">Более 6 и менее 20 символов</div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
</div>
<div class="mb-3">
        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input   type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>
</div>
<div class="mb-3">
        <button class="btn btn-lg btn-primary form-control" type="submit">Зарегистрировать</button>
        </div>
    </form:form>
    <div class="mb-3 text-center">
    <a href="login">У меня уже есть аккаунт.</a>
    </div>
    </div>
    </div>

    
</div>
</body>
</html>