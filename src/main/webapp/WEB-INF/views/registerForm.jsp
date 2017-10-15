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
<h1>Formularz rejestracji oficera</h1></br>
	<table border="1">
		<form:form commandName="register">
			<tr>
				<th>Login: </th>
				<td>
					<form:input path="login"/>
					<form:errors path="login" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Hasło:</th>
				<td>
					<form:input path="password"/>
					<form:errors path="password" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Imię:</th>
				<td>
					<form:input path="name"/>
					<form:errors path="name" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Nazwisko:</th>
				<td>
					<form:input path="surname"/>
					<form:errors path="surname" cssStyle="color:red"/>
				</td>
			</tr>
						<tr>
				<th>Wiek:</th>
				<td>
					<form:input path="age"/>
					<form:errors path="age" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>PESEL:</th>
				<td>
					<form:input path="PESEL"/>
					<form:errors path="PESEL" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Data urodzenia:</th>
				<td>
					<form:input path="birthDate"/>
					<form:errors path="birthDate" cssStyle="color:red"/>
				</td>
			</tr>
			
			<tr>
				<th>Adres zamieszkania:</th>
				<td>
					<form:input path="street"/>
					<form:errors path="street" cssStyle="color:red"/>
				</td>
			</tr>

			<tr>
				<th>Kod pocztowy:</th>
				<td>
					<form:input path="zipcode"/>
					<form:errors path="zipcode" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<th>Miasto:</th>
				<td>
					<form:input path="city"/>
					<form:errors path="city" cssStyle="color:red"/>
				</td>
			</tr>			
			<tr>
				<th>Wzrost:</th>
				<td>
					<form:input path="height"/>
					<form:errors path="height" cssStyle="color:red"/>
				</td>
			</tr>
						<tr>
				<th>Waga:</th>
				<td>
					<form:input path="weight"/>
					<form:errors path="weight" cssStyle="color:red"/>
				</td>
			</tr>
									<tr>
				<th>Stopień:</th>
				<td>
					<form:input path="degree"/>
					<form:errors path="degree" cssStyle="color:red"/>
				</td>
			</tr>
									<tr>
				<th>Ukończona szkoła:</th>
				<td>
					<form:input path="lastSchool"/>
					<form:errors path="lastSchool" cssStyle="color:red"/>
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