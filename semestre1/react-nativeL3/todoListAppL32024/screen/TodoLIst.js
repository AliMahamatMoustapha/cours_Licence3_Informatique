import {Text, View,FlatList, TextInput,ScrollView,StyleSheet } from 'react-native';
import TodoItem from './../components/TodoItem';
import ButtonPersonnaliser from '../components/ButtonPersonnaliser';
import BarProgression from '../components/ProgressBar';
import { createTodos_Api, deleteTodos, getTodos_Api, updateDone, updateTodos } from "../api/Api";
import { useContext, useEffect, useState } from "react";
import tokenContext from "../context/Context";
export default function TodoList({idiTodoBelongs,titleToBelong}){
    console.log("ID: ",idiTodoBelongs);
    // console.log("title: ",titleToBelong);
    const [token,setToken]=useContext(tokenContext);
    const [todos,setTodos] = useState([]) ;
    const [compteur,setCompteur] = useState(0) ;
    const [nbrTasks,setNbreTasks] = useState(0) ;
    const [todo,setTodo] = useState("") ;
    const [afficheTodos,setAfficheTodos] = useState([]) ;
    const getCurrentTodos=()=>{
        getTodos_Api(token.token,idiTodoBelongs,token.username).then(res=>{
        setTodos(res);
        setAfficheTodos(res);
        setCompteur(res.filter(item=>item.done).length);
        setNbreTasks(res.length);
    });
    }
    useEffect(()=>{
        getCurrentTodos();
        },[]);
    useEffect(()=>{
        getCurrentTodos();
    },[idiTodoBelongs])
    const miseAjourCompteur =(etatSwitch,idTodos)=>{
        updateDone(token.token,token.username,idTodos,idiTodoBelongs,etatSwitch).then(item=>{
             const res = [...todos].map((i)=>({id:i.id,content:i.content,done:i.id===item.id?item.done:i.done}));
             setTodos(res);
             setAfficheTodos(res);
             setCompteur(etatSwitch?compteur+1:compteur-1);
             setNbreTasks(res.length);
        });
    }
    const supprimer=(idiTodo) =>{
        deleteTodos(token.token,token.username,idiTodo,idiTodoBelongs).then(node=>{
            if(node.nodesDeleted===1){
                const res=[...todos].filter(item=>item.id!=idiTodo);
                setTodos(res);
                setAfficheTodos(res);
                setCompteur(res.filter(item=>item.done).length);
                setNbreTasks(res.length);
            }
        });
    }
    const ajouter=()=>{
        if (todo!="") {
            createTodos_Api(token.token,token.username,todo,idiTodoBelongs).then(item=>{
                const res=[...todos,item];
                setTodos(res);
                setAfficheTodos(res);
                setCompteur(res.filter(item=>item.done).length);
                setNbreTasks(res.length);
                setTodo("");

            });
        }
    }
    const modifier=(idTodo,newtext)=>{
        if(newtext!=""){
            updateTodos(token.token,token.username,idTodo,idiTodoBelongs,newtext).then(item=>{
                const res=[...todos].map(i=>({content:i.id===item.id?item.content:i.content,done:i.done,id:i.id}));
                setTodos(res);
                setAfficheTodos(res);
            });
        }
    }
    const tousCochers=()=>{
        todos.forEach(item=>updateDone(token.token,token.username,item.id,idiTodoBelongs,true));
        const res =[...todos].map((item)=>({...item,done:true}));
        setCompteur(res.length);
        setTodos(res);
        setAfficheTodos(res);
    }
    const tousDecochers=() =>{
        todos.forEach(item=>updateDone(token.token,token.username,item.id,idiTodoBelongs,false));
        const res =[...todos].map((item)=>({...item,done:false}));
        setCompteur(0);
        setTodos(res);
        setAfficheTodos(res);
    }
    const filterDone=()=>{
        const res =[...todos].filter((i)=>i.done);
        setAfficheTodos(res);
        
    }
    const filterTodo=()=>{
        const res =[...todos].filter((i)=>!i.done);
        setAfficheTodos(res);
    }
    return(
        <View style={styles.styleView}>
            {/* <Text style={styles.textshadow}>Tasks bellongs to todolist : <Text style={{color:'red'}}>{titleToBelong}</Text> </Text> */}
            <View style={styles.style_viewInput}>
                 <TextInput style={styles.style_input} placeholder='Create New task' value={todo} onChangeText={setTodo} onSubmitEditing={ajouter}/>
                 <ButtonPersonnaliser nomButton="Add" onpress={ajouter} />
            </View>
            {/* <View> */}
                <BarProgression nbreTotaletaches={nbrTasks} nbreTacheRealise={compteur}   />  
            {/* </View> */}
            <View style={styles.style_viewButton}>
                <ButtonPersonnaliser textStyles={styles.fontButton} nomButton="CheckAll" onpress={tousCochers}  />
                <ButtonPersonnaliser textStyles={styles.fontButton}  nomButton="UncheckAll" onpress={tousDecochers} />
                <ButtonPersonnaliser textStyles={styles.fontButton}  nomButton="Done" onpress={filterDone} />
                <ButtonPersonnaliser textStyles={styles.fontButton}  nomButton="Todo" onpress={filterTodo} />
            </View>
           <ScrollView contentContainerStyle={{background:'white',flex:1,padding:5,borderRadius:5}}>
            <Text style={{textAlign:'center',fontSize:18,fontWeight:'bold',padding:5}}>{titleToBelong} </Text>
            <FlatList data={afficheTodos} renderItem={({item})=><View style={styles.styleTodo}><TodoItem item={item} miseAjourCompteur={miseAjourCompteur} supprimer={supprimer} modifier={modifier}/></View>} />
            </ScrollView>
        </View>
    ) ;
}
const styles=StyleSheet.create(
    {
       styleView:{
             flex:1,
             padding:20,
             gap:30,  
        },
        style_viewButton:{
            flexDirection:'row',
            gap:5,
            justifyContent: 'space-between'
        },
        fontButton:{
            fontSize: 14,
        },
        style_viewInput:{
            flexDirection:'row',
            justifyContent: 'space-between',
            gap:5

        },
        style_input:{
             padding:8,
             width:'80%',
             fontSize:15,
             border:'white',
             borderWidth:2,
             borderRadius:5,
             backgroundColor:'white',
             color:'black',
             outlineStyle: 'none',
        },
        styleTodo :{
            flexDirection:'row',
            justifyContent: 'space-between',
            alignItems: 'center',
            margin:5,
            shadowColor: "black",
            shadowRadius: 5,
            padding:15,
            backgroundColor:'silver',
            borderRadius:5,
             

            
        },
        textshadow:{
            fontWeight:'bold',
            textAlign:'center',
            fontSize:20,
            textShadowColor: 'black', 
            color:'white',
        }
    }
);
