<?php
require_once("./PoemStore.php");
require_once("./Poem.php");
$donnees = array(
	"boheme" => array(
		"titre" => "Ma bohème",
		"image" => "rimbaud.jpg",
		"auteur" => "Arthur Rimbaud",
		"fragment" => "ma_boheme",
	),

	"correspondances" => array(
		"titre" => "Correspondances",
		"image" => "baudelaire.jpg",
		"auteur" => "Charles Baudelaire",
		"fragment" => "correspondances",
	),

	"bois" => array(
		"titre" => "Dans les bois",
		"image" => "nerval.jpg",
		"auteur" => "Gérard de Nerval",
		"fragment" => "dans_les_bois",
	),

	"automne" => array(
		"titre" => "Chanson d'automne",
		"image" => "verlaine.jpg",
		"auteur" => "Paul Verlaine",
		"fragment" => "chanson_d_automne",
	),
);
$donnees_obj = array();
foreach ($donnees as $k => $v) {
	$donnees_obj[$k] = new Poem($v["titre"],$v["auteur"],
				file_get_contents("./textes/".$v["fragment"].".frg.html"),
				"./images/".$v["image"]);
}
$store = new PoemStore();
foreach ($donnees_obj as $k => $v) {
	$store->createPoem($k,$v);
}
unset($donnees);
unset($donnees_obj);
?>
