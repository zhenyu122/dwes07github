<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Primer ejemplo de PHP</title>
</head>
<body>
<?php 
#Prueba de comentario1
$a="Zhen";//Prueba de comentario 2
/*Prueba
 * de
 * Comentario 
 * 3
 * */
echo "<p>Prueba de $a </p>";
echo 'Prueba $a';

define("ALUMNO","Zhen");
echo "<p>Prueba de ".ALUMNO ." </p>";
define("MODULO", "DWES",true);
echo "<p>Prueba de ".modulo ." </p>";


$b=4;$c=5;
echo "<p>Suma: ".($b+=$c)."</p>";
echo "<p>Resta: ".($b-=$c)."</p>";
echo "<p>Producto: ".($b*=$c)."</p>";
echo "<p>Division: ".($b/=$c)."</p>";
echo "<p>Concatenación: ".($b.=$c)."</p>";
$x=5;$b=4;$c=5;
if ($b>$c){
    echo "<p>$b es mayor que $c</p>";
}elseif ($c>$b){
    echo "<p>$c es mayor que $b</p>";
}
if ($c>$b){
    echo "<p>$c es mayor que $b</p>";
}
if($x==$c){
    echo "<p>$c es igual que $x</p>";
}
$b2=true;$b3=true;$b4=false;
if ($b2 && $b3){
    echo "<p>Ambos son verdaderos</p>";
}
if ($b2 || $b4){
    echo "<p>Uno de los dos es verdadero</p>";
}

$bool=true;$flo=1.5;
if ($bool){
    echo "<p>El double $flo</p>";
}
if (is_numeric($flo)){
    if(is_double($flo))
        echo "<p>\$flo es numerica y es double</p>";
}elseif(is_bool($flo)){
    echo "<p>\$flo es booleana</p>";
}
if (is_numeric($bool)){
    echo "<p>$bool es numerica</p>";
}elseif(is_bool($bool)){
    echo "<p>\$bool es booleana</p>";
}

$salario_base=1000;
$salario_juan= &$salario_base;
$salario_ana= &$salario_base;
$complemento=400;
$salario_ana = $salario_ana + 400;
echo "<p>El salario actual de Juan : $salario_juan</p>";
echo "<p>El salario actual de ana : $salario_ana</p>";
$salario_base+=100;
echo "<p>El salario actual de Juan : $salario_juan</p>";
echo "<p>El salario actual de ana : $salario_ana</p>";

if(isset($x)){
    echo "<p>$x tiene valor</p>";
}
echo "<p>El tamaño de la cadena es ".strlen($a)."</p>";
echo "<p>El caracter de la cadena es ".$a[0]."</p>";
$cadena="prueba";
$cadena2 = chunk_split($cadena,$j=2,$end="X");
echo "<p>$cadena2</p>";
$cadena3 = strpos($cadena, "ba");
echo $cadena3;
echo "<p>".ucfirst($cadena)."</p>";
$ar1=array("SMR","ASIR","DAW");
$ar2=array(0=>"SMR",1=>"ASIR",4=>"DAW");
$ar3[0]="SMR";$ar3[1]="ASIR";$ar3[2]="DAW";
for ($i=0;$i<count($ar2)+2;$i++){
    if (isset($ar2[$i])){
     echo "<p>$ar2[$i]</p>";
    }
}

echo "<p>".var_dump($ar2)."</p>";
echo "<p>";
print_r($ar3);
echo "</p>";

echo "<ul>";         
foreach ($ar2 as $s){
    echo "<li>$s";
}
echo "</ul>";

$ar4=array("Sergio"=>"Guijarro","Manu"=>"Rompecosas","Ming"=>"Es Ming");
echo "<p>";
print_r($ar4);
echo "</p>";


echo "<p>".var_dump($ar1)."</p>";
sort($ar1);
echo "<p>".var_dump($ar1)."</p>";
echo "<p>".var_dump($ar4)."</p>";
ksort($ar4);
echo "<p>".var_dump($ar4)."</p>";
$ar5["Sergio"]="Sneo95";$ar5["Sergio2"]="El machote";
echo "<p>";
print_r($ar5);
echo "</p>";
echo "<ul>";
foreach ($ar4 as $s=>$x){
    echo "<li>$s $x";
}
echo "</ul>";
$x=0;
do{
switch ($x){
    case 1:
        echo "<p>$x</p>";
        break;
    case 2:
        echo "<p>$x</p>";
        break;
    case 3:
        $d=0;
        while ($d<$x){
            echo "<p>\$d $d</p>";
            $d++;
        }
        break;
}
$x++;
}while($x<4);

echo "<p>Nombre del archivo :".$_SERVER['PHP_SELF']."</p>";
echo "<p>Cabecera :".$_SERVER['HTTP_HOST']."</p>";

function producto($a,$b){
    return $a*$b;
}
echo "<p>El producto de 2 y 5 es ".producto(2, 5)."</p>";
function producto2($a,$b,$imp=true){
    if($imp)
        return "<p>El resultado es ".$a*$b."</p>";
}
echo producto2(2, 5);

echo "<p>La fecha de hoy es: ".date('l jS \of F Y h:i:s A')."</p>";
$cupon=10;
function compra($a,$b){
        global $cupon;
        $resultado=$a*$b;
        return $resultado-$cupon;
}
echo "<p>La compra con descuento es: ".compra(10, 5)."</p>";

?>

<?php 
    if (!isset($_POST["enviar"])){
    ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    Nombre<input type="text" name="nombre">
    <input type="submit" name="enviar">
    </form>
<?php 
    }else{
        echo "<h1>".$_POST["nombre"]."</h1>";
    }
    ?>
    

</body>
</html>