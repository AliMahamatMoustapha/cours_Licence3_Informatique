import { Text,StyleSheet, TouchableOpacity} from "react-native";

export default function ButtonPersonnaliser({nomButton,onpress,taille,couleur, VueStyles = {}, textStyles = {}}){
    return(
        <TouchableOpacity style={[styles.vue_style,{width:`${taille}%`,backgroundColor:couleur}, VueStyles]} onPress={onpress}>
            <Text style={[styles.text_style,textStyles]}>{nomButton}</Text>
        </TouchableOpacity>
    );
}

const styles=StyleSheet.create({
    vue_style:{
        alignItems:'center',
        borderRadius:5,
        padding: 10,
        backgroundColor: 'skyblue'
    },
    text_style:{
        fontWeight:'bold',
        fontSize: 15,
        color:'black',
    }
});
