<?php
if (session_status () == PHP_SESSION_NONE){
    header("Location: registro.php");
}else if (!isset($_SESSION["respuesta1"])){
    header("Location: test1.php");
}else{
    ?>
    <html>
    <head></head>
    <body>
    <?php 
    if (!isset($_POST["enviar"])){
    ?>
    <fieldset>
    <legend>Pregunta 2</legend>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    <p>¿2?</p>
    <input type="text" name="valor">
    <input type="submit" name="enviar">
    </form>
    </fieldset>
    <?php 
    }else{
        $_SESSION["respuesta2"]=$_POST["valor"];
        header("Location: test3.php");
    }
    ?>
    </body>
    </html>
    <?php 
}
?>