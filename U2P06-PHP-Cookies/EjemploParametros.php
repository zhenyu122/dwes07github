<?php

if (isset($_REQUEST["fondo"]))
    
    $fondo = $_REQUEST["fondo"];
    
    else
        
        $fondo = "white";
        
        ?>

<html><head><meta charset="UTF-8"/></head>

<body style="background-color: <?php echo $fondo; ?>">

<h1>Ejemplo de paso de parámetros</h1>

<h2>Escoge color de fondo:</h2>

<ul>

<li><a href="color.php?fondo=red">Rojo</a></li>

<li><a href="color.php?fondo=lightgreen">Verde</a></li>

<li><a href="color.php?fondo=lightblue">Azul</a></li>

<li><a href="color.php">Blanco</a></li>

</ul>

</body>

</html>