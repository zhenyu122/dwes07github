<?php
session_start();
if (!isset($_SESSION["x"])){
    header("Location: registro.php");  
}else{
    ?>
    <html>
    <head></head>
    <body>
    <?php 
    if (!isset($_POST["enviar"])){
    ?>
    <fieldset>
    <legend>Pregunta 1</legend>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    <h2>¿Cuál es la bebida favorita de James Bond?</h2>
    <select name="p1">
    	<option>Whisky de malta</option>
    	<option>Martini con vodka</option>
    	<option>Bloody mary</option>
    </select>
    <input type="submit" name="enviar">
    </form>
    </fieldset>
    <?php 
    }else{
        $_SESSION["respuesta1"]=$_POST["p1"];
        header("Location: test2.php");
    }
    ?>
    </body>
    </html>
    <?php 
}
?>