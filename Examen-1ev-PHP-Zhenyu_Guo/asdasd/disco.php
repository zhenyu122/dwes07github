<html>
<head>
<title>Mostrar Disco</title>
<meta charset="UTF-8"/>
</head>
<body>
<img src="img/encabezado/encabezado.jpg" /><h2>Zhenyu Guo</h2>
<?php
$conexion = new mysqli("localhost","alumno","alumno","examen1718-1ev-sigurros");

$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}

if (!isset($_REQUEST["idDisco"])) die ("<h3>ERROR en la petición. Falta identificador del disco</h3>");
$id = $_REQUEST["idDisco"];


$resultado = $conexion -> query("SELECT * FROM discos WHERE id = ".$id);
if($resultado->num_rows === 0) die ("<h3>ERROR en la petición. Identificador del disco no valido</h3>");

echo "<ul>";
while($fila=$resultado->fetch_assoc()) {
    echo "<h3>Los Datos de ".$fila['nombre'].":</h3>";
    echo "<li>Discografica: $fila[discografica]</li>";
    echo "<li>Año: $fila[year]</li>";
    echo "<li>Formato: $fila[soporte]</li>";
    echo "<img src='img/discografia/$fila[imagen].jpg'/>";
}
echo "</ul>";

mysqli_free_result($resultado);
?>
<a onclick="<?php ?>"></a>
<a onclick="<?php ?>"></a>
<form action="<?php echo $_SERVER['PHP_SELF']."?idDisco=".$id?>" method="post">
    <label>Idioma del titulo:</label><br><br>
    <input type="radio" name="idioma" value="es"><img src='img/banderas/es.png'/>
    <input type="radio" name="idioma" value="is"><img src='img/banderas/is.png'/><br>
    <input type="submit" value="Enviar" name="enviar">
</form>
<?php 
if (isset($_POST["enviar"])){
    if($_POST["idioma"]=="es"){
        setcookie("español", "es", time() + 2592000);
        setcookie("islandesa", null, time() + -1);
        header("Location: ".$_SERVER['PHP_SELF']."?idDisco=".$id);
    }else if($_POST["idioma"]=="is"){
        setcookie("islandesa", "is", time() + 2592000);
        setcookie("español", null, time() + -1);
        header("Location: ".$_SERVER['PHP_SELF']."?idDisco=".$id);
    }
}
$resultado = $conexion -> query("SELECT * FROM temas WHERE id_disco = ".$id);
if($resultado->num_rows === 0) die ("<h3>ERROR en la petición. Identificador del disco no valido</h3>");
echo "<ul>";
echo "<h3>Listado de canciones</h3>";
while($fila=$resultado->fetch_assoc()) {
    echo "<li>Numero: $fila[numero]</li>";
    if(isset($_COOKIE["español"])){
        echo "<li>Titulo:$fila[nombre_e] </li>";
    }else{
        echo "<li>Titulo:$fila[nombre_i] </li>";
    }
    if ($fila["minutos"]!=0 && $fila["segundos"]!=0){
        echo "<li>Duracion: $fila[minutos]:$fila[segundos] </li>";
    }
}
echo "</ul>";
mysqli_free_result($resultado);
echo "<h3>Comentarios</h3>";
$resultado = $conexion -> query("SELECT texto FROM discos WHERE id = ".$id);
if($resultado->num_rows === 0) die ("<p>No se encontró el disco</p>");
else {
    $fila=$resultado->fetch_assoc();
    echo $fila["texto"];
}

?>
<a href="index.php"><button>Volver</button></a>
</body>
</html>