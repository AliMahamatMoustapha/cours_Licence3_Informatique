<?php
require_once("Lib.php");
$action = key_exists('action', $_GET)? trim($_GET['action']): null;
switch ($action) {
	case "calendrier"://calendrier vide
		$zonePrincipale=Calendrier(date('Y'), date('m'));
		break;
	case "saisir": //Saisie  via le formulaire		
		if (!isset($_POST["nom"])	&& !isset($_POST["prenom"]) && !isset($_POST["dateN"]) 
		&& !isset($_POST["telephone"]) && !isset($_POST["adresse"]) ) /* et autres champs*/
		{
			include("formulairePersonne.html");
			$zonePrincipale=$corps ;
		}
		else{
			$nom = key_exists('nom', $_POST)? htmlspecialchars(trim($_POST['nom'])): null;
			$prenom = key_exists('prenom', $_POST)? htmlspecialchars(trim($_POST['prenom'])): null;
			$dateN = key_exists('dateN', $_POST)? htmlspecialchars(trim($_POST['dateN'])): null;
			$adresse = key_exists('adresse', $_POST)? htmlspecialchars(trim($_POST['adresse'])): null;
			$telephone = key_exists('telephone', $_POST)? htmlspecialchars(trim($_POST['telephone'])): null;
			$lieuN = key_exists('lieuN',$_POST)? htmlspecialchars(trim($_POST["lieuN"])) : null ;
			if ($nom=="") 	$erreur["nom"] ="il manque un nom"; 
			else {if(!ctype_alpha($nom)){
				$erreur["nom"]="nom incorect";
			} 
		}
			if ($prenom=="") $erreur["prenom"] ="il manque un prenom";  
			else {if(!ctype_alpha($prenom)){
				$erreur["prenom"]="prenom incorect";
			} 
		}
			if ($dateN=="") 	$erreur["dateN"] ="il manque la date"; 
			else{
				if(!controlerDate($dateN)){
					$erreur["dateN"] = "date incorrecte" ;
				}
			}
			if ($adresse=="") $erreur["adresse"] ="il manque votre adresse"; 
			else{
				if(!controlerAlphanum($adresse)){
					$erreur["adresse"] = "adresse incorrecte" ;
				}
			}
			if ($telephone=="") $erreur["telephone"] ="il manque votre numéro";
			else{
				if(!controlerTel($telephone)){
					$erreur["telephone"] = "numéro tel incorrect" ;
				}
			}
			if($lieuN=="") $erreur["lieuN"] = "il manque lieu de naissance";
			else {if(!ctype_alpha($lieuN)) $erreur["lieuN"]="lieu de naissance incorrect";}
			$compteur_erreur=count($erreur);
			foreach ($erreur as $cle=>$valeur){
				if ($valeur==null) $compteur_erreur=$compteur_erreur-1;
			}

			if ($compteur_erreur == 0) {
				$corps = $nom." ".$prenom."<br>";
				//Création d'objets
				//$patient = new Personne($nom,$prenom,$dateN,$telephone,$adresse);
				//file_put_contents('sauvegardeP.txt', $client,FILE_APPEND);
				//$P = file_get_contents('sauvegardeP.txt');
				//$corps .= $P;
				$zonePrincipale=$corps ;
			}
			else {
				include("formulairePersonne.html");
				$zonePrincipale=$corps ;
			}
		}
		break;
	
 default:
   $zonePrincipale="" ;
   break;
   
}
include("squelette.php");

class Personne{
	protected $nom ;
	protected $prenom ;
	protected $dateN ;
	protected $numeroT ;
	protected $adresse;
	public function __construct($nom , $prenom ,$dateN,$numeroT , $adresse){
		$this->nom= $nom ;
		$this->prenom = $prenom ;
		$this->dateN=$dateN ;
		$this->numeroT=$numeroT ;
		$this->adresse = $adresse;
	}
	public function __toString(){
		return "votre nom : $this->nom , votre prenom : $this->prenom  , vous avez $this->dateN  , 
		votre telephone : $this->numeroT  , votre adresse : $this->adresse";

	}
}
$patient = new Personne($nom,$prenom,$dateN,$telephone,$adresse);
file_put_contents('sauvegardeP.txt', $patient,FILE_APPEND);
$P = file_get_contents('sauvegardeP.txt');
$zonePrincipale.=$P ; 
?>
