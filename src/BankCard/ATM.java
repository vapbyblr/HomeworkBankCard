package BankCard;
import java.util.Objects;

public class ATM {
    private Card card;
    private boolean cardInATM = false;

    public void usingATM(Card card) {
        this.card = card;
        cardInATM = true;
    }

    public void replenishmentBalance(double amount) {
        if (cardInATM) {
            card.replenishmentBalance(amount);
        } else {
            System.out.println("Using ATM");
        }
    }

    public void withdrawalCash(double amount) {
        if (cardInATM) {
            card.withdrawalCash(amount);
        } else {
            System.out.println("Using ATM");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return cardInATM == atm.cardInATM &&
                Objects.equals(card, atm.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, cardInATM);
    }
}
