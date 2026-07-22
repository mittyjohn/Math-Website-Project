"use client";

import { useEffect, useState } from "react";

const QUOTES = [
  "Never let doubt crowd your dreams. Aim high and work hard.",
  "Life is a series of tests, and each one is an opportunity to grow.",
  "In every challenge lies the chance to become greater.",
  "Success is born from hard work and unwavering passion.",
];

export default function QuoteDisplay() {
  const [quote, setQuote] = useState<string | null>(null);

  useEffect(() => {
    const randomIndex = Math.floor(Math.random() * QUOTES.length);
    setQuote(QUOTES[randomIndex]);
  }, []);

  return <div id="quote-display">{quote ? `"${quote}"` : "Loading..."}</div>;
}
