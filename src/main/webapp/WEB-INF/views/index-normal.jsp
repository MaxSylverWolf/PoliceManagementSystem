<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sklep z grami</title>
<c:set var="context" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${context}/css/style.css" />
</head>
<body>
	<div id="background">
		<div id="header">
			<div>
				<div>
					<a href="index.html" class="logo"><img src="images/logo.png" alt=""></a>
					<ul>
						<li class="selected">
							<a href="index.html" id="menu1">Strona główna</a>
						</li>
						<li>
							<a href="gameListUser.html" id="menu2">Lista Gier</a>
						</li>
						<li>
							<a href="gameForm.html" id="menu3">Kup grę</a>
						</li>
						<li>
							<a href="home.html" id="menu4">Zaloguj się</a>
						</li>
						<li>
							<a href="homeADMIN.html" id="menu5">Panel Admina</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="body">
			<div>
				<div>
					<div class="featured">
						<img src="images/featured-game.png" alt="">
					</div>
					<div class="section">
						<div>
							<h3>Strona główna</h3>
							<div>
								<p>

Witamy na stronie sklepu z grami.

<P>  Czas serverowy: ${serverTime}. </P>

</p>

							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div>

				<p>
					SylverWolf @ copyright 2017. All rights reserved.
				</p>
			</div>
		</div>
	</div>
</body>
</html>