import { useState } from 'react';
import { ThemeContext } from './ThemeContext';
import { UserContext } from './UserContext';
import Page from './Page';
const Root=()=>{
    const [isDark,setIsDark]=useState(false);
    return(
        <UserContext.Provider value={'비트캠프'}>
            <ThemeContext.Provider value={{isDark,setIsDark}}>
               <Page/>
            </ThemeContext.Provider>
        </UserContext.Provider>
    )
}
export default Root;