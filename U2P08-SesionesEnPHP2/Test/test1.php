<?php
if (session_status () == PHP_SESSION_NONE){
    header("Location: registro.php");  
}else{
    ?>
    <html>
    <head></head>
    <body>
    <h3>Pregunta 1</h3>
    
    </body>
    </html>
    <?php 
}
?>