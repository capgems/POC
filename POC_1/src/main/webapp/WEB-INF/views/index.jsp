<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html ng-app="Application">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<c:url value='static/assets/js/angular.js' />" ></script>
 <script src="<c:url value='static/assets/js/angular-route.js' /> "></script>

<script src="<c:url value='static/assets/js/jquery-3.3.1.js' /> "></script>
<script src="<c:url value='static/assets/js/material.js' /> "></script>
<link rel="stylesheet" href="static/assets/css/material.css">
<link rel = "stylesheet"  href = "https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="<c:url value='static/assets/js/index.js' />" ></script> 
<link rel="stylesheet" href="static/app/modules/org/org.css	" />
 <script src="<c:url value='static/app/modules/org/orgcontroller.js' /> " type="text/javascript"></script>
  <script src="<c:url value='static/app/modules/login/login.js' /> " type="text/javascript"></script>
 <link rel="stylesheet" href="static/app/modules/login/login.css	" />
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.3.0/material.blue-red.min.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.3/angular-animate.js"></script>
 
</head>
<body ng-controller="ApplicationController">
	<!-- MDL navigation container -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">


		  <header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<!-- Title of the Header -->
				<span class="mdl-layout-title">Title(Fixed Header)</span>
				<!-- Spacer, to align items to right -->
				<div class="mdl-layout-spacer"></div>
				<!-- Navigation links, hidden on smaller displays -->
				<nav class="mdl-navigation mdl-layout--large-screen-only">
				<a class="mdl-navigation__link" href="#!login">Sign On/Sing Up</a>
					<a class="mdl-navigation__link" href="">Plans</a> <a
						class="mdl-navigation__link" href="#!org">Organisation</a> <a
						class="mdl-navigation__link" href="">Best Seller</a> <a
						class="mdl-navigation__link" href="">New Policies</a>
				</nav>
			</div>
		</header>

		<!-- Drawer container -->
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">Planets</span>
			<!-- navigation Container, with links -->
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="">Plans</a> <a
						class="mdl-navigation__link" href="#!org">Organisation</a> <a
						class="mdl-navigation__link" href="">Best Seller</a> <a
						class="mdl-navigation__link" href="">New Policies</a>
			</nav>
		</div>


		<main class="mdl-layout__content">
		<div class="page-content">
		<div ng-view></div>
		</div>
		</main>
<input id="logins" type="hidden" value="${login}" />
	</div>
</body>
</html>

<script>
var val = $('#logins').val();
if(val){
	window.location = "#!login";
}
</script>