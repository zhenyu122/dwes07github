<html>
<head>
<title>Conexión 2</title>
<meta charset="UTF-8"/>
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"animales");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");

// Recoger el cuidador de request
if (!isset($_REQUEST["idCuidador"])) die ("<h3>ERROR en la petición. Falta identificador de cuidador</h3>");
$id = $_REQUEST["idCuidador"];


$resultado = $conexion -> query("SELECT * FROM cuidador WHERE idCuidador = ".$id);

// Obtener los datos del cuidador
$resultado = $conexion -> query("SELECT * FROM cuidador WHERE idCuidador = ".$id);
if($resultado->num_rows === 0) die ("<h3>ERROR en la petición. Identificador de cuidador no válido</h3>");
$fila=$resultado->fetch_assoc();
echo "<h3>Animales cuidados por ".$fila['Nombre'].":</h3>";

// liberamos la memoria del resultado, que reutilizaremos después
mysqli_free_result($resultado);

// obtener los animales que cuida el cuidador
$resultado = $conexion -> query("SELECT animal.* FROM animal, cuida WHERE (animal.chip = cuida.chipAnimal) AND (cuida.idCuidador = '$id');");
if($resultado->num_rows === 0) echo "<p>Este cuidador no cuida a ningún animal</p>";
else {
    echo "<ul>";
    while($fila=$resultado->fetch_assoc()) {
        echo "<li>".$fila['nombre'].", de la especie ".$fila['especie']."</li>";
    }
    echo "</ul>";
}
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<a href="conexion5.php">Volver a Conexión 5</a>
</body>
</html>