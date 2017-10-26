<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Factorial</h1>
<?php
if (!isset($_POST["enviar"])){
    ?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Numero A<input type="text" name="numa">
<input type="submit" name="enviar">
</form>
<?php 
}else{
   $a=$_POST["numa"];
   $factorial=1;
   for($x=1;$x<=$a;$x++){
       $factorial*=$x;
   }
   echo "<p>El factorial de $a es  $factorial</p>";
}
?>
<br>
<a href="index.php"><input type="button" value="Volver"></a>
</body>
</html>