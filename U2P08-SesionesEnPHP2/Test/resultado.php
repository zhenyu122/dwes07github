<?php
session_start();
if (!isset($_SESSION["x"])){
    header("Location: registro.php");
}else if (!isset($_SESSION["respuesta1"])){
    header("Location: test1.php");
}else if (!isset($_SESSION["respuesta2"])){
    header("Location: test2.php");
}else if (!isset($_SESSION["respuesta3"])){
    header("Location: test3.php");
}else{
    ?>
    <html>
    <head></head>
    <body>
   	<?php 
   	$cont=0;
   	?>
   	<?php 
   	if ($_SESSION["respuesta1"] == "Martini con vodka")
   	    $cont++;
   	if($_SESSION["respuesta2"] == "Anthrax")
   	    $cont++;
   	if($_SESSION["respuesta3"] == "Herman Melville")
   	    $cont++;
   	
   	 echo $_SESSION["x"]." has acertado ".$cont." preguntas";
   	
    ?>
    <p><a href="<?php echo $_SERVER['PHP_SELF']."?denuevo=true"?>">Empezar de nuevo</a></p>
    <p><a href="<?php echo $_SERVER['PHP_SELF']."?respuesta=true"?>">Ver respuestas</a></p>
    <?php 
    if (isset($_REQUEST["respuesta"])){
        echo "<p>1. ".$_SESSION["respuesta1"]."</p><p> 2. ".$_SESSION["respuesta2"]."</p><p> 3 ".$_SESSION["respuesta3"]."</p>";
    }
    if (isset($_REQUEST["denuevo"])){
        $_SESSION=array();
        session_unset();
        
        $params = session_get_cookie_params();
        setcookie(session_name(), '', time() - 42000,
            $params["path"], $params["domain"],
            $params["secure"], $params["httponly"]
            );
        
        session_destroy();
        header("location: registro.php");
    }
    ?>
    
    </body>
    </html>
    <?php 
}
?>