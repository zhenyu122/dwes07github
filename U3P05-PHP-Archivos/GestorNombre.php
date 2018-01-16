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
$rutaArchivo = "files/nombres.txt";
$ar=file($rutaArchivo);
if (isset($_POST["enviar"])){
   if($_POST["modificar"]=="borrar"){
       if (!in_array($_POST["nombre"], $ar)){
           echo "<h3>No existe el nombre</h3>";
       }else{
           //$encontrado=false;
           for($i=0;$i<count($ar);$i++){
               if ($ar[$i]==$_POST["nombre"]){
                  // $encontrado=true;
                   //$pos=$i;
                   unset($ar[$i]);
               }
           }
           unlink($rutaArchivo);
           print_r($ar);
           /*Falta probar las lineas de encima y volcar el array en n fichero nuevo*/
           
       }
   }else if($_POST["modificar"]=="añadir"){
     
      // if (in_array($_POST["nombre"], $ar)){
       if (buscar($_POST["nombre"],$ar)){
           echo "<h3>Ya existe el nombre</h3>";
       }else{
           $archivo=fopen($rutaArchivo, "a") or die ("Imposible abrir el archivo");
           fwrite($archivo, $_POST["nombre"]."\n");
           fclose($archivo);
           //header("location:GestorNombre.php");
       }
   }
}
if(empty($ar)){
    echo "<h2>El array está vacio</h2>";
}else{
    sort($ar);
    echo "<ul>";
    for($i=0;$i<count($ar);$i++){
        echo "<li>$ar[$i]"."<br>";
    }
    echo "</ul>";
}
function buscar($x){
    global $ar;
    $encontrado=false;
    print_r($ar);
    for($i=0;$i<count($ar);$i++){
        if (strcasecmp($x, $ar[$i])){
            echo $x." - ".$ar[$i];
            $encontrado=true;
        }else
            echo "no";
    }
    return $encontrado;
}
?>
</body>
</html>
