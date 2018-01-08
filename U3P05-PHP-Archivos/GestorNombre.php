<html>
<head>
	<title>Gestor de Nombres</title>
</head>
<body>
<fieldset>
<legend>Introduce un nombre</legend>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    <input type="text" name="nombre"><br>
    <input type="radio" name="modificar" value="añadir" checked="checked">Añadir<br>
    <input type="radio" name="modificar" value="borrar">Borrar<br>
    <input type="submit" name=enviar>
    </form>
</fieldset>
<?php
function leerArchivo($ruta){
    echo "<ul>";
    $archivo= fopen($ruta, "r") or die ("Imposible abrir el archivo");
    while(!feof($archivo)){
        echo "<li>".fgets($archivo);
    }
    echo "</ul>";
}
$rutaArchivo = "files/nombres.txt";
$ar=file($rutaArchivo);

if (isset($_POST["enviar"])){
   if($_POST["modificar"]=="borrar"){
       echo "borrar";
   }else if($_POST["modificar"]=="añadir"){
       echo $_POST["nombre"];
       if (in_array($_POST["nombre"], $ar)){
           echo "<h3>Ya existe el nombre</h3>";
       }
   }
}
if(empty($ar)){
    echo "<h2>El array está vacio</h2>";
}else{
    sort($ar);
    unlink($rutaArchivo);
    $archivo = fopen($rutaArchivo, "w+") or die("Imposible  abrir el archivo para escritura");
    foreach ($ar as $datos){
        fwrite($archivo,$datos);
    }
    fclose($archivo);
    leerArchivo($rutaArchivo);
}
?>
</body>
</html>
