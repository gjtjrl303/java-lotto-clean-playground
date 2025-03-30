package domain;

public class Money {

    public static final int PRICE_PER_TICKET = 1000;

    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getPurchasedLottoCount() {
        return amount / PRICE_PER_TICKET;
    }

    private void validate(int value) {
        if (value < PRICE_PER_TICKET) {
            throw new IllegalArgumentException("로또는 최소 1장 이상 구매해야 합니다.");
        }
        if (value % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("1000원 단위로만 구매할 수 있습니다.");
        }
    }
}
