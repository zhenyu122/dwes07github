<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Cuadrado</h1>
<?php
if (!isset($_POST["enviar"])){   
    ?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Numero<input type="text" name="num">
<input type="submit" name="enviar">
</form>
<table>
    <?php 
    }else{
        ?>
        
        	
        
    <?php
    }
        ?>
</table>
<br>
<a href="index.php">Volver</a>
</body>
</html>