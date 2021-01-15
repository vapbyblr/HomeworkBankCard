package BankCard;

import java.math.BigDecimal;

public class temp {
    public static void main(String[] args) {

        DebitCard myDebitCard = new DebitCard("Andrey", BigDecimal.valueOf(789.654));
        ATM atm = new ATM();
        atm.usingATM(myDebitCard);
        System.out.println(myDebitCard.getBalance());
        atm.withdrawalCash(-25.35);
        System.out.println(myDebitCard.getBalance());
        atm.withdrawalCash(100);
        System.out.println(myDebitCard.getBalance());
        atm.withdrawalCash(800);
        System.out.println(myDebitCard.getBalance());
        myDebitCard.balance = BigDecimal.valueOf(55555.5555);
        System.out.println(myDebitCard.getBalance());


    }
}
