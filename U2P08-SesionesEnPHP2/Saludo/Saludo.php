<?php
if (session_status () == PHP_SESSION_NONE){
    session_start();
    $error="";
}
if (isset($_REQUEST["cerrarSesion"])) {
    $_SESSION=array();
    session_unset();
    
    $params = session_get_cookie_params();
    setcookie(session_name(), '', time() - 42000,
        $params["path"], $params["domain"],
        $params["secure"], $params["httponly"]
        );
    
    session_destroy();
}
if (isset($_POST['enviar'])){
    if (empty($_POST['valor'])){
        $error="El campo está vacío";
    }else{
        $_SESSION['nombre']=$_POST['valor'];
    }
}
?>
<html>
<head>
<title>U2P08</title>
</head>
<body>
<?php 
if (!empty($_SESSION['nombre'])){
    echo "Damos la bienvenida a ".$_SESSION['nombre'];
}else{
    ?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Nombre<input type="text" name="valor">
<input type="submit" name="enviar">
</form>
    
<?php 
}
?>
<p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>
<?php 
if(!empty($error))
    echo $error;
?>
</body>
</html>