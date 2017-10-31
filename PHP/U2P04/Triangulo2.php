<?php
class Triangulo2 extends Figuras{
    protected $lado;
    
    function __construct($nombre,$color){
        parent::__construct($nombre, $color);
        $this->lado=3;
    }
    function getLado(){
        return $this->lado;
    }
    
    function ver(){
        parent::ver();
    }
}

?>