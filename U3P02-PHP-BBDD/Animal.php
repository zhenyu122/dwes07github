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
    
    function getNombre(){
        return $this->nombre;
    }
    function getEspecie(){
        return $this->tipo;
    }
    
    function getImagen(){
        return $this->imagen;
    }
    
    public function __toString(){
        print_r( "Chip: ".$this->chip."  Nombre: ".$this->nombre." Especie: ".$this->tipo." Imagen: ".$this->imagen);
    }
}
?>