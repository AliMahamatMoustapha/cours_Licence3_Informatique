import { View,StyleSheet } from "react-native";
import Parametre from "../components/Parametre";
import { ImageBackground } from "react-native";

export default function(){
    return(
        <ImageBackground source={require('./../assets/back.jpg')} style={styles.styleParam}>
               <Parametre/>
        </ImageBackground>
        
    );
}
const styles=StyleSheet.create({
    styleParam:{
        flex:1,
        alignItems:'center',
        paddingTop:20,
        gap:15,
        
    }});