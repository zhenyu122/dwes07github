<?php
include 'Funciones.php';
$nombre=NULL;$ape=NULL;$pass=NULL;$email=NULL;$fecha=NULL;$dir=NULL;$tel=NULL;$ciclo=NULL;
$Obnom=false;$Obape=false;$Obpass=false;$Obemail=false;$Obfecha=false;$Obdir=false;$Obtel=false;

if (isset($_POST["enviar"])){
    /*Nombre*/
    if(validar_nom_ape($_POST["nombre"])){
        $Obnom=true;
        $nombre=$_POST["nombre"];
        $validado[]="Nombre: ".$_POST["nombre"];
    }
    /**/
    /*Apellido*/
    if(validar_nom_ape($_POST["apellido"])){
        $Obape=true;
        $ape=$_POST["apellido"];
        $validado[]="Apellido: ".$_POST["apellido"];
    }
    /*Password*/
    if (validar_clave($_POST["pass"])){
        $Obpass=true;
        $pass=$_POST["pass"];
        $validado[]="Password: ".$_POST["pass"];
    }
    /*Email*/
    if(validar_email($_POST["email"])){
        $Obemail=true;
        $email=$_POST["email"];
        $validado[]="Email: ".$_POST["email"];
    }
    
    /*Fecha*/
    if (validar_fecha($_POST["fecha"])){
        $Obfecha=true;
        $fecha=$_POST["fecha"];
        $validado[]="Fecha: ".$_POST["fecha"];
    }
    
    /*Dirección*/
    if (validar_dir($_POST["direccion"])){
        $Obdir=true;
        $dir=$_POST["direccion"];
        $validado[]="Dirección: ".$_POST["direccion"];
    }
    /*Teléfono*/
    if(!empty($_POST["tel"])){
        if (is_numeric($_POST["tel"])){
            if (validar_tel($_POST["tel"])){
                $Obtel=true;
                $tel=$_POST["tel"];
                $validado[]="Teléfono: ".$_POST["tel"];
            }
        }
    }
    /*Ciclo*/
    if (isset($_POST["ciclo"])){
        $ciclo=$_POST["ciclo"];
    }
    if($Obemail&& $Obfecha && $Obnom && $Obpass){
        if (isset($_POST["enviar"])){
            ?>
            <html>
            <head></head>
            <body>
            <ul>
           	<ins><h3>Datos</h3></ins>
            <?php
            foreach ($validado as $valido){
                echo "<li>$valido</li>";   
            }
            ?>
            </ul>
            </body>
            </html>
                <?php 
                
       	}
    }
    if($Obemail&& $Obfecha && $Obnom && $Obape && $Obpass && $Obdir && $Obtel){
        $completo=true;
    }
    
}
?>