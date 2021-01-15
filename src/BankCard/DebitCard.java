package BankCard;

import java.math.BigDecimal;

public class DebitCard extends Card {

    public DebitCard(String nameHolder, BigDecimal balance) { super(nameHolder, balance); }

    @Override
    public void withdrawalOfFunds(double amount) {
        if (amount > getBalance().doubleValue()) {
            System.out.println("not enough funds on the account");
        } else {
            System.out.println("Funds withdrawal  " + amount);
            balance = balance.subtract(BigDecimal.valueOf(amount));
        }
    }
}
