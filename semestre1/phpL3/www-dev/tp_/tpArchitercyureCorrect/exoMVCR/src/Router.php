<?php
require_once("control/Controller.php");
require_once("view/View.php");
class router{
  public function main($animaux){
    $vue = new View($this);
    //$vue->makeTestPage();
    $control = new Controller($vue,$animaux);
    var_dump($_POST);
    var_dump($_GET);
    if(key_exists("action",$_GET))
    {
     
      if($_GET["action"]==="nouveau")
      {
        $vue->makeAnimalCreationPage();
      }
      else if($_GET["action"]==="sauverNouveau")
      {
        $control->saveNewAnimal($_POST);
      }
    }
    if(key_exists('PATH_INFO',$_SERVER))
    {

      if(in_array("list",explode("/",$_SERVER['PATH_INFO'])))
      {
        $control->showList();
      }
      else{
        $a = substr($_SERVER['PATH_INFO'],1);
        $tmp = htmlspecialchars($a,ENT_QUOTES,"UTF-8");
        $control->showInformation($tmp);
        //$vue->makeDebugPage($tmp);
      }
    }
    else {
      $vue->makeHomePage();
    }

    $vue->render();

  }
  public function getAnimalURL($id){
    return "./".$id;
  }
  public function getAnimalCreationURL()
  {
    return "./?action=nouveau";
  }
  public function getAnimalSaveURL()
  {
    return "./?action=sauverNouveau";
  }
}
?>
