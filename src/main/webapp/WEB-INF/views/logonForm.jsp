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
<center>
  <div id="newsbox">
  Zaloguj się do systemu. </br>
  <p>
<H1><fmt:message key="logonForm.label"/></H1>
<h3></h3>
	<form:form commandName="logonCommand">
		<table>
		<tr><th><fmt:message key="logonForm.login"/></th>
			<td>
				<form:input path="login" /><form:errors path="login" cssStyle="color:red;"/>
			</td>
		</tr>
		<tr>	
			<th><fmt:message key="logonForm.password"/></th>
			<td>
				<form:password path="password" /><form:errors path="password" cssStyle="color:red;"/>
			</td>
		</tr>
		<tr>	
			<th></th>
			<td>
				<form:checkbox path="remember" />
					&nbsp; <b><fmt:message key="logonForm.remember"/></b>
					
			</td>
		</tr>		
		<tr><td colspan="2"><input type="submit" value="<fmt:message key="logonForm.submit"/>"></td></tr>	
		</table>	
	</form:form>	
</p>
 </div>
</center>
</div>
<div id="footer">
  <p class="left">Copyright &copy; SylverWolf DW, Grzegorz Wodzyński 2017 <a href="index.html">System policyjny</a> - All Rights Reserved</p>
  <div style="clear:both;">&nbsp;</div>
</div>

</html>