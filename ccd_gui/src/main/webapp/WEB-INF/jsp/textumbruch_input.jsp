<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Textumbruch</title>
</head>
<body>

	<h2>Textumbruch </h2>

	<textarea name="umbruchstext" form="uform" style="width: 600px; height: 150px;">${textfeldinhalt}</textarea> 
	
	<form action="textumbruch_umbrechen" id="uform">
	  Maximalbreite: <input type="text" name="maximalbreite" value="${maximalbreiteinhalt}">
	  <input type="submit">
	</form>


</body>
</html>