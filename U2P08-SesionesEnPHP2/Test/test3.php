<?php
if (session_status () == PHP_SESSION_NONE){
    header("Location: registro.php");
}else if (!isset($_SESSION["respuesta1"])){
    header("Location: test1.php");
}else if (!isset($_SESSION["respuesta2"])){
    header("Location: test2.php");
}else{
    ?>
    <html>
    <head></head>
    <body>
    <?php 
    if (!isset($_POST["enviar"])){
    ?>
    <fieldset>
    <legend>Pregunta 3</legend>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    <p>¿3?</p>
    <input type="text" name="valor">
    <input type="submit" name="enviar">
    </form>
    </fieldset>
    <?php 
    }else{
        $_SESSION["respuesta3"]=$_POST["valor"];
        header("Location: respuesta.php");
    }
    ?>
    </body>
    </html>
    <?php 
}
?>