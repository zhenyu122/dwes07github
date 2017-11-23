<html>
<head>
	<title>Conexión 2</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
include 'Animal.php';
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
try{
    echo "<h3>Conectando...</h3>";
    $conexion = new PDO("mysql:host=$servidor;dbname=animales",$usuario,$clave);
    echo "<h3>Conexión con éxito</h3>";
}catch (PDOException $pdo){
    $conexion=null;
    echo "<p>Error al establecer la conexión: ".$pdo. "</p>";
    
}
$conexion->query("SET NAMES 'UTF8'");
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>Chip</th>
	<th>Nombre</th>
	<th>Especie</th>
	<th>Imagen</th>
</tr>
<?php
$resultado = $conexion -> query("SELECT nombre,especie as tipo ,chip,imagen FROM animal ORDER BY nombre");

if($resultado->rowCount() === 0) echo "<p>No hay animales en la base de datos</p>";

$resultado->setFetchMode(PDO::FETCH_CLASS,'Animal');
while ($animal=$resultado->fetch()) {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$animal->getChip()."</td>\n";
    echo "<td>".$animal->getNombre()."</td>\n";
    echo "<td>".$animal->getEspecie()."</td>\n";
    echo "<td><img src='img/".$animal->getImagen()."' width=100px height=100px></td>\n";
    echo "</tr>";
}
?>
</table>
<?php 
echo "<h3>Desconectando...</h3>";
$resultado->closeCursor();
$conexion=null;
?>
<a href="BBDD.php"><button>Conexion1</button></a>
<a href="conexion2.php"><button>Conexion2</button></a>
<a href="conexion3.php"><button>Conexion3</button></a>
<a href="conexion4.php"><button>Conexion4</button></a>
<a href="conexion5.php"><button>Conexion5</button></a>
<a href="conexion6.php"><button>Conexion6</button></a>
</body>
</html>