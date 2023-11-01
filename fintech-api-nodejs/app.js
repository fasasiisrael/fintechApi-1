const express = require('express');
const bodyParser = require('body-parser');
const jwt = require('jsonwebtoken');
const swaggerJsdoc = require('swagger-jsdoc');
const swaggerUi = require('swagger-ui-express');

const app = express();
const port = 3000;

// Swagger definition
const swaggerDefinition = {
  info: {
    title: 'Financial API',
    version: '1.0.0',
    description: 'API for financial transactions',
  },
  host: `localhost:${port}`,
  basePath: '/',
};

// Options for the Swagger JSON output
const options = {
  swaggerDefinition,
  apis: ['app.js'], 
};

const swaggerSpec = swaggerJsdoc(options);

app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec));

app.use(bodyParser.json());

// Authentication middleware using JWT
function authenticateToken(req, res, next) {
  const token = req.headers.authorization;
  if (token == null) return res.sendStatus(401);
  jwt.verify(token, '8a*17Z#PqWgF3$xT9vHc', (err, user) => {
    if (err) return res.sendStatus(403);
    req.user = user;
    next();
  });
}

/**
 * @swagger
 * /transactions/deposit:
 *   post:
 *     description: Deposit funds
 *     summary: Deposit funds into an account.
 *     produces:
 *       - application/json
 *     parameters:
 *       - name: Authorization
 *         in: header
 *         description: JWT token (Bearer token) for authentication.
 *         required: true
 *         type: string
 *       - name: body
 *         in: body
 *         description: Deposit request data.
 *         required: true
 *         schema:
 *           type: object
 *           properties:
 *             sourceAccount:
 *               type: string
 *               description: Account from which funds will be deposited.
 *             targetAccount:
 *               type: string
 *               description: Account to which funds will be deposited.
 *             amount:
 *               type: number
 *               description: The amount to be deposited.
 *     responses:
 *       200:
 *         description: Deposit successful
 */

// Endpoint code here
app.post('/transactions/deposit', authenticateToken, (req, res) => {
  // Implement deposit logic and securely log the transaction event
  res.status(200).send('Deposit successful');
});


/**
 * @swagger
 * /transactions/withdraw:
 *   post:
 *     description: Withdraw funds
 *     produces:
 *       - application/json
 *     parameters:
 *       - name: Authorization
 *         in: header
 *         description: JWT token (Bearer token)
 *         required: true
 *         type: string
 *       - name: body
 *         in: body
 *         description: Withdrawal request data
 *         required: true
 *         schema:
 *           type: object
 *           properties:
 *             sourceAccount:
 *               type: string
 *             amount:
 *               type: number
 *     responses:
 *       200:
 *         description: Withdrawal successful
 */
app.post('/transactions/withdraw', authenticateToken, (req, res) => {
  // Implement withdrawal logic and securely log the transaction event
  res.status(200).send('Withdrawal successful');
});

/**
 * @swagger
 * /transactions/transfer:
 *   post:
 *     description: Transfer funds
 *     produces:
 *       - application/json
 *     parameters:
 *       - name: Authorization
 *         in: header
 *         description: JWT token (Bearer token)
 *         required: true
 *         type: string
 *       - name: body
 *         in: body
 *         description: Transfer request data
 *         required: true
 *         schema:
 *           type: object
 *           properties:
 *             sourceAccount:
 *               type: string
 *             targetAccount:
 *               type: string
 *             amount:
 *               type: number
 *     responses:
 *       200:
 *         description: Transfer successful
 */
app.post('/transactions/transfer', authenticateToken, (req, res) => {
  // Implement transfer logic and securely log the transaction event
  res.status(200).send('Transfer successful');
});

app.listen(port, () => {
  console.log(`Node.js API is running on port ${port}`);
});
