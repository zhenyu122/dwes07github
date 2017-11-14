<?php
if (session_status () == PHP_SESSION_NONE){
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
   	
   	 echo "Has acertado ".$cont." preguntas";
   	
    ?>
    
    </body>
    </html>
    <?php 
}
?>