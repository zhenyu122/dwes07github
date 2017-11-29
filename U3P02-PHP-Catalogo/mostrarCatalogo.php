<html>
<head>
	<title>Mostrar Catalogo</title>
	<meta charset="UTF-8"/>
	<style type="text/css">
	   a{text-decoration: none}
	   td a:link,td a:visited{color:black}
	   td a:hover{font-weight: bold}
	   a:link,a:visited{color:blue}
	   a:hover{color:red}
	</style>
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
}else
    echo "<h3>Conectado</h3>";
$conexion->query("SET NAMES 'UTF8'");
if (isset($_POST["busqueda"])){
    
}else{

if(isset($_REQUEST["idAutor"])){
    ?>
    <?php
    //$resultado = $conexion -> query("SELECT * FROM obras order by Titulo");
    $resultado = $conexion -> query("SELECT * FROM autor where ID=".$_REQUEST["idAutor"]);
       
    if($resultado->num_rows === 0) die ("<p>No hay Datos</p>");
    echo "<ul>";
    while($fila=$resultado->fetch_assoc()) {
        echo "<h3>Los Datos de ".$fila['Nombre'].":</h3>";
        echo "<li>ID: $fila[ID]</li>";
        echo "<li>Titulo: $fila[Nombre]</li>";
        echo "<li>Sede: $fila[Sede]</li>";
        if ($fila["ID"]==2){
            echo "<br><img src='img/$fila[Imagen]' width=400px height=100px/>";
        }else{
            echo "<br><img src='img/$fila[Imagen]' width=200px height=200px/>";
        }
    }
    echo "</ul>";
}else{
?>

<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>
	Titulo 	<a href="<?php echo $_SERVER["PHP_SELF"]."?ascNom=true"?>" id="1">&#9650;</a>
			<a href="<?php echo $_SERVER["PHP_SELF"]."?descNom=true"?>" id="2">&#9660;</a>
	</th>
	<th>
	Compania<a href="<?php echo $_SERVER["PHP_SELF"]."?ascCom=true"?>" id="3">&#9650;</a>
			<a href="<?php echo $_SERVER["PHP_SELF"]."?descCom=true"?>" id="4">&#9660;</a>
	</th>
</tr>
<?php
//$resultado = $conexion -> query("SELECT * FROM obras order by Titulo");
$resultado = $conexion -> query("SELECT obras.*,Nombre FROM obras,autor where Compania=autor.ID");
if (isset($_REQUEST['ascNom'])){
    $resultado = $conexion -> query("SELECT obras.*,Nombre FROM obras,autor where Compania=autor.ID order by Titulo ASC");
}
if (isset($_REQUEST['descNom'])){
    $resultado = $conexion -> query("SELECT obras.*,Nombre FROM obras,autor where Compania=autor.ID order by Titulo DESC");
}
if (isset($_REQUEST['ascCom'])){
    $resultado = $conexion -> query("SELECT obras.*,Nombre FROM obras,autor where Compania=autor.ID order by Nombre ASC");
}
if (isset($_REQUEST['descCom'])){
    $resultado = $conexion -> query("SELECT obras.*,Nombre FROM obras,autor where Compania=autor.ID order by Nombre DESC");
}
    
if($resultado->num_rows === 0) echo "<p>No hay Datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
   // print_r($obra);echo "<br>";
    echo "<tr bgcolor='lightgreen'>";
    echo "<td><a href='mostrarObra.php?idObra=".$obra->getID()."'>".$obra->getTitulo()."</a></td>\n";
   /*$comp = $conexion -> query("SELECT * FROM autor where ID=".$obra->getCompania());
    if ($comp->num_rows===0) echo "<p>No se encontró a la compania</p>";
    else{
        $compania=$comp->fetch_assoc();
        echo "<td>$compania[Nombre]</td>";
    }*/
    echo '<td><a href="mostrarCatalogo.php?idAutor='.$obra->getCompania().'">'.$obra->getNombre()."</a></td>\n";
    //echo "<td>".$obra->getCompania()."</td>\n";
    echo "</tr>";
}
?>
</table>
<?php 
}
}
?>
<br>
<a href="<?php echo $_SERVER["PHP_SELF"]?>"><button>Limpiar Filtros</button></a>
<?php 
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>