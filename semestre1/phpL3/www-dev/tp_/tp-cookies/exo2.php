<?php
  session_name("AHMATSESSION");
  session_start();
  if(key_exists('button',$_POST))
  {
    session_destroy();
    header("Location:exo2.php",true,303);
    die();
  }
  echo "<h1>SESSION</h1>";
  if(!(key_exists('date',$_SESSION)) || !(key_exists('cpt',$_SESSION)))
  {
    echo "C’est votre première visite ! Bienvenue.";
    $_SESSION['date'] =  date('h:i:s');
    $_SESSION['cpt'] = 1;
  }
  else{
    echo "Vous avez visité cette page ".$_SESSION['cpt']." fois depuis".$_SESSION['date']."<br>";
    $_SESSION['cpt'] += 1;
  }

 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>SESSION</title>
  </head>
  <body>
    <form  action="exo2.php" method="post">
      <input type="submit" name="button" value="submit">
    </form>
  </body>
</html>
