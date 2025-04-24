<?php
if (key_exists('theme',$_GET)) {
  if($_GET['theme'] === "clair")
  {
    echo "-----------clair------";
    $theme = "./clair.css";
  }
  elseif ($_GET['theme'] === "sombre") {
    echo "-----------Sombre------";
    $theme = "./sombre.css";
  }
  else {
    echo "-----------par defaut --------";
    $theme = "clair.css";
  }
}
else {
  echo "-----------sans css --------";
  $theme = "clair.css";
}
 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>EXO3</title>
    <link rel="stylesheet" href=<?php echo $theme; ?>>
  </head>
  <body>
    <header>
      <menu>
        <ul>
          <li>
            <a href="exo3.php">Acceuil</a>
          </li>
          <li>
            <a href="?theme=clair">Clair</a>
          </li>
          <li>
            <a href="?theme=sombre">Sombre</a>
          </li>
        </ul>
      </menu>
    </header>
    <p>Boujour!!!</p>
  </body>
</html>
