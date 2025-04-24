<?php
// echo 'Hello world pour tester le serveur. Une petite notice PHP pour voir à quoi ça ressemble :';
// echo $variable_inexistante;
session_start();
header('Content-Type:'.key_exists('action',$_GET)?'text/plain':'text/html'.'Location:squelete.php');
include('data.php');
$action = key_exists('action',$_GET)?$_GET['action']:null ;
$title = "";
$content = "";
$n  = count($IMAGE_URLS);
$alea = rand(0, $n-1) ;
$url = $IMAGE_URLS[$alea] ;
if ($action!==null){
    switch ($action) {
        case 'url':
            echo($IMAGE_URLS[$alea]);
            $_SESSION= $url ;
            break;
        case 'redirect' :
            header('Location: '.$url,true,303 );
            die();
            break;
        case 'page': 
            $title = 'image correspondant l\'url' ;
            $content ='<img src = "'.$url.'" />';
            include('squelette.php');
            break ;
        case 'gallery' :
            $title = 'galerie';
            $content = '<ul>';
            $i = 0 ;
            while($i<10){
                $content .='<li><img src = "'.$url.'"/></li>';
                $i +=1;
            }
            $content .='</ul>';
            include('squelette.php');
            break ;
        case 'history':
            $title = 'history';
            $content = '<ul>';
            $taille = count($_SESSION);
            if($taille<20){
                $i = 0 ;
                while($i<$taille){
                    $content .='<li><img src = "'.$_SESSION[$i].'"/></li>';
                    $i +=1;
                }
            }
            else{
                $taille =count($_SESSION);
                for ($i = $taille;$i<$taille ; $i--){
                    $content .='<li><img src = "'.$_SESSION[$i].'"/></li>';
                }
            }
            
            // var_dump($_SESSION);
            $content .='</ul>';
            include('squelette.php');
            break;
                
        default:
            $title = "Erreur";
            $content = "pas plain text !)";
            include('squelette.php');
            break;
    }
   
}


?>