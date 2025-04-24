<!doctype html>
<html lang="fr">
<head>
  <title>Voiture</title>
</head>
<main>
    <header>
            <nav>
                <ul>
                    <?php 
                        foreach($tabLiens as $nomLien => $lien){
                            echo '<li><a href="'.$lien.'">'.$nomLien.'</a></li>'; 
                        }
                    
                    ?>

                </ul>
            </nav>
    </header>
</main>
<body> 
    <?php echo $contenu; ?>
</body>
</html>
