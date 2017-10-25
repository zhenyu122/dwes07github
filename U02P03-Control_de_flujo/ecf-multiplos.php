<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Multiplo</h1>
<?php
for ($i=1;$i<=1000;$i++){
    if ($i%3==0){
        echo "<p>$i es multiplo de 3</p>";
    }
    if ($i%5==0){
        echo "<p>$i es multiplo de 5</p>";
    }
}
$i=1;$x=1;
while($x<=20){
    if($i%3==0 || $i%5==0){
        if ($i%3==0)
            echo "<p>$i es el multiplo número $x de 3</p>";
        else
            echo "<p>$i es  el multiplo número $x de 5</p>";
        $x++;
    }
    $i++;
}
?>
<br>
<a href="index.php">Volver</a>
</body>
</html>