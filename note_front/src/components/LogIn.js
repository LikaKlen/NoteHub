import React from 'react'
import './LogIn.css'

const LogIn=()=>{
   
    return(
        <div className='wrapper'>
            <from action="">
                <h1>LogIn</h1>
                <div className='input-box'>
                    <input type='text' placeholder='FirstName' required></input>
                </div>
                <div className='input-box'>
                    <input type='password' placeholder='Password' required></input>
                </div>
                <div className='remember-forgot'>
                    <label><input type='checkbox'/> Remember me</label>
                    <a href='#'>Forgot password?</a>
                </div>
                <button type='submit'>LogIn</button>
                <div className='registr>'><p>Don't have account? <a href='#'>Redister</a></p></div>
            </from>
        </div>

    );

};
export default LogIn;