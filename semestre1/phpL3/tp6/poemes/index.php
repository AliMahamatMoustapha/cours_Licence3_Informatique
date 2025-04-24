<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>document</title>
</head>
<body>
    <?php
    include ("donnees.php") ; 
    $tab ="<ul>";
     foreach($donnees as $cle => $valeur){
		 $tab.= "<li><a action='GET' href='index.php?poeme=$cle'>".$valeur["titre"]."</a></li>";
		 }
    
	echo "$tab.</ul>";
	if(!empty($_GET["poeme"]) && isset($_GET["poeme"])){
	$paraUrl = $_GET["poeme"]; 
	echo "<h1>$paraUrl</h1>" ;
	$imgaName=$donnees[$paraUrl]["image"] ;
	include("textes/".$donnees[$paraUrl]["fragment"].".frg.html");
	echo $donnees[$paraUrl]['auteur']."<br>";
	echo "<img src ='images/".$imgaName."'/> ";
	}
  
    ?>
</body>
</html>
