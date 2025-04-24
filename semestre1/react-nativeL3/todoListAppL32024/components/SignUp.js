import { View,Text ,StyleSheet} from "react-native";
import Input from "./Input";
import { useContext, useState } from "react";
import ButtonPersonnaliser from "./ButtonPersonnaliser";
import { Link, useNavigation } from "@react-navigation/native";
import { SignUp_Api } from "../api/Api";
import tokenContext from "../context/Context";
export default function SignUp(navigatin){
    console.log(navigatin);
   const navigation=useNavigation();
    const [username,setUsername]=useState('');
    const [password,setPassword]=useState('');
    const [confirmpassword,setConfirmPassword]=useState('');
    const [errorMessage,setErroreMessage]=useState("");
    const [token,setToken]=useContext(tokenContext);
    const sinscrireClicked=()=>{
        if(password===confirmpassword){
            SignUp_Api(username,password).then(jresponse=>{
                if(jresponse.data!=null){
                    setToken({'token':jresponse.data.signUp,
                              'username':username
                    });
                    // console.log("compte enregistré avec succé",jresponse.data.signUp);
                }
                else
                    setErroreMessage(jresponse.errors[0]["message"]);

            });
        }
       
        else
            setErroreMessage("the password must be the same");
    }

    return(
        <View style={styles.view_style}>
            <Text style={styles.text_style}>Create an account</Text>
            <Input secureTextEntry={false} placeholder="Enter username" value={username} setValue={setUsername} name="person-outline"/>
            <Input placeholder="Password" secureTextEntry={true} value={password} setValue={setPassword} name="lock-closed-outline"/>
            <Input placeholder="confirme your password" secureTextEntry={true} value={confirmpassword} setValue={setConfirmPassword} name="lock-closed-outline"/>
            {(errorMessage!="")?<Text style={{color:'red',fontSize:13,fontWeight:'bold'}}>{errorMessage}</Text>:null}
            <ButtonPersonnaliser nomButton={"Sign Up"}  onpress={sinscrireClicked} textStyles={styles.text_button} taille={100}/>
            <View style={styles.text_signin}>
                <Text>To connect  </Text> 
                <Link style={{color:'blue'}} to={{screen:"Signin"}}>click here</Link>
            </View>

        </View>
    );
}

const styles=StyleSheet.create(
    {
        view_style:{
            flex:1,
            alignItems:'center',
            justifyContent: 'center',
            padding:20,
            gap:20,
        },
        text_style:{
            fontWeight:'bold',
            fontSize:30,
            color:'white',
        },
        text_signin:{
            backgroundColor:'white',
            flexDirection:'row',
            padding:10,
            width:'100%',
            borderWidth:2,
            borderRadius:5,

        },
        text_button:{
            fontSize: 18,
        }
    }
);