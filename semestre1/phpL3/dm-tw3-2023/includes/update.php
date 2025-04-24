<?php
    $cible = 'update' ;
    include("db_connect.php") ;

    $requete="SELECT * FROM VOITURE WHERE idV=$idV";
    $query  = $pdo->query($requete);
    //$resultat=$query->setFetchMode(PDO::FETCH_OBJ);
    var_dump($resultat) ;
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

    if ($compteur_erreur == 0) {
        #$sql = "UPDATE PersonnE SET nom=?, prenom=? WHERE idP=?";
        $sql="update VOITURE set Modele='$modeleV', Marque='$marqueV',Prix='$prixV', where idP='$idV'";
        $tab='<form action="index.php?action=sauvegarde" method="post">
            <input type="hidden" name="type" value="'.'confirmupdate'.'"/>
            <input type="hidden" name="idP" value="'.$idV.'"/>
            <input type="hidden" name="sql" value="'.$sql.'"/>
            <p>Etes vous sûr de vouloir mettre à jour ce patient ?</p>
            <p>
            <input type="submit" value="Enregistrer" class="btn btn-danger">
            <a href="indexR.php" class="btn btn-secondary">Annuler</a>
            </p>
        </form>';
        $corps = $tab;  
        $contenu=$corps ;
    }
    else {
        include("formulaire.html");
    }
    }

    $pdo = null;
    ?> 