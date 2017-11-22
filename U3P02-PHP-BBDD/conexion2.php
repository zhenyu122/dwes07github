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
$conexion = new mysqli($servidor,$usuario,$clave,"animales");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");
echo "<p>A continuación mostramos algunos registros:</p>";
$resultado = $conexion -> query("SELECT * from animal order by nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
$fila=$resultado->fetch_assoc();
while($fila!=null) {
    echo "<hr>";
    echo "Nombre:" . $fila['nombre'];
    echo "<br>Especie: $fila[especie]"; // observa la diferencia en el uso de comillas
    $fila=$resultado->fetch_assoc();
}
mysqli_free_result($resultado);
//SELECT * from animal LEFT JOIN cuida on chip=chipAnimal
$resultado = $conexion -> query("SELECT * from cuidador order by idCuidador");
if($resultado->num_rows === 0) echo "<p>No hay cuidadores en la base de datos</p>";
$fila=$resultado->fetch_assoc();
while($fila!=null) {
    echo "<hr>";
    echo "Nombre: $fila[Nombre]"; // observa la diferencia en el uso de comillas
    $fila=$resultado->fetch_assoc();
}
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>