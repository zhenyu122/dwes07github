<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Potencia</h1>
<?php
if (!isset($_POST["enviar"])){
    ?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Numero A<input type="text" name="numa">
Numero b<input type="text" name="numb">
<input type="submit" name="enviar">
</form>
<?php 
}else{
   $a=$_POST["numa"];
   $b=$_POST["numb"];
   $potencia=1;
   for($x=1;$x<=$b;$x++){
       $potencia*=$a;
   }
   echo "<p>La potencia de $a elevado a $b es $potencia</p>";
}
?>
<br>
<a href="index.php">Volver</a>
</body>
</html>