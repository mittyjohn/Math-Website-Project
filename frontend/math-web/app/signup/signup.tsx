"use server"

import '../globals.css';
import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';

export default async function signup(formData: FormData) {
    let rdr_path: string | null = null;
    try {
        const response = await fetch('http://localhost:8080/users/add', {
            method: 'POST',
            body: formData,
        })

        if (!response.ok) {
            console.error(response);
            throw new Error('Invalid data.');
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
    }
    if (rdr_path) {
        redirect(rdr_path);
    }
}
