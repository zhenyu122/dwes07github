<?php
class Triangulo extends Figuras{
    public $base;
    private $altura;
    
    function __construct($altura,$base){
        $this->altura=$altura;
        $this->base=$base;
    }
    
     public function getAltura(){
         return $this->altura;
     }
     
     public function setAltura($altura){
         $this->altura=$altura;
     }
     
     public function calcularArea(){
         return $this->base * $this->altura / 2;
     }
     
     public function __toString(){
         return "Triángulo de base ".$this->base." y altura ".$this->altura.".";
     }
}

?>