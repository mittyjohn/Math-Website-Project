-- modular arithmetic EASY questions
INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
'Find the remainder when a^b + c^d is divided by m./nWhen: 2 ≤ a, c ≤ 6; 10 ≤ b, d ≤ 30; 3 ≤ m ≤ ' ||
'6; gcd(a, m) = gcd(c, m) = 1';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
       'Find the last digit of a^b./nWhen: Last digit of a: 2, 3, 7, or 8; 10 ≤ b ≤ 40';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
    'If an integer leaves remainder r when divided by m, what remainder does k^n leave when ' ||
    'divided by m?/nWhen: 5 ≤ m ≤ 8; 1 ≤ r ≤ m; 2 ≤ k ≤ 4';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
       'A number leaves remainder r when divided by m. What remainder does its square ' ||
       'leave?/nWhen: 5 ≤ m ≤ 8; 1 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
       'A number leaves remainder r when divided by m. What remainder does its cube leave?/nWhen:' ||
       ' 5 ≤ m ≤ 7; 1 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
       'A number leaves remainder r when divided by m. What remainder does k^n + b leave?/nWhen:' ||
       ' 2 ≤ k ≤ 4; 0 ≤ b ≤ 5; 4 ≤ m ≤ 7; 0 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
       'Find the remainder when a^b − c^d is divided by m/nWhen: 2 ≤ a, c ≤ 6; 10 ≤ b, d ≤ 30; 3 ' ||
       '≤ m ≤ 6; gcd(a, m) = gcd(c, m) = 1';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'EASY',
       'One integer leaves remainder r₁ when divided by m. Another leaves remainder r₂. What ' ||
       'remainder does their product leave?/nWhen: 4 ≤ m ≤ 7; 1 ≤ r₁, r₂ < m';


-- modular arithmetic MEDIUM questions
INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'Problem: Find the remainder when a^b + c^d is divided by m./nWhen: 2 ≤ a, c ≤ 10; 30 ≤ ' ||
       'b, d ≤ 100; 5 ≤ m ≤ 9; gcd(a, m) = gcd(c, m) = 1';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'Find the last digit of a^b./nWhen: Last digit of a: 2, 3, 7, 8, or 9; 40 ≤ b ≤ 150';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'If an integer leaves remainder r when divided by m, what remainder does k^n leave when ' ||
       'divided by m?/nWhen: 6 ≤ m ≤ 10; 1 ≤ r ≤ m; 2 ≤ k ≤ 7';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'A number leaves remainder r when divided by m. What remainder does its square ' ||
       'leave?/nWhen: 6 ≤ m ≤ 10; 1 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'A number leaves remainder r when divided by m. What remainder does its cube leave?/nWhen:' ||
       '  6 ≤ m ≤ 10; 1 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'A number leaves remainder r when divided by m. What remainder does k^n + b leave?/nWhen: ' ||
       '2 ≤ k ≤ 8; 0 ≤ b ≤ 15; 5 ≤ m ≤ 10; 0 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'Find the remainder when a^b − c^d is divided by m/nWhen: 2 ≤ a, c ≤ 10; 30 ≤ b, d ≤ 100; ' ||
       '5 ≤ m ≤ 9; gcd(a, m) = gcd(c, m) = 1';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'MEDIUM',
       'One integer leaves remainder r₁ when divided by m. Another leaves remainder r₂. What ' ||
       'remainder does their product leave?/nWhen: 5 ≤ m ≤ 10; 1 ≤ r₁, r₂ < m';

-- modular arithmetic HARD questions
INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'Find the remainder when a^b + c^d is divided by m./nWhen: 2 ≤ a, c ≤ 15; 100 ≤ b, d ≤ ' ||
       '300; 7 ≤ m ≤ 12; gcd(a, m) = gcd(c, m) = 1';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'Find the last digit of a^b./nWhen: Last digit of a: 2, 3, 7, 8, or 9; 150 ≤ b ≤ 500; Base' ||
       ' may be any integer ending in one of those digits.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'If an integer leaves remainder r when divided by m, what remainder does k^n leave when ' ||
       'divided by m?/nWhen: 8 ≤ m ≤ 15; 1 ≤ r ≤ m; 2 ≤ k ≤ 12';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'A number leaves remainder r when divided by m. What remainder does its square ' ||
       'leave?/nWhen: 8 ≤ m ≤ 15; 1 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'A number leaves remainder r when divided by m. What remainder does its cube ' ||
       'leave?/nWhen: 8 ≤ m ≤ 15; 1 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'A number leaves remainder r when divided by m. What remainder does k^n + b leave?/nWhen: ' ||
       '2 ≤ k ≤ 12; 0 ≤ b ≤ 25; 7 ≤ m ≤ 15; 0 ≤ r < m.';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'Problem: Find the remainder when a^b − c^d is divided by m/nWhen: 2 ≤ a, c ≤ 15; 100 ≤ b,' ||
       ' d ≤ 300; 7 ≤ m ≤ 12; gcd(a, m) = gcd(c, m) = 1';

INSERT INTO questions (topic, difficulty, description)
SELECT 'modular arithmetic', 'HARD',
       'Problem: One integer leaves remainder r₁ when divided by m. Another leaves remainder r₂. ' ||
       'What remainder does their product leave?/nWhen: 7 ≤ m ≤ 15; 1 ≤ r₁, r₂ < m';


