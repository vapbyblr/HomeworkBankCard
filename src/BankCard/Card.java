package BankCard;

import java.math.BigDecimal;
import java.math.RoundingMode;

abstract public class Card {
    protected String nameHolder;
    protected BigDecimal balance;


    public Card(String nameHolder, BigDecimal balance) {
        this.nameHolder = nameHolder;
        this.balance = balance;
    }

    abstract void withdrawalOfFunds(double amount);

    protected void replenishmentBalance(double amount) {
        if (amount < 0) {
            try {
                throw new CardException();
            } catch (CardException e) {
                e.forbidUseNegativeAmount(amount);
            }
        } else {
            System.out.println("Replenishment balance on  " + amount);
            balance = balance.add(BigDecimal.valueOf(amount));
        }
    }

    protected void withdrawalCash(double amount) {
        if (amount < 0) {
            try {
                throw new CardException();
            } catch (CardException e) {
                e.forbidUseNegativeAmount(amount);
            }
        } else {
            if (amount > balance.doubleValue()) {
                System.out.println("not enough funds on the account");
            } else {
                System.out.println("Cash withdrawal  " + amount);
                balance = balance.subtract(BigDecimal.valueOf(amount));
            }
        }
    }

    public void recalculationBalanceInAnotherCurrency(double exchangeRates) {
        if (exchangeRates <= 0) {
            try {
                throw new CardException();
            } catch (CardException e) {
                e.forbidUseNegativeCurrency(exchangeRates);
            }
        } else {
            BigDecimal balanceInAnotherCurrency = balance.divide(BigDecimal.valueOf(exchangeRates), RoundingMode.CEILING);
            System.out.println("Balance in DEREVIANNIX is  "
                    + balanceInAnotherCurrency.setScale(5, RoundingMode.CEILING));
        }
    }

    @Override
    public String toString() {
        return "Name Holder  " + nameHolder + "\n" + "Balance " + balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;

        Card that = (Card) obj;

        if (balance.compareTo(that.balance) != 0) return false;
        return nameHolder.equals(that.nameHolder);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
