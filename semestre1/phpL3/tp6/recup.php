<?php 
$nom = $_POST["nom"] ;
$couleur = $_POST["couleur"];
$langue=$_POST["langue"];
if(isset($nom) && empty($nom)){
    $nom = "X" ;
}
switch ($couleur) {
    case "rouge":
        $couleur="red";
        break;
    case "vert":
        $couleur ="green";
        break ;
    case "bleu":
        $couleur="blue";
        break ;
    
    default:
        $couleur="white";
        break;
}
foreach($langue as $choix){
    if($choix=="fr"){
        echo "Bonjour $nom"; echo "<br>";
    }
    if($choix=="en"){
        echo "Hello $nom"; echo"<br>";
    }
    if($choix=="de"){
        echo "holla $nom ";
    }
    else{

        include ("erreur.html") ;
    }
    
}
/*if(isset($langue) && empty($langue)) {
    echo "<script> 
    let lient = document.querySelector('form') ;
    lient.setAttribute('action','erreur.html');
    
    </script>" ; 
}*/
echo "<style> body{ background-color : ".$couleur.";} </style>" ;

?>