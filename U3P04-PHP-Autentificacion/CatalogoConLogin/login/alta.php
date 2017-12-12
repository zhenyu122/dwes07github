<?php
$mensajeError="";
if (isset($_POST["enviar"])){
    if (empty($_POST["username"])){
        $mensajeError="Nombre de usuario vacio";
    }else if(empty($_POST["pass"])){
        $mensajeError="Contraseña vacia";
    }else{
        $conexion = new mysqli("localhost","alumno_rw","dwes","catalogo07");
        $resultado = $conexion->query("select * from usuario");
        
        //if($resultado->num_rows === 0) $mensajeError="No hay usuarios en la base de datos";
        if($resultado->num_rows === 0){
            
            $passwordHash = password_hash($_POST["pass"], PASSWORD_DEFAULT);
        $conexion->query("INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`)
                    VALUES ('".$_POST["username"]."', '".$passwordHash."', '".$_POST["Nombre"]."', '".$_POST["cuenta"]."', '".$_POST["descripcion"]."');");
        header("location: ../mostrarCatalogo.php");
        }
        while($fila=$resultado->fetch_assoc()) {
            if ($_POST["username"]==$fila["login"]){
                $mensajeError="Ya existe un usuario con ese nombre de usuario";
            }else{
                $passwordHash = password_hash($_POST["pass"], PASSWORD_DEFAULT);
                $conexion->query("INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`) 
                    VALUES ('".$_POST["username"]."', '".$passwordHash."', '".$_POST["Nombre"]."', '".$_POST["cuenta"]."', '".$_POST["descripcion"]."');");  
                if(!empty($conexion->error)){
                    $mensajeError=$conexion->error;
                }else{
                    header("location: ../mostrarCatalogo.php");
                }
                
            }
            
        }
    }
}
?>
<html>
<head><title>Alta Usuario</title>
<style type="text/css">
        	   form div{text-align: center;}
        	   a:link{text-decoration: none}
        	   a:visited{color:blue;}
        	   a:active{color:red;}
        	   a:hover{font-weight: bold;}
        	   div h3{color:red;}
        	</style>
</head>
<body>
<?php if (!empty($mensajeError)){
    echo "<p>$mensajeError</p>";
}?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
            <div>
                <p>Nombre de usuario</p>
                <input type="text" name="username">
                <p>Password</p>
                <input type="password" name="pass">
                <p>Nombre completo</p>
                <input type="text" name="Nombre">
                <p>Tipo de cuenta</p>
                Estándar<input type="radio" name="cuenta" value=0>
                Administrador<input type="radio" name="cuenta" value=1>
                <p>Descripción</p>
                <input type="text" name="descripcion"><br><br>
           		<input type="submit" name="enviar">
           		<p><a href="login.php">¿Ya tienes cuenta? Haz clic aquí para iniciar sesión</a></p>
           		<?php if (!empty($mensajeError)){
           		   echo "<h3>".$mensajeError."</h3>";
                }?>
            </div>
        </form>
</body>
</html>