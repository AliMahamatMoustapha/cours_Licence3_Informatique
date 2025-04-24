import SignUp from "../components/SignUp";
import { ImageBackground } from "react-native";

export default function SignUpScreen(){

    return(
        <ImageBackground source={require('./../assets/back.jpg')} style={{flex:1}}>
            <SignUp/>
        </ImageBackground>
        
    );
}