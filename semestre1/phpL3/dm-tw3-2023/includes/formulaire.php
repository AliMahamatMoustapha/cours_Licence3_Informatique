<?php

$corps =<<<EOT
  <form method="post" action="index.php?action={$cible}&idP={$idV}" name="form_user" >
  <label>Modele</label>
  <input type="text" name="modeleV" size="40" value="">
  <span class="">{$erreur["modeleV"]}</span><br>
    
  <label>Marque</label>
  <input type="text" name="marqueV" size="40" value="">
  <span class="">{$erreur["marqueV"]}</span><br>

  <label> Prix </label> 
  <input type="text" name="prixV" size="40" placeholder="prix voiture" value="">
  <span class="">{$erreur["prixV"]}</span> <br>

  <label>Couleur carrosserie</label>
  <input type="color" name="couleurV" size="40"  value="">
  <span class="">{$erreur["couleurV"]}</span> <br>
  <input type="submit" name="user_valider" value="Envoyer" size="40" >
      
</form>

EOT;
$contenu=$corps ;
?>