import React from 'react';
import './globals.css';
export default function Home() {
  return (
    <div className="flex flex-col flex-1 items-center justify-center bg-zinc-50 font-sans dark:bg-black">
      <main className="flex flex-1 w-full max-w-3xl flex-col items-center justify-between py-32 px-16 bg-white dark:bg-black sm:items-start">
              <div className="flex flex-col items-center gap-6 text-left sm:items-start sm:text-left">
                  <aside className="flex items-right gap-6 text-right sm:items-start sm:text-right">
                      <ul> <a href="#home">Home</a>  </ul>
                      <ul> <a href="#learn">Learn</a>  </ul>
                      <ul> <a href="#about">About Us</a>  </ul>
                  </aside>
          <h1 className="max-w-xs text-3xl font-semibold leading-10 tracking-tight text-black dark:text-zinc-50">
            Math Website
          </h1>
          <p>Math stuff ....</p>
              </div>
              
      </main>
      </div>
  );
}
