<?php
function validar_clave($clave){
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
function validar_fecha($fecha){
    $valores = explode('/', $fecha);
    if(count($valores) == 3 && checkdate($valores[1], $valores[0], $valores[2])){
        return true;
    }else 
        return false;
}
function validar_tel($tel){
    if(strlen($tel)!= 9){
        return false;
    }else
        return true;
}
?>