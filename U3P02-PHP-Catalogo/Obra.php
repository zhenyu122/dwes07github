<?php
Class Obra{
    private $titulo,$compania,$imagen;
    
    function getTitulo(){
        return $this->titulo;
    }
    function getCompania(){
        return $this->compania;
    }
    function getImagen(){
        return $this->imagen;
    }
    function __toString(){
        return "Titulo: ".$this->titulo." Compania: ".$this->compania.
        " Imagen: ".$this->imagen;
    }
}
?>