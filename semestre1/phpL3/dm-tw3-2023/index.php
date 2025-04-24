<?php 
        include("includes/functions.php") ;
    /* creation d'un array qui contient les liens du site plus precissement liens du nav */
        $tabLiens = array(
            "List Cars" => "index.php?action=list",
            "Add Car"  => "index.php?action=add",
            "À propos" => "index.php?action = apropos"
            
        );
    /* recuperation et verification de la variable du lien action */
    $action = key_exists("action" , $_GET)?$_GET["action"]:null;
    $idV = key_exists("idV" , $_GET)?$_GET["idV"]:null;

    switch ($action) {
        case 'list':
            include("includes/list.php");
            if($idV==null)
               selectAll() ; 
            else{
                selectById($idV);
            }
            $contenu= $corps ;
            break;
        case 'add';
            include("includes/add.php") ;
            break;
        case 'delete':
            include("includes/delet.php");
            $contenu = $corps ;
            break;
        case 'update':
            include("includes/update.php");
            
            break;
        default:
            $contenu = "<h1>ACCUEIL</h1>";
            break;
    }
        
    include("includes/squelettes.php");
   
?>