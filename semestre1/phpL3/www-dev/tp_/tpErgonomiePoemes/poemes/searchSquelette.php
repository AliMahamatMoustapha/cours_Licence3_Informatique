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
    if($title === "Error")
    {
      echo "<h1>".$title."</h1>";
      echo "<h2>Aucun poème ne correspond à votre recherche</h2>";
      echo "<h3>Essayer de chercher avec un texte valide :)</h3>";
    }
    else
    {
        echo "<h1> Liste des poemes trouvés </h1>";
        echo "<nav>" ;
        foreach($listPoem as $k => $v) {
          echo "<strong>C'est le poeme <a href=?poeme=".$k.'>'.$v->getTitle().'</a></strong><br>';
        }
        echo '</nav>';
    }
   ?>
  </body>
</html>
