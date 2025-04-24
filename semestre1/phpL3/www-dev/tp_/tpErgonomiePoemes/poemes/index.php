<?php
require_once("./donnees.php");
// question 3 et 7
foreach ($store->readAllPoems() as $k => $v) {
  $pTitre[$k] = $v->getTitle();
}
//question 4
if(key_exists("recherche",$_GET))
{
  if(htmlspecialchars($_GET["recherche"],ENT_QUOTES,"UTF-8") !=="")
  {
    $listPoem = array();
    $search = htmlspecialchars($_GET["recherche"],ENT_QUOTES,"UTF-8");
    foreach ($store->readAllPoems() as $k => $v)
    {
      if(strpos($v->getHtmlText(),$search) !== false){
        $listPoem[$k] = $v;
      }
    }
    if($listPoem !== [])
    {
      $title = "search";
    }
    else
        $title = "Error";
  }
  else{
      $title = "Error";
  }
  require_once("./searchSquelette.php");
}

else
{
  $title = "Accueil";
  if(key_exists("poeme",$_GET))
  {
    if(key_exists(htmlspecialchars($_GET["poeme"],ENT_QUOTES,"UTF-8"),$store->readAllPoems()))
    {
      $poem = $store->readPoem(htmlspecialchars($_GET["poeme"],ENT_QUOTES, "UTF-8"));
      $title = $poem->getTitle();
      $auteur = $poem->getAuthor();
      $image = $poem->getImageUrl();
      $textes = $poem->getHtmlText();
    }
    else {
      $title = "Error";
    }
  }
  require_once("./squelette.php");
}
 ?>
