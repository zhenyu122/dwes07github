<?php
$mensajeError="";
session_start();
if (isset($_POST["enviar"])){
    if (empty($_POST["pass"])){
        $mensajeError="El campo contraseña está vacía";
    }else{
        $user="\"".$_SESSION["user"]."\"";
        $conexion = new mysqli("localhost","alumno_rw","dwes","catalogo07");
        $resultado = $conexion->query("select * from usuario where usuario.login =$user");
        if($resultado->num_rows === 0) $mensajeError="No existe el usuario en la base de datos";
        while($fila=$resultado->fetch_assoc()) {
            $mensajeError="";
            if($_POST["pass"]!=$fila["password"]){
                $mensajeError="No coinciden las contraseñas";
            }else{
                $conexion->query("DELETE FROM usuario WHERE usuario.login = $user");
                if(!empty($conexion->error)){
                    $mensajeError=$conexion->error;
                }else{
                    header("location:logout.php");
                }
            }
        }
    }
}
?>
<html>
<head><title>Baja Usuario</title>
<style type="text/css">

</style>
</head>
<body>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    <div>
        <p>Confirma la contraseña para borrar al usuario</p>
        <input type="password" name="pass"><br><br>
   		<input type="submit" name="enviar">
   		<p><a href="index.php">Volver a Index</a></p>
   		<?php if (!empty($mensajeError)){
   		   echo "<h3>".$mensajeError."</h3>";
        }?>
    </div>
</form>
</body>
</html>