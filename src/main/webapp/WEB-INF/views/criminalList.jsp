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
<H1>LISTA SPRAWCÓW</H1>

<c:if test="${not empty criminals}">
	Lista zawiera ${fn:length(criminals)} sprawców.
	
	<table>
		<tr>
			<th>Id</th>
			<th>Imię</th>			
			<th>Nazwisko</th>
			<th>PESEL</th>
			<th>Data urodzenia</th>
			<th>Typ</th>
			<th>Adres zamieszkania</th>
			<th>Kod pocztowy</th>
			<th>Miasto</th>			
			<th>Opcje</th>
		</tr>
		<c:forEach items="${criminals}" var="criminal">
			<tr>
				<td>${criminal.id}</td>
				<td><a href="?id=${criminal.id}">${criminal.name}</a></td>
				<td>${criminal.surname}</td>
				<td>${criminal.PESEL}</td>		
				<td><fmt:formatDate  value="${criminal.birthDate}"  type="date" timeStyle="medium"/></td>
				<td>${criminal.type.name}</td>	
				<td>${criminal.streetAddr}</td>
				<td>${criminal.zipcode}</td>
				<td>${criminal.cityName}</td>
				<td>
					<a href="?did=${criminal.id}">Usuń</a>
					<a href="criminalForm.html?id=${criminal.id}">Edytuj</a>
				</td>
			</tr>
			
		</c:forEach>
	</table>
</c:if>
<a href="criminalForm.html">Dodaj Nowy</a>
</center>
</div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>