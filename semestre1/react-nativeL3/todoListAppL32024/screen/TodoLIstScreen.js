import TodoList from "./TodoLIst";
import { ImageBackground } from "react-native";



export default function TodoLIstScreen({route}){
    // console.log("ccccccccccccccc",route.params.id);
    return(
        <ImageBackground source={require('./../assets/back.jpg')} style={{flex:1}}>
            <TodoList idiTodoBelongs={route.params.id} titleToBelong={route.params.title}/>
        </ImageBackground>
    );
}