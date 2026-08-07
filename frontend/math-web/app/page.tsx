import React from 'react';
import Link from 'next/link';
import './globals.css';
import QuoteDisplay from './QuoteDisplay';

export default function Home() {
  return (
    <div>
      <main>
              <div className="flex justify-center items-center pt-4">
                  <aside className="flex items-center gap-6 text-center sm:items-start sm:text-right">
                      <ul> <a className="hover:text-blue-700"href="#home">Home</a>  </ul>
                      <ul> <a className="hover:text-blue-700" href="#learn">Learn</a>  </ul>
                      <ul> <a className="hover:text-blue-700" href="#about">About Us</a>  </ul>
                  </aside>
              </div>
              <h1 className=" flex justify-center items-center pt-4 text-8xl">
                  MODeltaPsi
              </h1>
              <div className="flex justify-center items-center gap-6 text-center sm:items-start sm:text-left pt-4">
                  <QuoteDisplay />
              </div>
              <aside className="flex justify-center items-center gap-6 text-center sm:items-start sm:text-center pt-12">
                  <div>
                      <h2 className="text-2xl font-bold hover:text-blue-700"><a href="#elem">Elementary School</a></h2>
                      <ul>Arithmetic</ul>
                      <ul>Geometry</ul>
                      <ul>Factors & Multiples</ul>
                      <ul>Logic</ul>
                      <ul>Prealgebra</ul>
                  </div>
                  <div>
                      <h2 className="text-2xl font-bold hover:text-blue-700"><a href="#mid">Middle School</a></h2>
                      <ul>Algebra</ul>
                      <Link className="text-blue-700 hover:text-white" href="/number-theory">Number Theory</Link>
                      <ul>Geometry</ul>
                      <ul>Combinatorics</ul>
                      <ul>Probability</ul>
                  </div>
                  <div>
                      <h2 className="text-2xl font-bold hover:text-blue-700"><a href="#high">High School</a></h2>
                      <ul>Algebra</ul>
                      <ul>Number Theory</ul>
                      <ul>Geometry</ul>
                      <ul>Combinatorics</ul>
                  </div>
              </aside>
              <div className="flex flex-col items-center pt-24 px-4 w-full">
                  <h3 className="text-2xl font-bold mb-6">Demo</h3>
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
