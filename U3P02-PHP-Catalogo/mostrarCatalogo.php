<html>
<head>
	<title>Mostrar Catalogo</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
include 'Obra.php';
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo07");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>Titulo</th>
	<th>Compania</th>
</tr>
<?php
$resultado = $conexion -> query("SELECT Titulo,Compania FROM obras");
if($resultado->num_rows === 0) echo "<p>No hay Datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
    print_r($obra);
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getCompania()."</td>\n";
    echo "</tr>";
}
?>
</table>
<?php 
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>