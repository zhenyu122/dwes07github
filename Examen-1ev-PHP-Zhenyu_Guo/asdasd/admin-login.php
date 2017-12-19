<?php 
session_start();
$mensajeError="";
if(isset($_REQUEST["cerrarSesion"])){
    unset($_SESSION ["user"]);
    header("location:index.php");
}
if (isset($_POST["enviar"])){
    if(!empty($_POST["username"])){
        if($_POST["username"]=="admin"){
            if($_POST["pass"]=="secreto"){
                $_SESSION["user"]="admin";
            }else{
                $mensajeError="La contraseña es erronea";
            }
        }else{
            $mensajeError="El usuario es erroneo";
        }
    }else{
        $mensajeError="El usuario esta vacio";
    }
}

?>
<html>
<head><title>Login</title>
<style type="text/css">
form div{text-align: center;}
</style>
</head>
<body>
<?php 
if(!isset($_SESSION['user'])){
if (!(isset($_POST["enviar"]) && empty($mensajeError))){
    ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    <div>
        <p>Nombre de usuario</p>
        <input type="text" name="username"><br>
        <p>Password</p>
        <input type="password" name="pass"><br><br>
        <input type="submit" name="enviar">
        <br><br>
		<a href="index.php">Volver a la pagina principal</a><br>
		<?php echo $mensajeError ?>
      </div>
    </form>
 <?php 
}
}else{
     echo "<h3>Bienvenido a la seccion de administracion</h3>";
     echo "<a href='admin-baja.php'>Dar de baja un tema</a><br>";
     echo "<a href='admin-login.php?cerrarSesion=true'>Cerrar sesion y volver a la pagina principal</a>";
 }
 ?>
</body>
</html>