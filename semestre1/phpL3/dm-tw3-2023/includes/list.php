<?php  
include("db_connect.php") ;
$corps = "";
function selectAll(){
    global $corps, $pdo;
    $requette = "SELECT * FROM VOITURE";
    $query =  $pdo -> query($requette) ; 
    $query->setFetchMode(PDO::FETCH_OBJ);
    $corps.="<h1>List Cars </h1>";
    $liste='' ;
    
    while($resultat = $query->fetch()){

               $liste.= '<li><a href="index.php?action=list&idV='.$resultat->idV.'"> '.$resultat->Modele.' </li>';
              
            
    }
    $corps.='<ol>'.$liste.'</ol>';
    $pdo = null;
}
function selectById($idV){
    global $corps, $pdo;
    $requette = "SELECT * FROM VOITURE WHERE idV=:idV";
    $preparedQuery = $pdo->prepare($requette);
    $preparedQuery->execute(array(
        ':idV' => $idV
    ));
    $resultat = $preparedQuery->fetch();
    $corps=$resultat->Modele." c'est une Voiture de Marque ".$resultat->Marque." et de prix ".$resultat->Prix."$ <br>Vous pouvez supprimer ou modifier cette voiture
    <br>";
    $corps .='<a href="index.php?action=delete&idV='.$resultat->idV.'">delete </a>
              &emsp;<a href="index.php?action=update&idV='.$resultat->idV.'">Modifier </a>  ';
    $pdo = null;
}

?> 