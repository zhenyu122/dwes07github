<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de animales</h2>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
?>
<p> Vamos a utilizar las siguientes variables:</p>
<ul>
<?php
echo "<li>Nombre del servidor al que nos vamos a conectar a MySQL: $servidor</li>";
echo "<li>Nombre de usuario con el que nos vamos a conectar a MySQL: $usuario</li>";
echo "<li>Contraseña del usuario en MySQL: $clave</li>";
?>
</ul>
<?php
echo "<h3>Estableciendo conexión...</h3>";
$conexion = new mysqli($servidor,$usuario,$clave);
if ($conexion->connect_errno) {
	echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
else {
	echo "<p>Información de servidor: $conexion->host_info</p>";
	echo "<h3>Desconectando...</h3>";
	mysqli_close($conexion);
}
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