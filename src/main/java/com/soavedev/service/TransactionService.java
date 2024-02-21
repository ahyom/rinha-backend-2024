package com.soavedev.service;

import com.soavedev.domain.entity.Transaction;
import com.soavedev.domain.exception.InsufficientBalanceException;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    public static void processTransaction(Transaction transaction) {

        int clientCurrentBalance = transaction.getClient().getBalance();
        int clientNewBalance = 0;
        int amount = transaction.getAmount();


        if (transaction.getType().equalsIgnoreCase("c")) {
            clientNewBalance = clientCurrentBalance + amount;
        } else {
            clientNewBalance = clientCurrentBalance - amount;
            if (clientNewBalance < transaction.getClient().getLimit() * -1) {
                log.debug("Saldo insuficiente. Saldo antes da transação [{}] | Saldo depois da transação [{}] | Limite [{}]", clientCurrentBalance, clientNewBalance, transaction.getClient().getLimit());
                throw new InsufficientBalanceException();
            }
        }

        transaction.getClient().setBalance(clientNewBalance);
        Transaction.persist(transaction);

    }
}
