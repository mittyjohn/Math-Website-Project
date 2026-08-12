"use client"

import { SubmitEvent, useState } from 'react';
import { loginUser } from './login';
import '../form.css';

/* Refs: 
    - Forms: https://nextjs.org/docs/pages/guides/forms
*/

export default function page() {

  const [error, setError] = useState<string>('');
  
  async function onSubmit(event: SubmitEvent<HTMLFormElement>) {
    event.preventDefault()
    const formData = new FormData(event.currentTarget)
    const success = await loginUser(formData);
    if (!success) {
      setError('Invalid username or password.')
    }
  }

  return (
    <div className="text-center ml-auto mr-auto">
        <h1>Login</h1>
        {error.length > 0 ?  <div className="alert alert-danger" role="alert">{error}</div> : null}
        
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
        <a href="/signup" className="btn btn-link">Sign Up</a>
    </div>
  )
}
