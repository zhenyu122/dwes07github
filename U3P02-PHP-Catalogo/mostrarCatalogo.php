<html>
<head>
	<title>Conexión 2</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo07");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");
echo "<p>A continuación mostramos algunos registros:</p>";
$resultado = $conexion -> query("SELECT * from obra order");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
$fila=$resultado->fetch_assoc();
while($fila!=null) {
    echo "<hr>";
    echo "ID:" . $fila['ID'];
    echo "Nombre:" . $fila['Nombre'];
    echo "Compania:" . $fila['Compania'];
    echo "Imagen: ".$fila['Imagen'];
    $fila=$resultado->fetch_assoc();
}
mysqli_free_result($resultado);
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>