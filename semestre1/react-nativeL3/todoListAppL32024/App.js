import Navigation from './Navigation/Navigation';
import { useState } from 'react';
import tokenContext from './context/Context';
export default function App() {
  const [token,setToken]=useState(null)
  return(
      <tokenContext.Provider value={[token,setToken]} >
          <Navigation/>
      </tokenContext.Provider>        
  
  );
}

