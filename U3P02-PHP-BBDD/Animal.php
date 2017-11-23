<?php 
class Animal{
    private $chip,$nombre,$tipo,$imagen;
    
    /*function __construct($chip,$nombre,$especie,$imagen){
        $this->chip=$chip;
        $this->nombre=$nombre;
        $this->especie=$especie;
        $this->imagen=$imagen;
    }*/
    
    public function getChip(){
        return $this->chip;
    }
    
    public function getNombre(){
        return $this->nombre;
    }
    public function getEspecie(){
        return $this->tipo;
    }
    
    public function getImagen(){
        return $this->imagen;
    }
    
    public function __toString(){
        return "Chip: ".$this->chip."  Nombre: ".$this->nombre." Especie: ".$this->tipo." Imagen: ".$this->imagen;
    }
}
?>