import { useContext, useState } from "react";
import { View,Text,StyleSheet, Pressable } from "react-native";
import tokenContext from "../context/Context";
import Input from "./Input";
import ButtonPersonnaliser from "./ButtonPersonnaliser";
import { DeleteAcount_API, updatUsername_API } from "../api/Api";
import { Modal } from "react-native-web";

export default function Parametre(){
    const [token,setToken]=useContext(tokenContext);
    const [isUpdate,setUpdate]=useState(false);
    const [isdel,setisDel]=useState(false);
    const [newUsername,setNewUsernam]=useState(token.username);
    const deconnexion=()=>{
        setToken(null);
    }
    const updateUser=()=>{
        setUpdate(true);
    }
    const isOpenModal=()=>{
        setisDel(true);
    }
    const deleUser=()=>{
         DeleteAcount_API(token.token,token.username);
         setToken(null);
    }
    const cancelclicked=(nav)=>{
        setisDel(false);
    }
    const saveClicked=()=>{
        if(newUsername!=""){
            updatUsername_API(token.username,newUsername,token.token);
            // setToken({'username':newUsername,'token':token.token});
            setUpdate(false);
        }
       
    }
    return(
       <>
            <View style={styles.view_style}><Pressable onPress={updateUser}><Text style={styles.styleText}>Update my password</Text></Pressable></View>
            {isUpdate?<View  style={styles.view_style}><Input value={newUsername} setValue={setNewUsernam} />
            <ButtonPersonnaliser nomButton="Save" onpress={saveClicked} taille={30}/></View>:
            <View  style={styles.view_style}><Pressable onPress={updateUser}><Text style={styles.styleText}>Update my username</Text></Pressable></View>}
            <View  style={styles.view_style}><Pressable onPress={isOpenModal}><Text style={styles.styleText}>Delete my account</Text></Pressable></View>
            <Modal visible={isdel} animationType="slide" presentationStyle="formSheet" transparent>
                <View style={styles.modalContainer}>
                    <View style={styles.modalStyle}>
                        <Text style={styles.textModal}>Are you sure you want to delete your account ?</Text>
                        <View style={{flexDirection:'row', justifyContent:'space-around', width: '100%'}}>
                            <ButtonPersonnaliser nomButton="Confirm" onpress={deleUser} />
                            <ButtonPersonnaliser nomButton="Cancel" onpress={cancelclicked} />
                        </View>
                    </View>
                </View>
            </Modal>
            <View  style={styles.view_style}><Pressable onPress={deconnexion}><Text style={styles.styleText}>Signout to my account</Text></Pressable></View>
      </>
    );
}

const styles=StyleSheet.create({
    styleParam:{
        flex:1,
        alignItems:'center',
        paddingTop:20,
        gap:15,
        margin:10,
        backgroundColor:'white',
        
    },
    styleText:{
        color:'blue',
        fontWeight:'bold',
        textAlign:'center',
        borderWidth:2,
        borderColor:'black',
        borderRadius:10,
        padding:10,
        backgroundColor:'white'
    },
    view_style:{
        width:'80%',

    },
    modalContainer: {
        height: '100%',
        paddingHorizontal: 20,
        justifyContent: 'center',
        backgroundColor: 'rgba(240,248,255,0.85)',
    },
    modalStyle:{
        padding:10,
        height: 150,
        justifyContent: 'space-between',
        backgroundColor: 'white',
        borderRadius: 10,
    },
    textModal:{
        color:'red',
        textAlign:'center',
        fontWeight: 'bold'
    }
})