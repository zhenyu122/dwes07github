<?php 
class Animal{
    public $chip,$nombre,$tipo,$imagen;
    
    public function datos(){
        return "Chip: ".$this->chip."  Nombre: ".$this->nombre." Especie: ".$this->tipo." Imagen: ".$this->imagen;
    }
}
?>