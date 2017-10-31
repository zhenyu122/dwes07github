<?php
include 'Figuras.php';
class Cuadrado extends Figuras{
    protected $lado;
    function __construct($nombre,$color){
        parent::__construct($nombre, $color);
        $this->lado=4;
    }
    function getLado(){
        return $this->lado;
    }
    function ver(){
        parent::ver();
    }
}
?>