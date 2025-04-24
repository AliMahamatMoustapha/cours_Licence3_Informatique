<?php
var_dump($_GET);
if(key_exists('number',$_GET))
{
  $_GET['borne'] = $_GET['number'];
  echo "la borne est :".$_GET['borne'];
}
print_r($_GET)
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>form</title>
    <style media="screen">
      form{padding:6px; border:1px solid;}
    </style>
  </head>
  <body>
    <form method="get"action="./../tp$GET/multiplication.php">
      <label>
        Taille de la table :
        <input required type="number" min="1" max="100" name="borne" value="">
        <button type="submit" >Afficher</button>
      </label>
    </form>
  </body>
</html>
