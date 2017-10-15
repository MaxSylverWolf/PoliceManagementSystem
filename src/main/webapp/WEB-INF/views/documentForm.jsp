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
<center>
<h1>Formularz dodawania dokumentu do sprawy</h1></br>
	<table border="1">
		<form:form commandName="document">
			<tr>
				<th>Nazwa: </th>
				<td>
					<form:input path="name"/>
					<form:errors path="name" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Opis:</th>
				<td>
					<form:input path="about"/>
					<form:errors path="about" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Nr. sprawy:</th>
				<td>
					<form:input path="caseNumber"/>
					<form:errors path="caseNumber" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Data przyjęcia:</th>
				<td>
					<form:input path="releaseDate"/>
					<form:errors path="releaseDate" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Dodatki:</th>
				<td>
					<form:checkboxes items="${accessories}" path="accessories" itemValue="id" itemLabel="name" delimiter="<br>"/>
					<form:errors path="accessories" cssStyle="color:red"/>
				</td>
			</tr>

			<tr>
				<th>Typ dokumentu:</th>
				<td>
					<form:select path="type.id" items="${documentTypes}" itemLabel="name" itemValue="id"/>
				</td>
			</tr>		
			<tr><td colspan="2"><input type="submit" value="Wyślij"></td></tr>
		</form:form>
	</table></center>	
</div>

</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>