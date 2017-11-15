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
   	if ($_SESSION["respuesta1"]==1)
   	    $cont++;
   	if($_SESSION["respuesta2"]==2)
   	    $cont++;
   	if($_SESSION["respuesta3"]==3)
   	    $cont++;
   	
   	 echo $_SESSION["x"]." has acertado ".$cont." preguntas";
   	
    ?>
    <p><a href="<?php echo $_SERVER['PHP_SELF']."?denuevo=true"?>">Empezar de nuevo</a></p>
    <?php 
   
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