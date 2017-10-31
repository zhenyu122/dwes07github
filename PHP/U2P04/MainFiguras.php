<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<?php 
include 'Cuadrado.php ';include 'Triangulo2.php';
?>

<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Nombre cuadrado<input type="text" name="nombre1">
Color cuadrado<input type="text" name="color1"><br>
Nombre triángulo<input type="text" name="nombre2">
Color triángulo<input type="text" name="color2">
<input type="submit" name=enviar>
</form>
<?php 
if (isset($_POST["enviar"])){
    $figura1=new Cuadrado($_POST["nombre1"], $_POST["color1"]);
    $figura2=new Triangulo2($_POST["nombre2"], $_POST["color2"]);
    echo "<h1>Cuadrado</h1>";
    echo "Nombre: ".$figura1->getNombre()." Color: ".$figura1->getColor()." Lados: ".$figura1->getLado()."<br>";
    $figura1->ver();
    echo "<h1>Triángulo</h1>";
    echo "Nombre: ".$figura2->getNombre()." Color: ".$figura2->getColor()." Lados: ".$figura2->getLado()."<br>";
    $figura2->ver();
}
?>
<br>
</body>
</html>