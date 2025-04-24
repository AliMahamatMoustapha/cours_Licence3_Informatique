import { View } from "react-native";
import ButtonPersonnaliser from "./ButtonPersonnaliser";

export default function(){
    return(
        <View>
            <ButtonPersonnaliser nomButton="Deconnexion" onpress={()=>console.log("vous etes deconnecter")} taille={15} couleur="blue"/>
        </View>
    );
}