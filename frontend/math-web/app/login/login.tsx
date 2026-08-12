"use server"

import '../globals.css';
import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';

/* Refs: 
    - Forms: https://nextjs.org/docs/pages/guides/forms
*/

export async function loginUser(formData: FormData): Promise<boolean> {
    let rdr_path: string | null = null;
    try {
        const response = await fetch('http://localhost:8080/users/login', {
            method: 'POST',
            body: formData,
        })

        if (!response.ok) {
            throw new Error('Invalid username or password.');
        }

        const data = await response.json()
        const cookieStore = await cookies()
        cookieStore.delete('logname');
        cookieStore.set('logname', data.username, {
            httpOnly: true,
            secure: process.env.NODE_ENV === 'development',
            maxAge: 60 * 60 * 24, // 1 day
            path: '/',
        })
        rdr_path = "/";

    } catch (error) {
        console.error(error)
        return false;
    }
    if (rdr_path) {
        redirect(rdr_path);
    }
    return true;
}

export async function logoutUser() {
    try {
        const cookieStore = await cookies()
        cookieStore.delete("logname");
    } catch (error) {
        console.error(error)
    }
    redirect("/");
}

export async function getLogname() {
    const cookieStore = await cookies()
    const logname = cookieStore.get('logname');
    return logname;

}