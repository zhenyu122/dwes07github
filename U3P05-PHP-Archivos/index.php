<!DOCTYPE html>
<html><head><meta charset='UTF-8'/></head>
<body>
<?php
/*$rutaArchivo = "files/modulos.txt";
echo "<p>Volcar el resultado en pantalla:</p>";
readfile("files/modulos.txt");
echo "<p>Líneas del archivo a un array:</p>";
$lineasArchivo = file($rutaArchivo);
print_r($lineasArchivo);
echo "<p>Archivo sin separación de líneas:</p>";
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
echo fread($archivo,filesize($rutaArchivo));
fclose($archivo);
echo "<p>Leer carácter a carácter, detectando fin de línea:</p>";
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    $c = fgetc($archivo);
    if (($c == "\n") or ($c == "\r\n")) echo "<br/>";
    else echo $c;
}
fclose($archivo);*/
/*echo "<p>Escritura W:</p>";
$rutaArchivo = "files/modulosEscritura.txt";
$archivo = fopen($rutaArchivo, "w") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
fclose($archivo);
leerArchivo($rutaArchivo);*/

/*echo "<p>Escritura R:</p>";
$rutaArchivo = "files/modulosEscritura.txt";
$archivo = fopen($rutaArchivo, "r+") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
fclose($archivo);
leerArchivo($rutaArchivo);
*/
echo "<p>Nuevo archivo:</p>";
$rutaArchivo = "files/nuevo.txt";
$archivo = fopen($rutaArchivo, "w") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
fclose($archivo);
leerArchivo($rutaArchivo);

/*echo "<p>Escritura inicio:</p>";
$rutaArchivo = "files/modulosEscritura.txt";
$ar= file($rutaArchivo);
unlink($rutaArchivo);
$archivo = fopen($rutaArchivo, "w+") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
foreach ($ar as $datos){
    fwrite($archivo,$datos);
}
fclose($archivo);
leerArchivo($rutaArchivo);*/
echo "<p>Escritura ordenada:</p>";
$rutaArchivo = "files/modulosEscritura.txt";
$ar=file($rutaArchivo);
sort($ar);
unlink($rutaArchivo);
$archivo = fopen($rutaArchivo, "w+") or die("Imposible  abrir el archivo para escritura");
foreach ($ar as $datos){
    fwrite($archivo,$datos);
}
fclose($archivo);
leerArchivo($rutaArchivo);
// Pruebas
?>
</body>
</html>
<?php 
function leerArchivo($ruta){
    $archivo= fopen($ruta, "r") or die ("Imposible abrir el archivo");
    while(!feof($archivo)){
        echo fgets($archivo)."<br>";
    }
}
?>