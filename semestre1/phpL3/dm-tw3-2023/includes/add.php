<?php 
$cible = 'add' ;
$contenu = "";
if (!isset($_POST["modeleV"])    && !isset($_POST["marqueV"]) && !isset($_POST["prixV"])
&& !isset($_POST["couleurV"]) )
{
    include("formulaire.php");
}
else{
    $modeleV = key_exists('modeleV', $_POST)? htmlspecialchars(trim($_POST['modeleV'])): null;
    $marqueV = key_exists('marqueV', $_POST)? htmlspecialchars(trim($_POST['marqueV'])): null;
    $prixV = key_exists('prixV', $_POST)? htmlspecialchars(trim($_POST['prixV'])): null;
    $couleurV = key_exists('couleurV', $_POST)? htmlspecialchars(trim($_POST['couleurV'])): null;

    if ($modeleV=="")   $erreur["modeleV"] ="il manque le modele"; 
    if ($marqueV=="")   $erreur["marqueV"] ="il manque la marque";  
    if ($prixV=="")     $erreur["prixV"] ="il manque le Prix"; 
    if ($couleurV=="")  $erreur["couleurV"] ="il manque la couleur"; 

    $compteur_erreur=count($erreur);
    foreach ($erreur as $cle=>$valeur){
        if ($valeur==null) $compteur_erreur=$compteur_erreur-1;
    }

    if ($compteur_erreur == 0) {
        include("db_connect.php") ;
        global $pdo ;
        $requete="INSERT INTO VOITURE(Modele,Marque,Prix,Couleur) VALUES
                                     (:Modele,:Marque,:Prix,:Couleur)";
        $prepareQuery =$pdo->prepare($requete);
        $prepareQuery->execute(array(
            ':Modele' => $modeleV ,
            ':Marque' => $marqueV ,
            ':Prix'   => $prixV ,
            ':Couleur'=> $couleurV
        ));
        $resultat = $prepareQuery->fetch();
        $idV = $pdo->lastInsertId();
        $VoitureV = new Voiture($idV,$modeleV,$marqueV,$prixV,$couleurV);
        $corps = "you successfully added a Car: ". $VoitureV;
        $contenu=$corps ;
        //$contenu .= "insertion avec successe";
    }
    else {
        include("formulaire.php");
    }
}

?>