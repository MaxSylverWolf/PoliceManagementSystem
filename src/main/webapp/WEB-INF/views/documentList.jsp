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
<H1>LISTA DOKUMENTÓW</H1>

<c:if test="${not empty documents}">
	Lista zawiera ${fn:length(documents)} dokumentów.
	
	<table>
		<tr>
			<th>Id</th>
			<th>Nazwa</th>			
			<th>Nr. sprawy</th>
			<th>Data przyjęcia</th>
			<th>Typ dokumentu</th>
			<th>Dodatki</th>
			<th>Opcje</th>
		</tr>
		<c:forEach items="${documents}" var="document">
			<tr>
				<td>${document.id}</td>
				<td><a href="?id=${document.id}">${document.name}</a></td>
				<td>${document.caseNumber}</td>
				<td><fmt:formatDate  value="${document.releaseDate}"  type="date" timeStyle="medium"/></td>
				<td>${document.type.name}</td>
				<td>
						<c:forEach items="${document.accessories}" var="accessory" varStatus="stat">
								<c:if test="${stat.index != 0}">
									<br/>
								</c:if>
								<b>${accessory.name}</b>,
							</c:forEach>
				</td>				
				<td>
					<a href="?did=${document.id}">Usuń</a>
					<a href="documentForm.html?id=${document.id}">Edytuj</a>
				</td>
			</tr>
			
		</c:forEach>
	</table>
</c:if>

<a href="documentForm.html">Dodaj Nowy</a>
</center>
</div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>