<?php
// Inclure le fichier de configuration
include("../../private/mysqlConfi.php");
// Connexion à la base de données avec PDO
try {
    $pdo = new PDO(DNS, UTILISATEURS, MOTDEPASSE);
    $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_OBJ);
} catch(PDOException $e){
    die("La connexion a échoué: " . $e->getMessage());
}
?> 