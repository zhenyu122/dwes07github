<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<h1>Diferencia</h1>
<?php 
if (!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
Numero A<input type="text" name="a">
Numero B<input type="text" name="b">
<input type="submit" name=enviar>
</form>
<?php 
}else{
    $a=$_POST["a"];
    $b=$_POST["b"];
    if(($a<=10 && $a>=1)&&($b>=1 && $b<=10)){
        if ($a>$b){
            $z=$b;
            while($a>$z){
                echo "*";
                $z++;
            }
            $diferencia=$a-$b;
            for ($x=0;$x<$diferencia;$x++){
                echo "#";
            }
        }elseif($b>$a){
            $z=$a;
            while($b>$z){
                echo "*";
                $z++;
            }
            $diferencia=$b-$a;
            for ($x=0;$x<$diferencia;$x++){
                echo "#";
            }
        }
    }else{
        echo "<p>No esta entre el 1 y el 10</p>";
    }
}
?>
<br>
<a href="index.php"><input type="button" value="Volver"></a>
</body>
</html>