import Link from 'next/link';
import QuizGenerator from './QuizGenerator';

const QuizPage = () => {
    const GenerateQuiz = (event: React.MouseEvent<HTMLButtonElement>) => {
        // Logic to start the quiz can be added here
        console.log("Quiz started!");
    }
    
    const changeDifficulty = (difficulty: string) => {
        // Logic to change the difficulty of the quiz can be added here
        console.log(`Difficulty changed to: ${difficulty}`);
    }
    
    const changeNumberOfQuestions = (numQuestions: number) => {
        // Logic to change the number of questions in the quiz can be added here
        console.log(`Number of questions changed to: ${numQuestions}`);
    }

    return (<><div className="Quiz Page">Quiz Page</div>
    <div className="mb-4"><Link className="text-blue-700 hover:text-white" href="/number-theory">Back to Number Theory</Link></div>
    <h1>Content Quiz Page</h1><p>Generate quiz content here.</p>
    <p>Choose difficulty</p><button>Easy</button><button>Medium</button><button>Hard</button><p>
    Choose number of questions</p><button>5</button><button>10</button><button>15</button><button>20</button>
    <button onClick={GenerateQuiz}>Start Quiz</button></>);
}
export default QuizPage;
