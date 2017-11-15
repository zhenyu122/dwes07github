<?php
session_start();
if (!isset($_SESSION["x"])){
    header("location: registro.php");
}else{
    $nombre=$_SESSION["x"];
    $saludo = "<h2>Bienvenido $nombre</h2>";
    ?>
<html>
<head></head>
<body>
<?php echo $saludo ?>
<a href="<?php echo 'test1.php'?>">Test</a>
</body>
</html>
    <?php 
}
?>