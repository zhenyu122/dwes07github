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
if(!isset($_POST["enviar"])){
      
        ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    Numero<input type="text" name="num">
    <?php $acu=0?>
    <input type="hidden" name="acum" value="<?php echo $acu?>">
    <input type="submit" name="enviar">
    </form>
    <?php 
}else if($_POST["acum"]<50){
    ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    Numero<input type="text" name="num">
    <?php $acu=$_POST["num"]+$_POST["acum"];?>
    <input type="hidden" name="acum" value="<?php echo $acu?>">
    <input type="submit" name="enviar">
    </form>
    <?php
    echo "<p>La suma total es: ".$acu."</p><br>";
}else{
    echo "<p>Has pasado de los 50</p>";
}

?>
<br>
<a href="index.php">Volver</a>
</body>
</html>