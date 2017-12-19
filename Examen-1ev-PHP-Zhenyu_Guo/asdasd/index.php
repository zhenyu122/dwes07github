<?php
session_start();
if (isset($_REQUEST["idCategoria"])){
    $categoria=$_REQUEST["idCategoria"];
    $_SESSION["categoria"]=$_REQUEST["idCategoria"];
}
?>
<html>
<head>
	<title></title>
	<meta charset="UTF-8"/>
	<style type="text/css">
	   a:link{
	       text-decoration: none;
	   }
	   a:hover{
	       color:red;  
	   }
	</style>
</head>
<body>
<img src="img/encabezado/encabezado.jpg" /><h2>Zhenyu Guo</h2>
<a href="admin-login.php"><input type="button" value="Admin Login"/></a>
<?php
$conexion = new mysqli("localhost","alumno","alumno","examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");
$resultado = $conexion -> query("SELECT DISTINCT tipo FROM discos");
if($resultado->num_rows === 0) die ("Error, no hay datos");
echo "<ul>";
echo "<h3>Categorías</h3>";
while($fila=$resultado->fetch_assoc()) {
    echo "<li><a href='index.php?idCategoria=$fila[tipo]'>$fila[tipo]</a></li>";
}
echo "</ul>";
mysqli_free_result($resultado);
if (isset($categoria)){
    echo "<h2>Los discos de la categoria ".$categoria."</h2>";
}else{
    echo "<h2>Los discos de la categoria Álbumes</h2>";
}
echo "<table style='border:0'>";
echo "<tr style='background-color:lightblue'>";
echo "<th>Titulo <a href='index.php?AscTitulo=true'>&#9650;</a><a href='index.php?DescTitulo=true'>&#9660;</a></th>";
echo "<th>Discografia</th>";
echo "<th>Año<a href='index.php?AscAño=true'>&#9650;</a><a href='index.php?DescAño=true'>&#9660;</a></th>";
echo "<th>Formato</th>";
echo "<th>Imagen</th>";
echo "</tr>";
if (isset($_REQUEST["AscTitulo"]) || isset($_REQUEST["DescTitulo"]) || isset($_REQUEST["AscAño"]) || isset($_REQUEST["DescAño"])){
    
if (isset($_REQUEST["AscTitulo"])){
    $resultado = $conexion -> query("SELECT * FROM discos where tipo='".$_SESSION["categoria"]."' order by nombre");
}
if (isset($_REQUEST["DescTitulo"])){
    $resultado = $conexion -> query("SELECT * FROM discos where tipo='".$_SESSION["categoria"]."' order by nombre desc");
}
if (isset($_REQUEST["AscAño"])){
    $resultado = $conexion -> query("SELECT * FROM discos where tipo='".$_SESSION["categoria"]."' order by year");
}
if (isset($_REQUEST["DescAño"])){
    $resultado = $conexion -> query("SELECT * FROM discos where tipo='".$_SESSION["categoria"]."' order by year desc");
}
}else if(isset($categoria)){
   $resultado = $conexion -> query("SELECT * FROM discos where tipo='".$categoria."'");
}else{
    $resultado = $conexion -> query("SELECT * FROM discos where tipo='Álbumes'");
}
if($resultado->num_rows === 0) die("<p>No hay Datos</p>");
while ($disco = $resultado->fetch_assoc()) {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td align=center><a href='disco.php?idDisco=".$disco["id"]."'>$disco[nombre]<a></td>\n";
    echo "<td>$disco[discografica]</td>\n";
    echo "<td>$disco[year]</td>\n";
    echo "<td>$disco[soporte]</td>\n";
    echo "<td><img src='img/discografia/$disco[imagen].jpg'/></td>\n";
    echo "</tr>";
}
echo "</table>";
?>
</body>
</html>