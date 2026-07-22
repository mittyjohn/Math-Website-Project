INSERT INTO users (username, email, password)
SELECT 'jojo', 'jojo@gmail.com', '{noop}password'
    WHERE NOT EXISTS (SELECT * FROM users WHERE ID=1);

