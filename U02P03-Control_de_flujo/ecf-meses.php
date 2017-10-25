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
Bisiesto :
Si <input type="radio" name="bisiesto">
No <input type="radio" name="bisies">
<input type="submit" name="enviar">
</form>
<?php 
}else{
   $a=$_POST["cadena"];
   $b=$_POST["bisiesto"];
   echo $b;
}
?>
<br>
<a href="index.php">Volver</a>
</body>
</html>