<?php
  setcookie("date",date('l jS \of F Y h:i:s A'),time() + 30);
  if(key_exists("date",$_COOKIE))
  {
    $last_cookie = htmlspecialchars($_COOKIE["date"]);
    echo '<h1>COOKIE</h1>';
    echo "Nous sommes le ".date('l jS \of F Y h:i:s A').'<br>';
    echo "Votre dernière visite remonte au ".$last_cookie.'<br>';
  }
 ?>
