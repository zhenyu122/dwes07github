<?php
session_start();
$mensajeError="";
if (!isset($_SESSION["user"])){
    header("location: login.php");
}else{
    ?>
    <html>
    <head><title>Index</title>
    <style type="text/css">
    body{text-align: center}
       a:link{text-decoration: none}
       a:visited{color:blue;}
       a:active{color:red;}
       a:hover{font-weight: bold;}ul{list-style-type: none}
    </style>
    </head>
    <body>
    <?php 
    $conexion = new mysqli("localhost","alumno","alumno","catalogo07");
    $resultado = $conexion->query("select * from usuario");
    if($resultado->num_rows === 0) header("Location:logout.php");
    $nombre="";
    while($fila=$resultado->fetch_assoc()) {
        if ($fila["login"]==$_SESSION["user"]){
            $nombre=$_SESSION["user"];
        }
    }
    if (empty($nombre)){
        header("location:login.php");
    }else{
        echo "<h1>Bienvenido ".$nombre."</h1>";
        ?>
        <p><a href="logout.php">Cerrar sesión por logout.php</a></p>
        <p><a href="login.php?cerrarSesion=true">Cerrar sesión por parámetro</a></p>
        <p><a href="baja.php">Eliminar cuenta</a></p>
        <?php 
    } 
    ?>
    </body>
    </html>
<?php 
}
?>