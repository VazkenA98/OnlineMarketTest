package User;

public class Wallet {
    private Currency currency;
    private double amount;

    public Wallet() {
    }

    public Wallet(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void availableCurrency() {
        System.out.println("type on of these");
        System.out.print("[");
        for (Currency s : Currency.values()) {
            System.out.print(s + ", ");
        }
        System.out.print("]");
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
