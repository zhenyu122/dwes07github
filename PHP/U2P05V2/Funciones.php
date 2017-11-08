<?php
function validar_nom_ape($nombre){
    if (!empty($nombre)){
        if(!is_numeric($nombre)){
            return true;
        }else
            return false;
    }
}
function validar_email($email){
        if(filter_var($email,FILTER_VALIDATE_EMAIL)){
            return true;
        }else 
            return false;
}
function validar_dir($dir){
    if(!empty($dir)){
        return true;
    }else
        return false;
}
function validar_clave($clave){
    if(!empty($clave)){
        if(strlen($clave) < 8){
            return false;
        }
        if (!preg_match('`[a-z]`',$clave)){
            return false;
        }
        if (!preg_match('`[A-Z]`',$clave)){
            return false;
        }
        if (!preg_match('`[0-9]`',$clave)){
            return false;
        }
        return true;
    }
}
function validar_fecha($fecha){
    if (!empty($fecha)){
        $valores = explode('/', $fecha);
        if(count($valores) == 3 && checkdate($valores[1], $valores[0], $valores[2])){
            return true;
        }else 
            return false;
    }
}
function validar_tel($tel){
    if(strlen($tel)!= 9){
        return false;
    }else
        return true;
}
?>