import { ImageBackground } from "react-native";
import SignIn from "../components/SignIn";

export default function SigninScreen(){
    return(
        <ImageBackground source={require('./../assets/back.jpg')} style={{flex:1}}>
                  <SignIn/>
        </ImageBackground>
    );
}