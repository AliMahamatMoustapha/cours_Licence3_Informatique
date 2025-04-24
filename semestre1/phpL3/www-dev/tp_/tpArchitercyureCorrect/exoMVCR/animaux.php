<?php
/*
 * On indique que les chemins des fichiers qu'on inclut
 * seront relatifs au répertoire src.
 */
set_include_path("./src");

/* Inclusion des classes utilisées dans ce fichier */
require_once("Router.php");
require_once("model/AnimalStorageFile.php");
require_once("lib/ObjectFileDB.php");

/*
 * Cette page est simplement le point d'arrivée de l'internaute
 * sur notre site. On se contente de créer un routeur
 * et de lancer son main.
 */
$db = new ObjectFileDB("/users/21912949/tmp/animaux.txt");
$animaux = new AnimalStorageFile($db);
//$animaux->reinit();
$router = new Router();
$router->main($animaux);
?>
