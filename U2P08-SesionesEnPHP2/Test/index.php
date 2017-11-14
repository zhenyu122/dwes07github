<?php
if (!isset($_SESSION["x"])){
    header("location: registro2.php");
}else{
    $nombre=$_SESSION["x"];
    $saludo = "Bienvenido $nombre";
    ?>
<html>
<head></head>
<body>
<p>
<a href="<?php echo $_SERVER['test1.php']?>">Test</a>
<?php echo $saludo ?>
</p>
</body>
</html>
    <?php 
}
?>