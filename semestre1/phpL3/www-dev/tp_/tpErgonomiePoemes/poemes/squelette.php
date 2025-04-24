<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title><?php echo $title; ?></title>
  </head>
  <body>
    <?php
    echo "<nav>" ;
    foreach($pTitre as $k => $v) {
      echo '<a href=?poeme='.$k.'>'.$v.'</a><br>';
    }
    echo '</nav>';
    ?>
    <form  action="./index.php" method="get">
      <label>
        search :
        <input type="text" name="recherche" placeholder="Chercher un poeme !!" required>
        <button type="submit" >search</button>
      </label>
    </form>
    <?PHP
    if($title === "Accueil")
      echo "<h1>Bienvenu à la page d'accueil</h1>";
    elseif($title === "Error")
    {
      echo "<h1>".$title."</h1>";
      echo "<h2>Erreur sur le nom du poeme</h2>";
    }
    else
    {
        echo "<h1>C'est le poeme ".$title."</h1>";
        echo "<h2>L'auteur est ".$auteur."</h2>";
        echo '<img src='.$image.' alt='.$auteur.'>';
        echo $textes;
    }
   ?>
  </body>
</html>
