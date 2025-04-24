import { Image, FlatList, Text,View ,StyleSheet,TouchableOpacity,ScrollView,ImageBackground} from "react-native";
import Input from "../components/Input";
import { useContext, useEffect, useState } from "react";
import { Link } from "@react-navigation/native";
import {createTodoLists_API, deleteTodoList_API, getTodoLits, updateTodoList_API} from '../api/Api.js';
import ButtonPersonnaliser from "../components/ButtonPersonnaliser.js";
import tokenContext from "../context/Context.js";
import Icon from 'react-native-vector-icons/Ionicons';
export default function HomeScreen(nav){
    const [title,setTitle]=useState("");
    const [newtitle,setNewTitle]=useState("");
    const [isModify,setIsmodify]=useState(null);
    const [lists,setLists]=useState([]);
    const [token,setToken]=useContext(tokenContext);
    const getCurrentTodolists=()=>{
        getTodoLits(token.token,token.username).then(res=>{
           setLists(res);

        });
    }
   useEffect(()=>{
     getCurrentTodolists();
    
    },[]);
    console.log(lists)
  const createLists= async()=>{
        if(title!=""){
            const todolist=await createTodoLists_API(token.token,title,token.username);
                    console.log(todolist);
                    const res=[...lists,todolist];
                    setLists(res);
                    setTitle("");
                    
                }
       else
            console.log("erreure");
    }

    
    const deleteTodoList=async (idTodolist)=>{
         const val=await deleteTodoList_API(token.token,idTodolist,token.username);
         if(val===1){
             const res=[...lists].filter(item=>item.id!=idTodolist);
             setLists(res);
         }
    
    }
    const modifierClicked=(id,title)=>{
        setNewTitle(title);
        setIsmodify(id);
    }
    const saveClicked=async (idTodolist)=>{
        const todolist=await updateTodoList_API(token.token,token.username,newtitle,idTodolist);
        const res=[...lists].map(l=>({'title':l.id===todolist.id?todolist.title:l.title,'id':l.id}));
        setLists(res);
        setIsmodify(null);
    }
    return(
      
        <ImageBackground source={require('./../assets/back.jpg')} style={styles.view}>
            
                <View style={{flexDirection:'row',gap: 10, width:'80%'}}>
                    <Input placeholder="Create new TodoList " secureTextEntry={false} value={title} setValue={setTitle} />
                    <ButtonPersonnaliser nomButton="Add" taille={20} onpress={createLists}/>
                </View>
    
           
             <ScrollView contentContainerStyle={{background:'white',flex:1,paddingLeft:15,paddingTop:5,borderRadius:5}}>
                <Text style={{textAlign:'center',fontSize:18,fontWeight:'bold',padding:5}}>My TodoLists </Text>
            <FlatList data={lists} horizontal={false} keyExtractor={item=>item.id} renderItem={({item})=><View style={styles.styleTodolists}> 
                <Image  style={{width:40,height:40}} source={require('./../assets/checkLIstImage.png')}/>
                {isModify===item.id?<View style={{flexDirection:'row',alignContent:'center',justifyContent:'center',width:'70%'}}><Input value={newtitle} setValue={setNewTitle}/><ButtonPersonnaliser nomButton="Save" onpress={()=>saveClicked(item.id)} taille={20} /></View>:
                <>
                <Text style={styles.textStyle}><Link to={{ screen: 'Tasks' ,params:{'id':item.id,'title':item.title}}}>{item.title}</Link></Text>
                <TouchableOpacity onPress={()=>modifierClicked(item.id,item.title)}>
                    <Image style={{width:25,height:25}} source={require('./../assets/edit.png')}/>
                </TouchableOpacity>
                <TouchableOpacity onPress={()=>deleteTodoList(item.id)}>
                    <Icon name="trash" color="red" size={25} />
                </TouchableOpacity>
                </>}
            </View> }/>
            </ScrollView>     
        </ImageBackground>
        );
}
const styles=StyleSheet.create({
    view:{
        flex:1,
        backgroundColor:'white',
        padding:10,
        gap:10,

    },
    styleTodolists:{
        flexDirection:'row',
            justifyContent: 'space-between',
            alignItems:'center',
            width:'90%',
            margin:10,
            shadowColor: "gray",
            shadowRadius: 10,
            padding:15,
            backgroundColor:'silver',
            borderRadius:5,

    },
    textStyle:{
        // fontWeight:'bold',
        color:"blue",
        textDecorationLine: 'underline',
    }
});