<?php 
if (!isset($_POST["enviar"])){
    header("Location: FormularioV2.php");
}
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Validación</title>
</head>
<body>
<?php 
include 'Funciones.php';
if (isset($_POST["enviar"])){
    if(validar_nom_ape($_POST["nombre"])){
        $Obnom=true;
        $nombre=$_POST["nombre"];
        $validado[]="Nombre: ".$_POST["nombre"];
    }
}
?>
</body>
</html>