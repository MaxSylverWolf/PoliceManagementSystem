<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<H1>Dane dokumentu</H1>
Id: <b>${document.id}</b><br/>
Nazwa: <b>${document.name}</b><br/>
Nr. sprawy: <b>${document.caseNumber}</b><br/>
Opis: <b>${document.about}</b><br/>
Data przyjęcia <b><fmt:formatDate  value="${document.releaseDate}"  type="date" timeStyle="medium"/></b><br/>
Typ dokumentu: <b>${document.type.name}</b><br/>
Dodatki: <br/>
					<c:choose>
						<c:when test="${empty document.accessories}">
							Brak
						</c:when>
						<c:otherwise>
							<c:forEach items="${document.accessories}" var="accessory" varStatus="stat">
								<c:if test="${stat.index != 0}">
									<br/>
								</c:if>
								${stat.index}. <b>${accessory.name}</b>,
							</c:forEach>
						</c:otherwise>
					</c:choose>
<br/>
<a href="documentList.html">Wstecz</a>
</p>

 </div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>