<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<title>Welcome</title>
</head>
<body>
<section>
	<div class="jumbotron">
		<div class="container">
			<h1> ${greeting} </h1>
			<p> ${tagline} </p>
		</div>
	</div>

	<div class="caption">
		<p>
			<a href=" <spring:url value="/users" /> "	class="btn btn-primary">
				<span class="glyphicon-info-sign glyphicon"/></span> USERS LIST
			</a>
		</p>
	</div>
</section>
</body>
</html>
