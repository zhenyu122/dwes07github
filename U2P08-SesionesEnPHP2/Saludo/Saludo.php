<?php
if (isset($_POST['enviar'])){
    session_name($_POST['valor']);
    session_start ();
}
if(session_status() == PHP_SESSION_NONE){
    ?>
    <html>
    <head>
    <title>Sesiones</title>
    <meta charset="UTF-8"/>
    </head>
    <body>
<?php 
if (!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Nombre<input type="text" name="valor">
<input type="submit" name="enviar">
</form>
<?php 
}
?>
</body></html>
<?php 
}else{
    echo "Damos la bienvenida a ".$_POST['valor'];
}
?>