<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Meses</h1>
<?php
if (!isset($_POST["enviar"])){
    ?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Cadena<input type="text" name="cadena">
Bisiesto :
Si <input type="radio" name="bisiesto" value="si">
No <input type="radio" name="bisiesto" value="no" checked>
<input type="submit" name="enviar">
</form>
<?php 
}else{
   $a=$_POST["cadena"];
   $b=$_POST["bisiesto"];
   if ($a<=12 && $a>=1){
       switch ($a) {
           case 1:case 3: case 5:case 7:case 8:case 10:case 12:
              echo "<p>El mes $a tiene 31 dias</p>"; 
               break;
           case 4:case 6:case 9:case 11:
               echo "<p>El mes $a tiene 30 dias</p>";
               break;
           case 2:
               if ($b=="si"){
                   echo "<p>El mes $a tiene 29 dias</p>";
               }elseif ($b=="no")
                 echo "<p>El mes $a tiene 28 dias</p>";
               break;
       }
   }else if (strcasecmp($a, "febrero")==0){
       if($b=="si")
        echo "<p>$a tiene 29 dias</p>";
        elseif ($b=="no")
        echo "<p>$a tiene 28 dias</p>";
   }else if(strcasecmp($a, "enero")==0 || strcasecmp($a, "marzo")==0 || strcasecmp($a, "mayo")==0 || strcasecmp($a, "julio")==0
       || strcasecmp($a, "agosto")==0 || strcasecmp($a, "octubre")==0 || strcasecmp($a, "diciembre")==0)
       echo "<p>$a tiene 31 dias</p>"; 
   else if(strcasecmp($a, "abril")==0 || strcasecmp($a, "junio")==0 || strcasecmp($a, "septiembre")==0 || strcasecmp($a, "noviembre")==0)
       echo "<p>$a tiene 30 dias</p>"; 
}
?>
<br>
<a href="index.php"><input type="button" value="Volver"></a>
</body>
</html>