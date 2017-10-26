<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Recorte</h1>
<?php
if (!isset($_POST["enviar"])){
    ?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Cadena<input type="text" name="cadena">
<input type="submit" name="enviar">
</form>
<?php 
}else{
   $a=$_POST["cadena"];
   $s=$a;
   for($x=strlen($a);$x>0;$x--){
       for ($i=0;$i<$x;$i++){
           echo $s[$i];
       }
       echo "<br>";
   }
}
?>
<br>
<a href="index.php"><input type="button" value="Volver"></a>
</body>
</html>