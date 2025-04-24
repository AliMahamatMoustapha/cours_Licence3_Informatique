import { View,TextInput,StyleSheet } from "react-native";
import Ionicons from "react-native-vector-icons/Ionicons";

export default function Input({placeholder,secureTextEntry,value,setValue,name}){
    return(
        <View style={styles.vue_style}>
            <Ionicons name={name}  size={30}/>
            <TextInput style={styles.input_style} value={value} secureTextEntry={secureTextEntry} placeholder={placeholder} onChangeText={setValue}/>
        </View>
    );
}
const styles=StyleSheet.create({
    vue_style:{
        backgroundColor:'white',
        width:'100%',
        flexDirection:'row',
        alignItems: 'center',
        borderRadius:5,
        padding: 5,
        columnGap: 5,
    },
    input_style:{
        width:'100%',
        height:30,
        fontSize:15,
        outlineStyle: 'none',
        justifyContent:'center',
    },

});