<?php

class Animal
{
  private $nom,$especies,$age;
  function __construct($name,$spece,$age)
  {
    $this->nom = $name;
    $this->age = $age;
    $this->especies = $spece;
  }
  public function getNom(){
    return $this->nom;
  }
  public function getEspecies(){
    return $this->especies;
  }
  public function getAge(){
    return $this->age;
  }
}

 ?>
