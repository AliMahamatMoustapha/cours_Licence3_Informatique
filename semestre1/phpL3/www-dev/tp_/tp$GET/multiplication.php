<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Multiplication</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
      <header>
        <menu>
          <ul>
            <li>
              <a href="multiplication.php?borne=1">La plus petite table</a>
            </li>
            <li>
              <a href="multiplication.php?borne=100">La plus grande table</a>
            </li>
          </ul>
        </menu>
      </header>
      <div>
        <table>
          <?php
          function multiplication($borne)
          {
            for($i=1;$i<=$borne;$i++)
            {
              echo '<tr>';
              for($j=1;$j<=$borne;$j++){
                  echo '<td>'.$i*$j.'</td>';
              }
              echo '</tr>';
            }
          }
          if(key_exists('borne',$_GET))
          {
            if($_GET['borne'] =='0')
              echo "<strong> Borne null</strong>";
            elseif($_GET['borne'] ==='')
              echo "<strong> Borne vide</strong>";
            elseif((int)$_GET['borne'] >=1 && (int)$_GET['borne']<=100)
              multiplication((int)$_GET['borne']);
            else {
              echo "<strong>Il faut choisir un nombre entre 1 et 100.</strong";
            }
          }
          else
            Multiplication(20);
          ?>
        </table>
      </div>
  </body>
</html>
