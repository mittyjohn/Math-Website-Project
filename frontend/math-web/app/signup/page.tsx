"use client"

import { SubmitEvent } from 'react';
import signup from './signup';
import '../form.css';

export default function page() {
  
  async function onSubmit(event: SubmitEvent<HTMLFormElement>) {
    event.preventDefault()
    const formData = new FormData(event.currentTarget)
    await signup(formData);
  }
 
  return (
    <div className="text-center ml-auto mr-auto">
        <h1>Sign Up</h1>

        <form onSubmit={onSubmit}>
          <div className="mb-3">
            <label htmlFor="usernameInput" className="form-label">Username</label>
            <input type="text" className="form-control" id="usernameInput" name="username" required/>
          </div>
          <div className="mb-3">
            <label htmlFor="passInput" className="form-label">Password</label>
            <input type="password" className="form-control" id="passInput" name="password" required/>
          </div>
          <div className="mb-3">
            <label htmlFor="emailInput" className="form-label">Email</label>
            <input type="email" className="form-control" id="passInput" name="email" required/>
          </div>
          <button type="submit" className="btn btn-primary">Submit</button>

        </form>
    </div>
  )
}