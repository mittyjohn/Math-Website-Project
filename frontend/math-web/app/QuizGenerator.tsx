'use client';

import { useState, type FormEvent } from 'react';

type Difficulty = 'easy' | 'medium' | 'hard';

type QuizItem = {
  question: string;
  answer: string;
};

const quizBank: Record<Difficulty, QuizItem[]> = {
  easy: [
    { question: 'Problem: Find the remainder when a^b + c^d is divided by m./nWhen: 2 ≤ a, c ≤ 6; 10 ≤ b, d ≤ 30; 3 ≤ m ≤ 6; gcd(a, m) = gcd(c, m) = 1', answer: '' },
    { question: 'Problem: Find the last digit of a^b./nWhen: Last digit of a: 2, 3, 7, or 8; 10 ≤ b ≤ 40', answer: '' },
    { question: 'Problem: If an integer leaves remainder r when divided by m, what remainder does k^n leave when divided by m?/nWhen: 5 ≤ m ≤ 8; 1 ≤ r ≤ m; 2 ≤ k ≤ 4', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does its square leave?/nWhen: 5 ≤ m ≤ 8; 1 ≤ r < m.', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does its cube leave?/nWhen: 5 ≤ m ≤ 7; 1 ≤ r < m.', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does k^n + b leave?/nWhen: 2 ≤ k ≤ 4; 0 ≤ b ≤ 5; 4 ≤ m ≤ 7; 0 ≤ r < m.', answer: '' },
    { question: 'Problem: Find the remainder when a^b − c^d is divided by m/nWhen: 2 ≤ a, c ≤ 6; 10 ≤ b, d ≤ 30; 3 ≤ m ≤ 6; gcd(a, m) = gcd(c, m) = 1', answer: '' },
    { question: 'Problem: One integer leaves remainder r₁ when divided by m. Another leaves remainder r₂. What remainder does their product leave?/nWhen: 4 ≤ m ≤ 7; 1 ≤ r₁, r₂ < m', answer: '' },
  
],
  medium: [
    { question: 'Problem: Find the remainder when a^b + c^d is divided by m./nWhen: 2 ≤ a, c ≤ 10; 30 ≤ b, d ≤ 100; 5 ≤ m ≤ 9; gcd(a, m) = gcd(c, m) = 1', answer: '' },
    { question: 'Problem: Find the last digit of a^b./nWhen: Last digit of a: 2, 3, 7, 8, or 9; 40 ≤ b ≤ 150', answer: '' },
    { question: 'Problem: If an integer leaves remainder r when divided by m, what remainder does k^n leave when divided by m?/nWhen: 6 ≤ m ≤ 10; 1 ≤ r ≤ m; 2 ≤ k ≤ 7', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does its square leave?/nWhen: 6 ≤ m ≤ 10; 1 ≤ r < m.', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does its cube leave?/nWhen:  6 ≤ m ≤ 10; 1 ≤ r < m.', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does k^n + b leave?/nWhen: 2 ≤ k ≤ 8; 0 ≤ b ≤ 15; 5 ≤ m ≤ 10; 0 ≤ r < m.', answer: '' },
    { question: 'Problem: Find the remainder when a^b − c^d is divided by m/nWhen: 2 ≤ a, c ≤ 10; 30 ≤ b, d ≤ 100; 5 ≤ m ≤ 9; gcd(a, m) = gcd(c, m) = 1', answer: '' },
    { question: 'Problem: One integer leaves remainder r₁ when divided by m. Another leaves remainder r₂. What remainder does their product leave?/nWhen: 5 ≤ m ≤ 10; 1 ≤ r₁, r₂ < m', answer: '' },
    
  ],
  hard: [
    { question: 'Problem: Find the remainder when a^b + c^d is divided by m./nWhen: 2 ≤ a, c ≤ 15; 100 ≤ b, d ≤ 300; 7 ≤ m ≤ 12; gcd(a, m) = gcd(c, m) = 1', answer: '' },
    { question: 'Problem: Find the last digit of a^b./nWhen: Last digit of a: 2, 3, 7, 8, or 9; 150 ≤ b ≤ 500; Base may be any integer ending in one of those digits.', answer: '' },
    { question: 'Problem: If an integer leaves remainder r when divided by m, what remainder does k^n leave when divided by m?/nWhen: 8 ≤ m ≤ 15; 1 ≤ r ≤ m; 2 ≤ k ≤ 12', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does its square leave?/nWhen: 8 ≤ m ≤ 15; 1 ≤ r < m.', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does its cube leave?/nWhen: 8 ≤ m ≤ 15; 1 ≤ r < m.', answer: '' },
    { question: 'Problem: A number leaves remainder r when divided by m. What remainder does k^n + b leave?/nWhen: 2 ≤ k ≤ 12; 0 ≤ b ≤ 25; 7 ≤ m ≤ 15; 0 ≤ r < m.', answer: '' },
    { question: 'Problem: Find the remainder when a^b − c^d is divided by m/nWhen: 2 ≤ a, c ≤ 15; 100 ≤ b, d ≤ 300; 7 ≤ m ≤ 12; gcd(a, m) = gcd(c, m) = 1', answer: '' },
    { question: 'Problem: One integer leaves remainder r₁ when divided by m. Another leaves remainder r₂. What remainder does their product leave?/nWhen: 7 ≤ m ≤ 15; 1 ≤ r₁, r₂ < m', answer: '' },
  ],
};

function normalizeAnswer(value: string) {
  return value.trim().toLowerCase();
}

function shuffleArray<T>(items: T[]) {
  const copy = [...items];

  for (let index = copy.length - 1; index > 0; index -= 1) {
    const swapIndex = Math.floor(Math.random() * (index + 1));
    [copy[index], copy[swapIndex]] = [copy[swapIndex], copy[index]];
  }

  return copy;
}

export default function QuizGenerator() {
  const [difficulty, setDifficulty] = useState<Difficulty>('easy');
  const [numQuestions, setNumQuestions] = useState(5);
  const [randomizeOrder, setRandomizeOrder] = useState(true);
  const [phase, setPhase] = useState<'setup' | 'in-progress' | 'complete'>('setup');
  const [questions, setQuestions] = useState<QuizItem[]>([]);
  const [currentIndex, setCurrentIndex] = useState(0);
  const [userAnswer, setUserAnswer] = useState('');
  const [attempts, setAttempts] = useState(0);
  const [feedback, setFeedback] = useState('');
  const [showSolution, setShowSolution] = useState(false);
  const [score, setScore] = useState(0);

  const currentQuestion = questions[currentIndex];

  function startQuiz() {
    const count = Math.min(Math.max(numQuestions, 1), 10);
    const pool = quizBank[difficulty];
    const selectedQuestions = pool.slice(0, count);
    const orderedQuestions = randomizeOrder ? shuffleArray(selectedQuestions) : selectedQuestions;

    setQuestions(orderedQuestions);
    setCurrentIndex(0);
    setUserAnswer('');
    setAttempts(0);
    setFeedback('');
    setShowSolution(false);
    setScore(0);
    setPhase('in-progress');
  }

  function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();

    if (!currentQuestion) {
      return;
    }

    const normalizedGuess = normalizeAnswer(userAnswer);
    const normalizedAnswer = normalizeAnswer(currentQuestion.answer);

    if (normalizedGuess === normalizedAnswer) {
      const nextScore = score + 1;
      setScore(nextScore);
      setFeedback('Correct!');
      setShowSolution(false);

      const nextIndex = currentIndex + 1;
      if (nextIndex >= questions.length) {
        setPhase('complete');
        setUserAnswer('');
        return;
      }

      setCurrentIndex(nextIndex);
      setAttempts(0);
      setUserAnswer('');
      return;
    }

    const nextAttempts = attempts + 1;
    setAttempts(nextAttempts);

    if (nextAttempts >= 3) {
      setShowSolution(true);
      setFeedback('You used all 3 attempts.');
      return;
    }

    setFeedback(`Not quite. ${3 - nextAttempts} attempt${3 - nextAttempts === 1 ? '' : 's'} left.`);
  }

  function handleNextQuestion() {
    if (!questions.length) {
      return;
    }

    const nextIndex = currentIndex + 1;
    if (nextIndex >= questions.length) {
      setPhase('complete');
      return;
    }

    setCurrentIndex(nextIndex);
    setUserAnswer('');
    setAttempts(0);
    setFeedback('');
    setShowSolution(false);
  }

  return (
    <section className="w-full max-w-4xl rounded-2xl border border-black bg-black p-6 shadow-sm">
      <div className="mb-6 text-center">
        <h2 className="text-3xl font-bold text-white">Modular Arithmetic Quiz Generator</h2>
        <p className="mt-2 text-slate-200">
          Pick a difficulty, choose how many questions you want, and answer each one. You get up to 3 tries before the solution is revealed.
        </p>
      </div>

      {phase === 'setup' && (
        <div className="space-y-6">
          <div className="flex flex-wrap justify-center gap-3">
            {(['easy', 'medium', 'hard'] as Difficulty[]).map((level) => (
              <button
                key={level}
                type="button"
                onClick={() => setDifficulty(level)}
                className={`rounded-full px-4 py-2 font-semibold transition ${
                  difficulty === level
                    ? 'bg-blue-600 text-white'
                    : 'bg-slate-100 text-slate-700 hover:bg-slate-200'
                }`}
              >
                {level.charAt(0).toUpperCase() + level.slice(1)}
              </button>
            ))}
          </div>

          <div className="flex flex-col items-center gap-2">
            <label htmlFor="numQuestions" className="text-lg font-medium text-slate-400">
              Number of Questions
            </label>
            <input
              id="numQuestions"
              type="number"
              min="1"
              max="10"
              value={numQuestions}
              onChange={(event) => setNumQuestions(Number(event.target.value))}
              className="w-28 rounded border border-slate-300 px-3 py-2 text-center"
            />
          </div>

          <label className="flex items-center justify-center gap-2 text-sm font-medium text-slate-300">
            <input
              type="checkbox"
              checked={randomizeOrder}
              onChange={() => setRandomizeOrder((currentValue) => !currentValue)}
            />
            Randomize question order
          </label>

          <div className="flex justify-center">
            <button
              type="button"
              onClick={startQuiz}
              className="rounded bg-blue-600 px-5 py-2 font-semibold text-white hover:bg-blue-700"
            >
              Start Quiz
            </button>
          </div>
        </div>
      )}

      {phase === 'in-progress' && currentQuestion && (
        <form onSubmit={handleSubmit} className="space-y-4">
          <div className="text-sm font-medium uppercase tracking-wide text-slate-500">
            {difficulty.charAt(0).toUpperCase() + difficulty.slice(1)} • Question {currentIndex + 1} of {questions.length}
          </div>
          <h3 className="text-2xl font-semibold text-white">{currentQuestion.question}</h3>

          <input
            type="text"
            value={userAnswer}
            onChange={(event) => setUserAnswer(event.target.value)}
            disabled={showSolution}
            placeholder="Type your answer"
            className="w-full rounded border border-slate-300 px-3 py-2"
          />

          <div className="flex flex-wrap items-center gap-3">
            <button
              type="submit"
              disabled={showSolution}
              className="rounded bg-slate-800 px-4 py-2 font-semibold text-white hover:bg-slate-700 disabled:cursor-not-allowed disabled:bg-slate-400"
            >
              Check Answer
            </button>
            <button
              type="button"
              onClick={() => setPhase('setup')}
              className="rounded border border-slate-300 px-4 py-2 font-semibold text-slate-700 hover:bg-slate-100"
            >
              Back
            </button>
          </div>

          {feedback && <p className="text-sm text-slate-300">{feedback}</p>}

          {showSolution && (
            <div className="rounded-lg border border-amber-200 bg-amber-50 p-4 text-sm text-amber-800">
              <p className="font-semibold">Solution:</p>
              <p>{currentQuestion.answer}</p>
              <button
                type="button"
                onClick={handleNextQuestion}
                className="mt-3 rounded bg-amber-600 px-4 py-2 font-semibold text-white hover:bg-amber-700"
              >
                Next Question
              </button>
            </div>
          )}
        </form>
      )}

      {phase === 'complete' && (
        <div className="space-y-4 text-center">
          <h3 className="text-2xl font-semibold text-slate-800">Quiz Complete!</h3>
          <p className="text-lg text-slate-600">
            You got {score} out of {questions.length} correct.
          </p>
          <button
            type="button"
            onClick={() => setPhase('setup')}
            className="rounded bg-blue-600 px-5 py-2 font-semibold text-white hover:bg-blue-700"
          >
            Start Another Quiz?
          </button>
        </div>
      )}
    </section>
  );
}

