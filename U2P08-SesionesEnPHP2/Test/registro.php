<?php
if (!session_status () == PHP_SESSION_NONE){
    header("Location: index.php");  
}else if(isset($_POST['enviar'])){
   session_start();
   $nom=$_POST['nombre'];
}else{
    ?>
<html>
<head></head>
<body>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Nombre<input type="text" name="nombre">
<input type="submit" name="enviar">
</form>
</body>
</html>
    <?php 
}
?>