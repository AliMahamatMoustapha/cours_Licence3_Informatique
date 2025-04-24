<?php

//fonctions utiles

function controlerEmail($valeur) {
	if(filter_var($valeur, FILTER_VALIDATE_EMAIL))return true;
    else return false;
}
function controlerDate($valeur) {
    if (preg_match("/^(\d{1,2})[\/|\-|\.](\d{1,2})[\/|\-|\.](\d\d)(\d\d)?$/", $valeur, $regs)) {
        $jour = ($regs[1] < 10) ? "0".$regs[1] : $regs[1]; 
        $mois = ($regs[2] < 10) ? "0".$regs[2] : $regs[2]; 
        if ($regs[4]) $an = $regs[3] . $regs[4];
              if (checkdate($mois, $jour, $an)) return true;
        else return false;
    }
    else return false;
}
function controlerHeure($valeur) {
    return (preg_match("/^(?:2[0-4]|[01][1-9]|10):([0-5][0-9])$/", $valeur));
}
function controlerAlphanum($valeur) {
    if (preg_match("/^[\w|\d|\s|'|\"|\\|,|\.|\-|&|#|;]+$/", $valeur)) return true;
    else return false;
}   
function controlerNum($valeur, $strict=false) {
    if ($strict) {
        if (ereg("^[0-9]+$", $valeur)) return true;
        else return false;
    }
    else if (preg_match("/^[\d|\s|\-|\+|E|e|,|\.]+$/", $valeur)) return true;
    else return false;
}   
function controlerTel($valeur) {
	if (preg_match('#(0|\+33)[1-9]( *[0-9]{2}){4}#', $valeur)) 
	return true;
	else return false;
}   
function controlerCP($valeur) {
	if ( preg_match ("~^[0-9]{5}$~",$valeur))
		return true;
	else
		return false;
}  
function Calendrier($annee, $mois)
{
// classes calandrier,titre,mois,en_valeur,lien,normal
    $deb_mois = mktime (0,0,0, $mois, 1, $annee);   
    static $semaine = array('Dim','Lun','Mar','Mer','Jeu','Ven','Sam');
    $maxdays   = date('t', $deb_mois); #number of days in the month
    $date_info = getdate($deb_mois);   #get info about the first day of the month
    $mois     = $date_info['mon'];
    $annee      = $date_info['year'];

    $calendar  = "<table class=\"calendrier\" >\n";    
    $calendar .= "<tr bgcolor=\"#999999\" class=\"titre\"><th colspan=\"7\" class=\"mois\">$date_info[month], $annee</th></tr>\n";    


    $calendar .= '<tr>';
    for ($i=0;$i<7;$i++) $calendar .= "<th>".$semaine[$i]."</th>";

    $calendar .= '</tr>';
    $calendar .= '<tr>';

    $weekday = $date_info['wday']; #weekday (zero based) of the first day of the month
    $day = 1; #starting day of the month
    
    #take care of the first "empty" days of the month
    if($weekday > 0){$calendar .= "<td colspan=\"$weekday\">&nbsp;</td>";}

    #print the days of the month
    while ($day <= $maxdays)
    {
        if($weekday == 7)#start a ne week
        { 
            $calendar .= "</tr>\n<tr>";
            $weekday = 0;
        }
      

		$calendar .= "<td class=\"normal\"> $day</td>\n";
   
        $day++;
        $weekday++;
    }
    if($weekday != 7)
    {
        $calendar .= '<td colspan="' . (7 - $weekday) . '">&nbsp;</td>';
    }
    return $calendar . "</tr>\n</table>\n";
}





$nom = null;$prenom = null;$dateN = null;$lieuN =  null;$telephone = null;$adresse = null;			
$erreur=array("nom"=>null,"prenom"=>null,"dateN"=>null,"lieuN"=>null,"telephone"=>null,"adresse"=>null);
?>
