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
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>Chip</th>
	<th>Nombre</th>
	<th>Especie</th>
	<th>Imagen</th>
</tr>
<?php
$ruta="img";
$resultado = $conexion -> query("SELECT * FROM animal ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
//$fila=$resultado->fetch_assoc();
//Mientras fila tenga valores
while($fila=$resultado->fetch_assoc()/*$fila!=null*/) {
	echo "<tr style='background-color:lightgreen'>";
	echo "<td>$fila[chip]</td>";
	echo "<td>$fila[nombre]</td>";
	echo "<td>$fila[especie]</td>\n";
	echo "<td><img src='$ruta/$fila[imagen]' width='100px' height='100px'/></td>\n";
	echo "</tr>";
	//$fila=$resultado->fetch_assoc();
}
?>
</table>
<?php 
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<a href="BBDD.php"><button>Conexion1</button></a>
<a href="conexion2.php"><button>Conexion2</button></a>
<a href="conexion3.php"><button>Conexion3</button></a>
<a href="conexion4.php"><button>Conexion4</button></a>
<a href="conexion5.php"><button>Conexion5</button></a>
<a href="conexion6.php"><button>Conexion6</button></a>
<a href="conexion6PDO.php"><button>Conexion6PDO</button></a>
</body>
</html>