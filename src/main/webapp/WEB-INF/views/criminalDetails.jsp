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
							
<H1>Dane sprawcy: </H1>
Id: <b>${criminal.id}</b><br/>
Imię: <b>${criminal.name}</b><br/>
Nazwisko: <b>${criminal.surname}</b><br/>
Wiek: <b>${criminal.age}</b><br/>
PESEL: <b>${criminal.PESEL}</b><br/>
Data urodzenia <b><fmt:formatDate  value="${criminal.birthDate}"  type="date" timeStyle="medium"/></b><br/>
Typ: <b>${criminal.type.name}</b><br/>
Adres zamieszkania: <b>${criminal.streetAddr}</b><br/>
Kod pocztowy: <b>${criminal.zipcode}</b><br/>
Miasto: <b>${criminal.cityName}</b><br/>
Narodowość: <b>${criminal.country}</b><br/>
Kolor skóry: <b>${criminal.skinColor}</b><br/>
Kolor oczu: <b>${criminal.eyesColor}</b><br/>
Kolor włosów: <b>${criminal.hairColor}</b><br/>
Fryzura: <b>${criminal.hair}</b><br/>
Wzrost: <b>${criminal.height}</b><br/>
Waga: <b>${criminal.weight}</b><br/>
Opis: <b>${criminal.profile}</b><br/>
Zawód: <b>${criminal.profession}</b><br/>
Miejsce pracy: <b>${criminal.job}</b><br/>
Ukończona szkoła: <b>${criminal.lastSchool}</b><br/>
<br/>
<a href="criminalList.html">Wstecz</a>


							 </div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>