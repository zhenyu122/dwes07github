<?php
class Obra{
    private $ID,$Titulo,$Compania,$Imagen,$Nombre;
    
    function getID(){
        return $this->ID;
    }
    function getTitulo(){
        return $this->Titulo;
    }
    function getCompania(){
        return $this->Compania;
    }
    function getNombre(){
        return $this->Nombre;
    }
    function getImagen(){
        return $this->Imagen;
    }
    function __toString(){
        return "ID: ".$this->ID."Titulo: ".$this->Titulo." Compania: ".$this->Compania."Nombre Compania: ".$this->Nombre." Imagen: ".$this->Imagen;
    }
}
?>