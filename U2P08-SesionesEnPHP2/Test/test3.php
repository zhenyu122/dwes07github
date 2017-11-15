<?php
session_start();
if (!isset($_SESSION["x"])){
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
    <p>¿Quién es el autor de "Moby Dick"?</p>
    <select name="p3">
    	<option>Walt Whitman</option>
    	<option>Charles Dickens</option>
    	<option>Herman Melville</option>
    </select>
    <input type="submit" name="enviar">
    </form>
    </fieldset>
    <?php 
    }else{
        $_SESSION["respuesta3"]=$_POST["p3"];
        header("Location: resultado.php");
    }
    ?>
    </body>
    </html>
    <?php 
}
?>