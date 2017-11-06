<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Validación</title>
<style type="text/css">
label {display:inline-block;width: 80px;}
input[type="text"]{width: 200px;margin-bottom: 5px;}
input[type="email"]{width: 200px;margin-bottom: 5px;}
input[type="password"]{width: 200px;margin-bottom: 5px;}
input[type="tel"]{width: 200px;margin-bottom: 5px;}
input[type="date"]{width: 200px;margin-bottom: 5px;}
a{color:red;}
</style>
</head>
<body>
<h1>Validación</h1>
<?php
include 'Funciones.php';
$nombre=NULL;$ape=NULL;$pass=NULL;$email=NULL;$fecha=NULL;$dir=NULL;$tel=NULL;$ciclo=NULL;
$Obnom=false;$Obpass=false;$Obemail=false;$Obfecha=false;

    if (isset($_POST["enviar"])){
        /*Nombre*/
        if (!empty($_POST["nombre"])){
            if(!is_numeric($_POST["nombre"])){
                $nombre=$_POST["nombre"];
            }
       }
        /*Apellido*/
        if(!empty($_POST["apellido"])){
            if(!is_numeric($_POST["apellido"])){
                $ape=$_POST["apellido"];
            }
        }
        /*Password*/
        if(!empty($_POST["pass"])){
            if (validar_clave($_POST["pass"])){
                $pass=$_POST["pass"];
            }
        }
        /*Email*/
        if (!empty($_POST["email"])){
            if(filter_var($_POST["email"],FILTER_VALIDATE_EMAIL)){
                $email=$_POST["email"];
            }
        }
        
        /*Fecha*/    
        if (!empty($_POST["fecha"])){
            if (validar_fecha($_POST["fecha"])){
                $fecha=$_POST["fecha"];
            }
        }
            
        /*Dirección*/
        if (!empty($_POST["direccion"])){
            $dir=$_POST["direccion"];
        }
        /*Teléfono*/
        if(!empty($_POST["tel"])){
            if (is_numeric($_POST["tel"])){
                if (validar_tel($_POST["tel"])){
                    $tel=$_POST["tel"];
                }
            }
        }
        /*Ciclo*/
        if (isset($_POST["ciclo"])){
            $ciclo=$_POST["ciclo"];
        }
      
       
    }
    if(!$Obemail || !$Obfecha || !$Obnom || !$Obpass){
    ?>
    <fieldset>
    <legend>Introduce los datos</legend>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"],ENT_QUOTES,"UTF-8")?>" method="post">
    <label>Nombre</label><input type="text" name="nombre" value="<?php echo $nombre?>" required="required">
    <?php 
    if (isset($_POST["enviar"])){
        if(validar_nombre($_POST["nombre"])){
            $Obnom=true;
            $validado[]="Nombre: ".$_POST["nombre"];
        }else
            echo "<a>*El nombre introducido no es una cadena</a>";
    }
    ?><br>
    
    <label>Apellido</label><input type="text" name="apellido" value="<?php echo $ape?>">
    <?php 
    if (isset($_POST["enviar"])){
        if(!empty($_POST["apellido"])){
            if(!is_numeric($_POST["apellido"])){
                $validado[]="Apellido: ".$_POST["apellido"];
            }else
                echo "<a>* El apellido introducido no es una cadena</a>";
        }else
            echo "<a>* Introduce un apellido</a>";
    }
    ?>
    <br>
    <label>Password</label><input type="password" name="pass" value="<?php echo $pass?>" required="required">
    <?php 
    if (isset($_POST["enviar"])){
        if (validar_clave($_POST["pass"])){
            $Obpass=true;
            $validado[]="Password: ".$_POST["pass"];
        }else
           echo "<a>* La contraseña no cumple los requisitos</a>";
    }
    ?><br>
    <label>E-mail</label><input type="email" name="email" value="<?php echo $email?>" required="required">
    <?php 
    if (isset($_POST["enviar"])){
        if(filter_var($_POST["email"],FILTER_VALIDATE_EMAIL)){
            $Obemail=true;
            $validado[]="Email: ".$_POST["email"];
        }else
            echo "<a>* E-mail no valido</a>";
    }
    ?><br>
    <label>Fecha nacimiento</label><input type="date" name="fecha" value="<?php echo $fecha?>" required="required">
    <?php 
    if (isset($_POST["enviar"])){
        if (validar_fecha($_POST["fecha"])){
            $Obfecha=true;
            $validado[]="Fecha: ".$_POST["fecha"];
        }else
            echo "<a>* Fecha no valida</a>";
    }
    ?><br>
    <label>Dirección</label><input type="text" name="direccion" value="<?php echo $dir?>">
    <?php 
      if (isset($_POST["enviar"])){
          if (!empty($_POST["direccion"])){
              $validado[]="Dirección: ".$_POST["direccion"];
          }else
              echo "<a>* Introduce una direccion</a>";
      }
     ?><br>
    <label>Teléfono</label><input type="tel" name="tel" value="<?php echo $tel?>">
    <?php 
      if (isset($_POST["enviar"])){
          if (is_numeric($_POST["tel"])){
              if (validar_tel($_POST["tel"])){
                  $validado[]="Teléfono: ".$_POST["tel"];
              }else
                  echo "<a>* Teléfono tiene que tener 9 cifras</a>";
          }else
              echo "<a>* Introduce un teléfono</a>";
      }
     ?><br>
    <label>Ciclo</label>
    <select name="ciclo">
    	<option value="DAW" <?php 
    if (isset($_POST["enviar"])){
    if($ciclo== "DAW"){
        echo 'selected="selected"';
    }
    }
    ?>>DAW</option>
    	<option value="ASIR" <?php 
    if (isset($_POST["enviar"])){
    if($ciclo== "ASIR"){
        echo 'selected="selected"';
    }
    }
    ?>>ASIR</option>
    </select>
    <?php 
      if (isset($_POST["enviar"])){
              $validado[]="Ciclo: ".$_POST["ciclo"];
      }
     ?><br>
    <input type="submit" name=enviar>
    </form>
    </fieldset>
   	<?php 
    }
       	if (isset($_POST["enviar"])){
           	    ?>
            <ul>
           	<ins><h3>Datos</h3></ins>
            <?php
            foreach ($validado as $valido){
                echo "<li>$valido</li>";   
            }
            ?>
            </ul>
                <?php 
       	}
    
   	?>
</body>
</html>