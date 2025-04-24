<?php

class Controller
{
  private $view;
  private $store;
  function __construct($vue,$store)
  {
    $this->view = $vue;
    $this->store = $store;
  }
  public function showList(){
    $this->view->makeListPage($this->store->readAll());
  }
  public function showInformation($id){
    if(key_exists($id,$this->store->readAll()))
    {
      $animal = $this->store->read($id);
      $this->view->makeAnimalPage($animal);
    }
    else {
      $this->view->makeUnknownAnimalPage();
    }
  }
  public function saveNewAnimal($data)
  {
    $this->view->makeDebugPage($data);
  }
}

 ?>
