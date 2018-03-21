<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Animal"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Animales</title>
</head>
<body>
<%
ArrayList<Animal> animales = (ArrayList<Animal>) request.getAttribute("animales");
if (animales == null)
{
%>
	<h3>Error: no se encuentran los datos</h3>
<%
}
else	
{
%>
	<h3> Listado de animales </h3>
	<table style="border: 2px solid lightblue">
	<tr style="background:lightblue">
		<th>Chip</th>
		<th>Nombre</th>
		<th>Especie</th>
		<th>Imagen</th>
	</tr>
<%
	for (Animal a: animales) {
		out.print("<tr>");
		out.print("<td bgcolor='lightgreen' >" + a.getChip() + "</td>");
		out.print("<td bgcolor='lightgreen' >" + a.getNombre() + "</td>");
		out.print("<td bgcolor='lightgreen' >" + a.getEspecie() + "</td>");
		out.print("<td bgcolor='lightgreen' ><img src='./img/" + a.getImagen() + "' width='150px'/></td>");
		out.print("</tr>");
	}
	out.print("</table>");
}
%>
</table>
</body>
</html>
<%--
Comentarios sobre esta solución:
* Observa que puedes incluir tantos bloques <% %> como quieras, al igual que en PHP
* También puedes escribir HTML con el objeto "out" dentro de una sección de código Java (scriptlet)
* Intenta acceder directamente a /MostrarAnimales.jsp: saldrá el mensaje de error. Si no incluyéramos
  ese "if", daría un "null pointer exception" al no encontrar el objeto listaAnimales
--%>