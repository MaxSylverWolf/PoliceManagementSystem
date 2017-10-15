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
							

<c:choose>
<c:when test="${not empty logInSession}">
<span style="color:green">Jesteś zalogowany jako <b>${logInSession.login}</b></span>
  <ul id="promobox">

    <li class="two">
    <ul>
<li><a href="criminalList.html">Lista sprawców</a><br/></li>
<li><a href="#">Lista spraw</a><br/></li>
<li><a href="documentList.html">Lista dokumentów</a><br/></li>
<li><a href="registerList.html">Lista oficerów</a><br/></li>
<li><a href="criminalForm.html">Dodaj sprawcę</a><br/></li>
<li><a href="#">Dodaj sprawę</a><br/></li>
<li><a href="documentForm.html">Dodaj dokument</a><br/></li>
<li><a href="registerForm.html">Dodaj oficera</a><br/></li>
<li><a href="logout.html">Wyloguj</a></li>
</ul>

    </li>
  </ul>
</c:when>
<c:otherwise>
<span style="color:red">Panel administratora, aby przeglądać zasoby musisz się najpierw zalogować.</span>
  <ul id="promobox">

    <li class="two">
    <ul>
<li><a href="logonADMINForm.html">Zaloguj</a></li>
</ul>

    </li>
  </ul>
</c:otherwise>
</c:choose>

 </div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>