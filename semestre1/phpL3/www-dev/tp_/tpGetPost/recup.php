<?php
  //var_dump($_POST);
  if (!key_exists('nom',$_POST) || $_POST['nom'] ==='') {
    $_POST['nom'] = "X";
  }
  if(key_exists('couleur',$_POST))
  {
    $lang = $_POST['couleur'];
    if(key_exists('an',$lang))
      echo "Hello ".$_POST['nom'].'<br>';
    if(key_exists('fr',$lang))
      echo "Bonjour ".$_POST['nom'].'<br>';
    if(key_exists('al',$lang))
      echo "Holla ".$_POST['nom'].'<br';
  }
  else {
    header('Location: ./erreur.html');
    die;
  }
  //var_dump($_POST);
 ?>
