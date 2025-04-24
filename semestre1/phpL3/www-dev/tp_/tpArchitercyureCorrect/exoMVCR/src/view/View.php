<?php
require_once("model/Animal.php");
require_once("Router.php");
class View
{
  private $title, $content,$router;
  public function __construct($routeur){
    $this->router = $routeur;
  }
  public function render(){
    include_once("squelette.php");
  }
  public function makeTestPage()
  {
    $this->title = "Chat";
    $this->content = "Animale domestique";
  }
  public function makeAnimalPage(Animal $a){
    $this->title = " Page sur ".$a->getNom();
    $this->content = $a->getNom()." est un animal de l'espèce "
                    .$a->getEspecies()." âgé de ".$a->getAge();
  }
  public function makeUnknownAnimalPage()
  {
    $this->title = "Inconnu";
    $this->content = "L'animal rechercher est inconnu ...";
  }
  public function makeHomePage()
  {
    $this->title = "Accueil";
    $this->content = "Bienvenue sur notre page d'animaux :)";
  }
  public function makeListPage($animalsTab){
    $this->title = "Liste d'animaux";
    $this->content = "<nav><ul>";
    foreach ($animalsTab as $key => $value) {
      $nom = $value->getNom();
      $url = $this->router->getAnimalURL($key);
      $this->content .= "<li><a href=".$url.">".$nom."</a></li>";
    }
    $this->content .="</ul></nav>";
  }
  public function makeDebugPage($variable) {
    $this->title = 'Debug';
    $this->content = '<pre>'.htmlspecialchars(var_export($variable, true)).'</pre>';
  }
  public function makeAnimalCreationPage()
  {
    // $url = $this->router->getAnimalSaveURL();
    $this->title = "Creation d'animal";
    $this->content = 'toto '; /*'<form action="'.$url.' method="post">'.
    '<label>
        <input required type="text" name="nom" placeholder="Name">
    </label>
    <label>
        <input required type="text" name="espece" placeholder="Espèce">
    </label>
    <label>
        <input required type="text" name="age" placeholder="Age">
    </label>
    <label>
        <input type="submit" name="submit" value="Valider">
    </label>
    </form>'; */
  }
}

 ?>
