package com.vpd.models;

/**
 * Represents a financial transaction request.
 */
public class TransactionRequest {

    private String sourceAccount;
    private String targetAccount;
    private double amount;

    /**
     * Default constructor.
     */
    public TransactionRequest() {
    }

    /**
     * Creates a transaction request with specified details.
     *
     * @param sourceAccount The source account from which the transaction occurs.
     * @param targetAccount The target account to which the transaction is made.
     * @param amount        The amount to be transacted.
     */
    public TransactionRequest(String sourceAccount, String targetAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    /**
     * Get the source account of the transaction.
     *
     * @return The source account.
     */
    public String getSourceAccount() {
        return sourceAccount;
    }

    /**
     * Set the source account of the transaction.
     *
     * @param sourceAccount The source account to set.
     */
    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    /**
     * Get the target account of the transaction.
     *
     * @return The target account.
     */
    public String getTargetAccount() {
        return targetAccount;
    }

    /**
     * Set the target account of the transaction.
     *
     * @param targetAccount The target account to set.
     */
    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    /**
     * Get the amount to be transacted in the transaction.
     *
     * @return The transaction amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set the amount to be transacted in the transaction.
     *
     * @param amount The transaction amount to set.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
