<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>System policyjny</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${context}/css/default.css" />
</head>
<body>

<div id="container">
  <div id="header"> <a href="#"><img src="images/logopolice.png" alt="" class="logo"/></a>
    <ul id="toplinks">
      <li><a href="homeADMIN.html">Panel admina</a></li>
    </ul>
  </div>
  <div id="nav">
    <ul>
      <li><a href="index.html">Strona Główna</a></li>
      <li><a href="#"></a></li>
    </ul>
    <ul class="right">
      <li><a href="home.html"><strong>Panel oficera</strong></a></li>
    </ul>
  </div>
  <div id="topbox">
    <div id="tbleft">
      <h4>Witamy w systemie policyjnym</h4>
    </div>

  </div>

  <div id="newsbox">
<center>
<H1>LISTA OFICERÓW</H1>

<c:if test="${not empty registers}">
	Lista zawiera ${fn:length(registers)} oficerów.
	
	<table>
		<tr>
			<th>Login</th>
			<th>Hasło</th>			
			<th>Imię</th>
			<th>Nazwisko</th>
			<th>Ulica</th>
			<th>Kod pocztowy</th>
			<th>Miasto</th>
			<th>Opcje</th>
>
		</tr>
		<c:forEach items="${registers}" var="register">
			<tr>
				<td><a href="?id=${register.id}">${register.login}</a></td>
				<td>${register.password}</td>
				<td>${register.name}</td>
				<td>${register.surname}</td>
				<td>${register.street}</td>
				<td>${register.zipcode}</td>
				<td>${register.city}</td>				
				<td>
					<a href="?did=${register.id}">Usuń</a>
					<a href="registerForm.html?id=${register.id}">Edytuj</a>
				</td>
			</tr>
			
		</c:forEach>
	</table>
</c:if>
<a href="registerForm.html">Dodaj Nowy</a>
</center>
</div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>