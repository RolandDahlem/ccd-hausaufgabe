<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Questionnaire</title>
</head>
<body>

	<h2>Fragebogen</h2>

	<form action="questionnaire_absenden" id="uform">
	  Verzeichnispfad: <input type="text" style="width: 600px" name="verzeichnispfad" value="${verzeichnispfad}"> <br/>
	  Suchwort: <input type="text" style="width: 600px" name="suchwort" value="${suchwort}"><br/>
	  <input type="submit">
	</form>

	<textarea name="suchergebnis" form="uform" style="width: 600px; height: 150px;">${suchergebnis}</textarea> 
	
</body>
</html>