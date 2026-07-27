"use client"

import { SubmitEvent } from 'react';
import { loginUser } from './login';
import '../form.css';

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
          <div className="mb-3">
            <label htmlFor="usernameInput" className="form-label">Username</label>
            <input type="text" className="form-control" id="usernameInput" name="username" required/>
          </div>
          <div className="mb-3">
            <label htmlFor="passInput" className="form-label">Password</label>
            <input type="password" className="form-control" id="passInput" name="password" required/>
          </div>
          <button type="submit" className="btn btn-primary">Submit</button>

        </form>
    </div>
  )
}