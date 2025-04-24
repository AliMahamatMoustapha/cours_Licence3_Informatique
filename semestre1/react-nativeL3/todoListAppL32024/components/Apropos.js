import { View,StyleSheet ,Text} from "react-native";

export default function Apropos(){
    return(
        <View style={styles.contenaire}>
            <Text style={{textAlign:'center',fontSize:15,fontWeight:'bold',color:'blue'}}>About this app</Text>
            <Text style={{gap:'5'}}>
            Welcome to TodoList! 
            This task management application was developed by <Text style={{fontWeight:'bold'}}>Moustapha Ali</Text> as part of our License 3 Computer Science,with the support and advice of my TP manager, <Text style={{fontWeight:'bold'}}>Mr. Rioult Francois</Text> in Caen university. 
            My goal is to offer you a simple and effective solution to organize your days and better manage your daily projects.
            Our application allows you to create, modify, delete and track your tasks in a fluid and intuitive way, on all mobile platforms (iOS and Android). 
            It represents an important step in our mobile development training, and we are happy to be able to share this project with you.
            </Text>
        </View>
    );
}

const styles=StyleSheet.create(
    {
        contenaire:{
            backgroundColor:'white',
            padding:10,
            flex:1,
            gap:10,
        },
        textStyle:{
            color:'black',
        }
    }
);