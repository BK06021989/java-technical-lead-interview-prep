package com.java.java_array;

/*Write a Java 8 program that processes a list of transactions, groups them by 
 * currency code, and calculates the total credit and debit amount for each currency.
 */
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionTotalsByCurrency {

    enum TransactionType {
        CREDIT, DEBIT
    }

    static class Transaction {
        private final String currencyCode;
        private final TransactionType type;
        private final BigDecimal amount;

        Transaction(String currencyCode, TransactionType type, String amount) {
            this.currencyCode = currencyCode;
            this.type = type;
            this.amount = new BigDecimal(amount);
        }

        String getCurrencyCode() {
            return currencyCode;
        }

        TransactionType getType() {
            return type;
        }

        BigDecimal getAmount() {
            return amount;
        }
    }

    static class Totals {
        private BigDecimal credit = BigDecimal.ZERO;
        private BigDecimal debit = BigDecimal.ZERO;

        void add(Transaction transaction) {
            if (transaction.getType() == TransactionType.CREDIT) {
                credit = credit.add(transaction.getAmount());
            } else {
                debit = debit.add(transaction.getAmount());
            }
        }

        BigDecimal getCredit() {
            return credit;
        }

        BigDecimal getDebit() {
            return debit;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("USD", TransactionType.CREDIT, "1000.00"),
            new Transaction("USD", TransactionType.DEBIT, "250.00"),
            new Transaction("EUR", TransactionType.CREDIT, "500.00"),
            new Transaction("EUR", TransactionType.DEBIT, "100.00"),
            new Transaction("USD", TransactionType.CREDIT, "300.00"),
            new Transaction("INR", TransactionType.DEBIT, "750.00")
        );

        Map<String, Totals> totalsByCurrency = transactions.stream()
            .collect(Collectors.groupingBy(
                Transaction::getCurrencyCode,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                        Totals totals = new Totals();
                        list.forEach(totals::add);
                        return totals;
                    }
                )
            ));

        totalsByCurrency.forEach((currency, totals) -> {
            System.out.println(currency
                + " | Credit: " + totals.getCredit()
                + " | Debit: " + totals.getDebit());
        });
    }
}