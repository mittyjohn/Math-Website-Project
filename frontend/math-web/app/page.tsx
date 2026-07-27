"use client";

import React, { useEffect, useState } from 'react';
import './globals.css';
import QuoteDisplay from './QuoteDisplay';
import { getLogname, logoutUser } from './login/login';

export default function Home() {
  const [logname, setLogname] = useState<any>(null);
  useEffect(() => {
    getLogname().then((result) => {
        setLogname(result?.value);
      })
      .catch(() => {
        setLogname(null);
      });
  }, []);
  return (
      <div>
          <main className="bg-white text-black">
              <div className="flex justify-center items-center pt-4">
                  <aside className="flex items-center gap-6 text-center sm:items-start sm:text-right">
                      <img src="/logo.png" alt="MO Delta Phi Logo" className="w-20 h-20 mr-4" />
                      <ul className="pt-8 text-xl"> <a className="hover:text-blue-700" href="#home">MO Delta Phi</a>  </ul>
                      <ul className="pt-8 text-xl"> <a className="hover:text-blue-700" href="#learn">Learn</a>  </ul>
                      <ul className="pt-8 text-xl"> <a className="hover:text-blue-700" href="#about">About Us</a>  </ul>
                      <ul className="pt-8 text-xl"><QuoteDisplay /></ul>
                      {!logname ? (
                        <ul className="pt-8 text-xl"> <a className="hover:text-blue-700" href="/login">Login</a>  </ul>
                        ) : (
                            <ul className="pt-8 text-xl"> <a className="hover:text-blue-700" href="/profile">{logname}</a>  </ul>
                        )}
                        { logname ?
                        (<ul className="pt-8 text-xl"> <a className="hover:text-blue-700" href="/" onClick={() => logoutUser()}>Logout</a>  </ul>) : null}
                      <img src="/logo.png" alt="MO Delta Phi Logo" className="w-20 h-20 mr-4" />
                  </aside>
              </div>
              <aside className="flex justify-center items-center gap-6 text-center sm:items-start sm:text-center pt-12">
                  <div>
                      <h2 className="text-xl font-bold hover:text-blue-700"><a href="#elem">Elementary School</a></h2>
                      <ul>Arithmetic</ul>
                      <ul>Geometry</ul>
                      <ul>Factors & Multiples</ul>
                      <ul>Logic</ul>
                      <ul>Prealgebra</ul>
                  </div>
                  <div>
                      <h2 className="text-xl font-bold hover:text-blue-700"><a href="#mid">Middle School</a></h2>
                      <ul>Algebra</ul>
                      <a className="text-blue-700 hover:text-red-700" href="#number-theory">Number Theory</a>
                      <ul>Geometry</ul>
                      <ul>Combinatorics</ul>
                      <ul>Probability</ul>
                  </div>
                  <div>
                      <h2 className="text-xl font-bold hover:text-blue-700"><a href="#high">High School</a></h2>
                      <ul>Algebra</ul>
                      <ul>Number Theory</ul>
                      <ul>Geometry</ul>
                      <ul>Combinatorics</ul>
                  </div>
              </aside>
              <div className="flex justify-center">
                  <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-4 px-3 rounded mt-16 ml-16">Generate Quiz</button>
                  <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-4 px-3 rounded mt-16 ml-16">Explain this</button>
              </div>
              <div className="flex flex-col items-center pt-24 px-4 w-full">
                  <h3 className="text-2xl font-bold mb-6">Interactive Demo</h3>
                  <iframe
                    src="/mod_interactive_demo_1.html"
                    title="Modular Arithmetic Playground"
                    className="w-full max-w-6xl border-0 rounded-xl"
                    style={{ height: "720px", minHeight: "600px" }}
                  />
              </div>
      </main>
      </div>
  );
}
