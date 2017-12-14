<?php 
$mensajeError="";
session_start();
if (!isset($_SESSION["user"])){
    header("location: admin-login.php");
}else{
    $conexion = new mysqli("localhost","alumno_rw","dwes","examen1718-1ev-sigurros");
    $conexion->query("SET NAMES 'UTF8'");
    $resultado = $conexion -> query("SELECT * FROM temas");
    ?>
    <html>
    <head>
        <title>Baja</title>
        <style type="text/css"> </style>
    </head>
    <body>
    <img src="img/encabezado/encabezado.jpg" /><h2>Zhenyu Guo</h2>
    <form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
    	<select name="canciones">
    		<?php 
    		if($resultado->num_rows === 0) die ("Error, no hay datos");
    		echo "<legend>Temas</legend>";
    		while($fila=$resultado->fetch_assoc()) {
    		    echo "<option>$fila[nombre_i]</option>";
    		}
            ?>
    	</select><br>
    	<input type="submit" value="Eliminar" name="Eliminar">
    </form>
     
    	<?php 
    	mysqli_free_result($resultado);
    	 if(isset($_POST["Eliminar"])){
    	     $conexion->query("DELETE FROM temas WHERE nombre_i='".$_POST["canciones"]."'");
    	     echo "<p>".$_POST["canciones"]." ha sido eliminado</p>";
    	 }
    	?>
    	<br>
    	<a href="admin-login.php"><input type="button" value="Volver"></a>
    </body>
    </html>
    <?php 
}
?>