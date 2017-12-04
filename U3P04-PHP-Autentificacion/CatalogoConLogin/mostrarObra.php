<?php
session_start();
$mensajeError="";
if (!isset($_SESSION["user"])){
    header("location: login/login.php");
}else{
    ?>
<html>
<head>
<title>Mostrar Obra</title>
<meta charset="UTF-8"/>
</head>
<body>
<?php
$conexion1 = new mysqli("localhost","alumno","alumno","catalogo07");
$resultado1 = $conexion1->query("select * from usuario");
if($resultado1->num_rows === 0) header("Location:logout.php");
$nombre="";
while($fila=$resultado1->fetch_assoc()) {
    if ($fila["login"]==$_SESSION["user"]){
        $nombre=$_SESSION["user"];
    }
}
if (empty($nombre)){
    header("location: login/logout.php");
    
}else{
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo07");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");

if (!isset($_REQUEST["idObra"])) die ("<h3>ERROR en la petición. Falta identificador de la obra</h3>");
$id = $_REQUEST["idObra"];


$resultado = $conexion -> query("SELECT obras.*,Nombre FROM obras,autor WHERE Compania=autor.ID and obras.ID = ".$id);
if($resultado->num_rows === 0) die ("<h3>ERROR en la petición. Identificador de la obra no valido</h3>");
//$fila=$resultado->fetch_assoc();

echo "<ul>";
while($fila=$resultado->fetch_assoc()) {
    echo "<h3>Los Datos de ".$fila['Titulo'].":</h3>";
    echo "<li>ID: $fila[ID]</li>";
    echo "<li>Titulo: $fila[Titulo]</li>";
    echo "<li>Compania: $fila[Nombre]</li>";
    echo "<img src='img/$fila[Imagen]' width=150px height=200px/>";
}
echo "</ul>";
mysqli_free_result($resultado);

mysqli_close($conexion);
}
}
?>
<a href="mostrarCatalogo.php"><button>Volver</button></a>
</body>
</html>