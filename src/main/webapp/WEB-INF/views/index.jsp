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
  <div id="header"> 
  <a href="#"><img src="images/logopolice.png" alt="" class="logo"/></a>
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
  <ul id="promobox">
    <li>
      <h3>Podstawy systemu:</h3>

      <ul>
        <li>Logowanie administratora</li>
        <li>Logowanie oficera</li>

      </ul>

    </li>
    <li class="two">
      <h3>Ponadto system umożliwia:</h3>

      <ul>
        <li>Rejestrację spraw w systemie</li>
        <li>Dodawanie dokumentów do sprawy</li>
        <li>Rejestrację sprawców w systemie</li>

      </ul>

    </li>
    <li class="three">
      <h3>Oraz:</h3>

      <ul>
        <li>Nadawanie stopnia oficerowi</li>
		<li>Sprawne przeglądanie zasobów</li>
		<li>Połączenie z badą danych</li>
      </ul>

    </li>
  </ul>
  <div id="newsbox">

<h3>Witamy na stronie głównej systemu policyjnego</h3>
        <p>System ma za zadanie wspierać przeglądanie zasobów policyjnych i usprawniać działania policyjne.</p>
    <p></p>    

  </div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>