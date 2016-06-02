<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Textumbruch</title>
</head>
<body>

	<h2>Minesweeper </h2>

	<textarea name="minenfeld" form="uform" style="width: 600px; height: 150px;">${minenfeld}</textarea> 
	
	<form action="minesweeper_loesen" id="uform">
	  <input type="submit">
	</form>

	<textarea name="mogelzettel" form="resultform" style="width: 600px; height: 150px;">${mogelzettel}</textarea> 
	
</body>
</html>