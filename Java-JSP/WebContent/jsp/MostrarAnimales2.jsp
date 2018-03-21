<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Animales</title>
</head>
<body>
	<h3> Listado de animales </h3>
	<table style="border: 2px solid lightblue">
	<tr style="background:lightblue">
		<th>Chip</th>
		<th>Nombre</th>
		<th>Especie</th>
		<th>Imagen</th>
	</tr>
	<c:forEach var="animal" items="${requestScope['animales']}">
		<tr>
			<td style="background:lightgreen">${animal.chip}</td>
			<td style="background:lightgreen">${animal.nombre}</td>
			<td style="background:lightgreen">${animal.especie}</td>
			<td style="background:lightgreen"><img src="./img/${animal.imagen}" width="150px"/></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
<%--
Comentarios sobre esta solución:
* Puedes descargar la librería JSTL aquí: http://tomcat.apache.org/download-taglibs.cgi
	* Descarga las versiones "impl" y "spec" 
	* Copia ambas en WEB-INF/lib (puedes arrastrarlas a Eclipse desde tu carpeta de descargas)
	* Descarga el "README" si quieres más información
* Para su uso se asocia la referencia a un prefijo que habitualmente es "c" para las etiquetas esenciales de JSTL ("core")
* La ventaja de usar este tipo de librerías es que no hay nada de código Java
* Aprende a usar JSTL con ejemplos: https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm 
--%>