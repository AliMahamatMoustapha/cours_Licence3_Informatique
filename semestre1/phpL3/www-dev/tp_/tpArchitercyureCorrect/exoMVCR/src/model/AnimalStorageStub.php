<?php
require_once('AnimalStorage.php');
require_once('Animal.php');
class AnimalStorageStub implements AnimalStorage
{
  private $animalsTab;
  function __construct()
  {
    $this->animalsTab = array(
        	'medor' => new Animal('Médor', 'chien', '2 ans'),
        	'felix' => new Animal('Félix', 'chat', '3 ans'),
        	'denver' => new Animal('Denver', 'dinosaure', '20 ans'),
                );
  }
  public function read($id){
    if(key_exists($id,$this->animalsTab)){
      return $this->animalsTab[$id];
    }
    else{
      return null;
    }
  }
  public function readAll(){
    return $this->animalsTab;
  }
}

 ?>
