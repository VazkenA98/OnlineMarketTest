package User;

public interface ExChange {
    static Double ChangeCurrency(double amount, Currency currency) {
        switch (currency) {
            case USD:
                amount = amount;
                break;
            case EUR:
                amount = (int) (amount * 1.1);
                break;
            case CAD:
                amount = (int) (amount * 0.75);
                break;
            default:
                amount = amount;
                break;
        }

        return amount;
    }

}
