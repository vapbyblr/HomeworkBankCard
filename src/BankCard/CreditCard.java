package BankCard;

import java.math.BigDecimal;

public class CreditCard extends Card {

    public CreditCard(String nameHolder, BigDecimal balance) {
        super(nameHolder, balance);
    }

    @Override
    public void withdrawalOfFunds(double amount) {
        System.out.println("Funds withdrawal  " + amount);
        balance = balance.subtract(BigDecimal.valueOf(amount));
    }

}
