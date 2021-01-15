package BankCard;

public class CardException extends Exception {

    public CardException() {
    }

    public CardException(String message) {
        super(message);
    }

    protected void forbidUseNegativeAmount(double amount) {
        System.err.println("Incorrect amount " + amount);
    }

    protected void forbidUseNegativeCurrency(double exchangeRates) {
        System.err.println("Incorrect exchangeRates " + exchangeRates);
    }
}
