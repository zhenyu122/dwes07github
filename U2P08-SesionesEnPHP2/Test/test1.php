<?php
if (session_status () == PHP_SESSION_NONE){
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
    <p>¿1?</p>
    <select name="p1">
    	<option>1</option>
    	<option>2</option>
    	<option>3</option>
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