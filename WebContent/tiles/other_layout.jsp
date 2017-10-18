<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<head>
<title>Knot</title>
<link rel="stylesheet" href="css/footer.css?ver=0" type="text/css">
<link rel="stylesheet" href="css/other_header.css?ver=0" type="text/css">
<link rel="stylesheet" href="css/other_reset.css?ver=0" type="text/css">
<style type="text/css">

	html, body {
	height: 100%; 
	width: 100%;
	margin: 0;
	padding: 0; 
	overflow-x:hidden; overflow-y:auto;
}

ul, ul li {
	list-style: none;
}

#container {
width:960px;
margin-left: auto;
margin-right: auto;
padding: 0;
}

.clear {
clear: both;
margin: 0;
padding: 0;
}

p {
margin: 1.6em 0;
line-height: 1.6em;
}

h2 {
font-size: 20px;
line-height: 20px;
margin: 22px 0 18px 0;
}

.bodyForm {
	width: 80%;
	height: auto;
	margin: 50px auto;
}

</style>

</head>
<body>
	
	
	<ul>
		<li class="head">
			<tiles:insertAttribute name="header" />
		</li>
		<li class="body">
			<div class="bodyForm">
					<tiles:insertAttribute name="body" />
			</div>
		</li>
		<li class="foot">
			<tiles:insertAttribute name="footer" />		
		</li>
	</ul>
</body>
</html>