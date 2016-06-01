<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Questionnaire</title>
</head>
<body>

	<h2>Fragebogen</h2>

	<form:form modelAttribute="fragebogen" action="questionnaire_absenden" id="uform" >
	
		<c:forEach items="${fragebogen.aufgaben}" var="aufgabe" varStatus="aufgabenindex" >
			<form:label path="aufgaben[${aufgabenindex.index}].nutzerantwortIndex">${aufgabe.frage} :</form:label>
			<form:radiobuttons path="aufgaben[${aufgabenindex.index}].nutzerantwortIndex" items="${aufgabe.antwortmoeglichkeiten}"  /> 
		    </br>
		</c:forEach>

 		</br>
		<input type="submit" value="Show my score...">
	</form:form>

</body>
</html>