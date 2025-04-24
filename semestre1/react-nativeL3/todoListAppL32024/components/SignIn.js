import { View ,Text,Image,StyleSheet} from "react-native";
import Input from "./Input";
import { useContext, useState } from "react";
import ButtonPersonnaliser from "./ButtonPersonnaliser";
import { Link } from "@react-navigation/native";
import {signIn_Api } from "../api/Api";
import tokenContext from "../context/Context";
export default function SignIn(nav){
    const [username,setUsername]=useState('');
    const [password,setPassWord]=useState('');
    const [errorMessage,setErroreMessage]=useState("");
    const [token,setToken]=useContext(tokenContext);
    const signInClicked=()=>{
       signIn_Api(username,password).then(resp=>{
        if(resp.errors!=null)
            setErroreMessage(resp.errors[0]["message"]);
        else if(resp.data!=null){
            setToken({
                'token':resp.data.signIn,
                'username':username
            });
        }
       })
    };

    return(
        <View style={styles.vue}>
            <Image  style={styles.logo} source={require('./../assets/logi.png')}/>
            <Input placeholder="Enter your username " secureTextEntry={false} value={username} setValue={setUsername} name="person-outline"/>
            <Input placeholder="Enter your password" secureTextEntry={true} value={password} setValue={setPassWord} name="lock-closed-outline"/>
            {errorMessage===""?null:<Text style={{color:'red',fontSize:15}}>{errorMessage}</Text>}
            <ButtonPersonnaliser textStyles={styles.text_button} nomButton={"Log in"}  onpress={signInClicked} taille={100}/>
            <View style={styles.text_signup}>
                <Text>To create a new account </Text> 
                <Link style={{color:'blue'}} to={{screen:"SignUp"}}>click here</Link>
            </View>
        </View>
    );
}
const styles=StyleSheet.create({
    vue:{
        flex:1,
        alignItems:'center',
        justifyContent: 'center',
        padding:20,
        gap:20,
    },
    logo:{
        width:150,
        height:150,
    },
    text_signup:{
        backgroundColor:'white',
        flexDirection:'row',
        padding:10,
        width:'100%',
        borderWidth:2,
        borderRadius:10,

    },
    text_button:{
        fontSize: 18,
    }
});