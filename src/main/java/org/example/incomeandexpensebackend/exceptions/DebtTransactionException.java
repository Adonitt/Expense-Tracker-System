package org.example.incomeandexpensebackend.exceptions;

public class DebtTransactionException extends RuntimeException
{
    public DebtTransactionException(String message) {
        super(message);
    }
}
