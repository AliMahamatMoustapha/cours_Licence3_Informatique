import { View,StyleSheet,Text } from "react-native";

export default function BarProgression({nbreTacheRealise,nbreTotaletaches}){
    const progression=nbreTotaletaches===0?Math.round(100*nbreTacheRealise/1):Math.round(100*nbreTacheRealise/nbreTotaletaches);
    return(
        <View style={styles.progress}>
                <Text style={styles.text}>
                    <Text style={{fontSize:15,fontWeight:'bold'}}>Tâches réalisées : {progression}%</Text>
                </Text>
                <View style={styles.progressBar}>
                    <View style={[styles.progressFill, { width: `${progression}%` }]} />
                </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
    alignItems: 'center',
    justifyContent: 'center',
    padding: 5,
    },
    text: {
      marginBottom: 10,
      fontSize: 15,
    },
    progressBar: {
      height: 20,
      backgroundColor: 'silver',
      borderRadius: 10,
      overflow: 'hidden',
    },
    progressFill: {
       height: '100%',
      backgroundColor: 'darkcyan',
    },
    progress:{
        backgroundColor:"silver",
        padding:10,
        borderRadius:10,
    },
  });