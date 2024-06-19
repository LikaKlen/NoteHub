import React from 'react'
import './Reg.css'

const Reg=()=>{
   
    return(
        <div className='wrapper'>
            <from action="">
                <h1>LogIn</h1>
                <div className='input-box'>
                    <input type='text' placeholder='FirstName' required></input>
                </div>
                <div className='input-box'>
                    <input type='text' placeholder='LastName' required></input>
                </div>
                <div className='input-box'>
                    <input type='text' placeholder='Patronymic' required></input>
                </div>
                <div className='input-box'>
                    <input type='text' placeholder='PhoneNumber' required></input>
                </div>
                <div className='input-box'>
                    <input type='text' placeholder='Password' required></input>
                </div>
                <div className='input-box'>
                    <input type='password' placeholder='Email' required></input>
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
export default Reg;