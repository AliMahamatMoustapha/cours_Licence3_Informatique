import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { NavigationContainer } from "@react-navigation/native";
import TodoLIstScreen from "../screen/TodoLIstScreen";
import HomeScreen from "../screen/HomeScreen";
import SigninScreen from "../screen/SignInScreen";
import Icon from 'react-native-vector-icons/Ionicons';
import SignUpScreen from "../screen/SignUpScreen";
import { useContext } from "react";
import tokenContext from "../context/Context";
import ParametreScreen from "../screen/ParametreScreen";
import AppropoScreen from "../screen/AproposScreen";
const Tab= createBottomTabNavigator();
export default function Navigation(){
    const [token,setToken]=useContext(tokenContext);
    
    
    return(
        <NavigationContainer>
        {token===null?(
                    <Tab.Navigator screenOptions={{headerShown:false}}>
                        <Tab.Screen name="Signin" component={SigninScreen} options={{tabBarButton:()=>null}}/> 
                        <Tab.Screen name="SignUp" component={SignUpScreen} options={{tabBarButton:()=>null}}/>
                    </Tab.Navigator>):(
                    <Tab.Navigator initialRouteName="Home">
                        <Tab.Screen name="Home" component={HomeScreen} options={{tabBarIcon:({color,size,focused})=><Icon name={focused?"home":"home-outline"} size={30} color={focused?"blue":null}/>}}></Tab.Screen> 
                        <Tab.Screen
                            name="Tasks"
                            component={TodoLIstScreen}
                            options={{ tabBarButton: () => null }} 
                        />
                     <Tab.Screen name="Setting" component={ParametreScreen} options={{tabBarIcon:({focused})=><Icon name={focused?"settings":"settings-outline"} size={30} color={focused?"blue":null}/>}}></Tab.Screen>
                     <Tab.Screen name="About" component={AppropoScreen} options={{tabBarIcon:({focused})=><Icon name={focused?"information-circle":"information-circle-outline"} size={30} color={focused?"blue":null}/>}}></Tab.Screen>
                    </Tab.Navigator>
                    
                     )}
       
        </NavigationContainer>
        
    );
}
