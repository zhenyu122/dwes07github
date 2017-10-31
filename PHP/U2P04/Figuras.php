<?php
class Figuras{
    private $nombre,$color;
    function __construct($nombre,$color){
        $this->nombre=$nombre;
        $this->color=$color;
    }
    function getNombre(){
        return $this->nombre;
    }
    function getColor(){
        return $this->color;
    }
    function setNombre($nombre){
        $this->nombre=$nombre;
    }
    function setColor($color){
        $this->color=$color;
    }
    function ver(){
        echo "Foreach: ";
        foreach ($this as $clave => $valor){
            print "$clave => $valor \n";
        }
    }
}
?>