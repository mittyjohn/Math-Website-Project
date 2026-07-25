"use client"

import '../globals.css';
import { SubmitEvent } from 'react'
import { loginUser } from './login';

/* Refs: 
    - Forms: https://nextjs.org/docs/pages/guides/forms
*/

export default function page() {
  
  async function onSubmit(event: SubmitEvent<HTMLFormElement>) {
    event.preventDefault()
    const formData = new FormData(event.currentTarget)
    await loginUser(formData);
  }
 
  return (
    <div className="container text-center">
        <h1>Login</h1>

        <form onSubmit={onSubmit}>
        Username <input type="text" name="username" required/> <br/>
        Password <input type="password" name="password" required/> <br/>
        <input type="submit" name="login" value="Submit" />
        </form>
    </div>
  )
}