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
<form action="/U02P03-Control_de_flujo/ecf-cuadrado.php" method="post">
Numero<input type="text" name="num">
<input type="submit" name="enviar">
</form>
    <?php 
    }else{
        $x=$_POST["num"];
        $num=1;
        ?>
    <table border="1">
         <?php
         for($i=1;$i<=$x;$i++){
             
          echo "<tr>";
          for($j=1;$j<=$x;$j++){
           if($i%2==0){
               echo "<td style='padding:3px;
                        background-color:lightblue;'>".$num."</td>";
            $num++;
           }else{
               echo "<td style='padding:3px;'>".$num."</td>";
            $num++;
            }
           }
           echo "</tr>";
           
          }
    }
        ?>
	</table>
<br>
<a href="index.php">Volver</a>
</body>
</html>