<?php
if (session_status () == PHP_SESSION_NONE){
    header("Location: registro.php");
}else{
    $nombre=$_POST["nombre"];
    echo "Bienvenido $nombre";
    ?>
<html>
<head></head>
<body>
<p>
<a href="<?php echo $_SERVER['test1.php']?>">Test</a>
</p>
</body>
</html>
    <?php 
}
?>