<?php
session_start();
if (!isset($_SESSION["x"])){
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
    <h2>¿Cual de los siguientes grupos se originó en Nueva York?</h2>
    <select name="p2">
    	<option>Iron Maiden</option>
    	<option>Anthrax</option>
    	<option>Megadeth</option>
    </select>
    <input type="submit" name="enviar">
    </form>
    </fieldset>
    <?php 
    }else{
        $_SESSION["respuesta2"]=$_POST["p2"];
        header("Location: test3.php");
    }
    ?>
    </body>
    </html>
    <?php 
}
?>