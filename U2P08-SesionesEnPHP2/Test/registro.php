<?php
if (session_status () != PHP_SESSION_NONE){
    header("location: index.php");  
}else{

if(isset($_POST['enviar'])){
   session_start();
   $_SESSION["prueba"]="Contenido";
   $_SESSION["x"]=$_POST['nombre'];
   header("location: index.php");
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
}
?>