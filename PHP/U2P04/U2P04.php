<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<?php 
include 'triangulo.php';
?>

<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Base<input type="text" name="base">
Altura<input type="text" name="altura">
<input type="submit" name=enviar>
</form>
<?php 
if (isset($_POST["enviar"])){
    $t1=new Triangulo($_POST["altura"], $_POST["base"]);
    echo "<p>".$t1->__toString()."</p>";
    echo "<p>Su área es ".$t1->calcularArea()."</p>";
}
?>
<br>
</body>
</html>