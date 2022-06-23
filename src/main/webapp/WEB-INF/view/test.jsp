<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello</h1>

<p> ${userInfo.name } </p>
<p> ${userInfo.surname } </p>
<p> ${userInfo.age } </p>
<p> ${userInfo.address } </p>
<p> ${userInfo.message } </p>

<p> ${userInfo.imgUrl } </p> 

<p>${fileName }</p>


<p>uploadedFile = ${uploadedFile }</p>

<img alt="img" src="loadFiles/${name}" height="30" width="30">
<br>
<img alt="img2" src="${pageContext.request.contextPath}/loadFiles/${name}" >
<br>
<img alt="img2" src="${userInfo.imgUrl }" >
<br>

</body>
</html>