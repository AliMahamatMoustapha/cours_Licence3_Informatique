<?php
    include("db_connect.php") ;
    $requette = "DELETE FROM VOITURE WHERE idV=:idV";
    $prepareQuery = $pdo ->prepare($requette) ;
    $prepareQuery -> execute(array(':idV'=> $idV)) ;
    $corps = '<script>alert("Vous venez de supprimer la Voiture");</script>' ;

?>