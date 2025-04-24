import React,{useEffect, useState} from 'react' ;
import {Image,View,Text,StyleSheet,Switch, TouchableOpacity} from 'react-native' ;
import { TextInput } from 'react-native-web';
import ButtonPersonnaliser from './ButtonPersonnaliser';
import Icon from 'react-native-vector-icons/Ionicons';

export default function TodoItem({item,miseAjourCompteur,supprimer,modifier}){
    const [done,setDone] = useState(item.done) ;
    const [isModify,setIsmodify]=useState(false);
    const [newText,setNewText]=useState(item.content);
    const change=(etatSwitch)=>{
        setDone(etatSwitch) ;
        miseAjourCompteur(etatSwitch,item.id);
    }
    const modifieClicked=()=>{
        setIsmodify(true);
    }
    const saveClicked=()=>{
        modifier(item.id,newText);
        setIsmodify(false);

    }
    useEffect(
        ()=>setDone(item.done),[item.done]
    );
    return(
       
            isModify?<><TextInput value={newText} style={{width:'80%',outline:'none'}}  onChangeText={setNewText} onSubmitEditing={saveClicked}/> 
                <ButtonPersonnaliser nomButton="Save" onpress={saveClicked} taille={20}/>
            </>:
            <> <Text style={{fontWeight:'bold',fontSize:15}}>{item.content}</Text>
            <Switch onValueChange={change}  value={done} />
            <TouchableOpacity onPress={modifieClicked}>
                <Image style={{width:30,height:30}} source={require('./../assets/edit.png')}/>
            </TouchableOpacity>
            <TouchableOpacity onPress={()=>supprimer(item.id)}>
                <Icon name="trash" color="red" size={25} />
            </TouchableOpacity></>
            
    ) ;
}
