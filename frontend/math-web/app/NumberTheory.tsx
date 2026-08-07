import Link from 'next/link';

const NumberTheory = () => {
    return (<><div className="ContentPage"><h1>Content Page</h1>
    <p>Put Content here.</p>
    </div>
    <div className="Create Quiz"><Link className="text-blue-700 hover:text-white" href="/quiz">Create Quiz</Link></div></>)

}

export default NumberTheory;