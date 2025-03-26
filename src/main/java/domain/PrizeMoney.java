package domain;

public class PrizeMoney {

    private final double amount;

    public PrizeMoney(double amount) {
        this.amount = amount;
    }

    public PrizeMoney plus(PrizeMoney other) {
        return new PrizeMoney(this.amount + other.amount);
    }

    public PrizeMoney multiply(int count) {
        return new PrizeMoney(this.amount * count);
    }

    public double getAmount() {
        return amount;
    }

}
