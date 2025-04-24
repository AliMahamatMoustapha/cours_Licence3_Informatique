<?php 


class Voiture
{
    private $idV;
    private $modeleV;
    private $marqueV;
    private $prixV;
    private $couleurV ;
	

    //Constructeur
    public function __construct($idV,$modeleV,$marqueV,$prixV,$couleurV)
    {
        $this->idV=$idV;
        $this->modeleV=$modeleV;
        $this->marqueV=$marqueV;
        $this->prixV = $prixV;
        $this->couleurV = $couleurV;
    }

    //
    public function __toString()
    {
        $textAdd= "(<u><b>".$this->idV."</b></u>, ".$this->modeleV.", ". $this->marqueV.", ". $this->prixV.", ".$this->couleurV." )<br>";
        return $textAdd;
    }
}

$erreur=array("modeleV"=>null,"marqueV"=>null,"prixV"=>null,"couleurV"=>null);
?>