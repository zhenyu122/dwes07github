<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Acumulador</h1>
<?php
$acu=0;
while($acu<=50){
    if (!isset($_POST["enviar"])){   
        ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    Numero<input type="text" name="num">
    <input type="hidden" name="acu">
    <input type="submit" name="enviar">
    </form>
    <?php 
    }else{
       $a=$_POST["num"];
       $acu+=$_POST["num"];
       echo $acu;
    }
}
?>
<br>
<a href="index.php">Volver</a>
</body>
</html>