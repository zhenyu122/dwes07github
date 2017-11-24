<?php
class Obra{
    private $id,$titulo,$compania,$imagen;
    
    public function getID(){
        return $this->id;
    }
    public function getTitulo(){
        return $this->titulo;
    }
    public function getCompania(){
        return $this->compania;
    }
    public function getImagen(){
        return $this->imagen;
    }
    public function __toString(){
        return "ID: ".$this->id."Titulo: ".$this->titulo." Compania: ".$this->compania." Imagen: ".$this->imagen;
    }
}
?>