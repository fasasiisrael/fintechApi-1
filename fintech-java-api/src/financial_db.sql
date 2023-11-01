-- Create a table to store user information
CREATE TABLE users (
    id INTEGER PRIMARY KEY,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

-- Insert sample user data
INSERT INTO users (username, password, role) VALUES
    ('user1', 'password1', 'user'),
    ('user2', 'password2', 'user'),
    ('admin', 'admin123', 'admin');

-- Create a table to store account information
CREATE TABLE accounts (
    id INTEGER PRIMARY KEY,
    account_number TEXT NOT NULL,
    balance REAL NOT NULL,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert sample account data
INSERT INTO accounts (account_number, balance, user_id) VALUES
    ('123456789', 5000.00, 1),
    ('987654321', 3000.00, 2);

-- Create a table to log financial transactions
CREATE TABLE transactions (
    id INTEGER PRIMARY KEY,
    transaction_type TEXT NOT NULL,
    source_account TEXT NOT NULL,
    target_account TEXT NOT NULL,
    amount REAL NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert sample transaction data
INSERT INTO transactions (transaction_type, source_account, target_account, amount, user_id) VALUES
    ('Deposit', '123456789', NULL, 1000.00, 1),
    ('Withdrawal', '987654321', NULL, 500.00, 2),
    ('Transfer', '123456789', '987654321', 200.00, 1);
