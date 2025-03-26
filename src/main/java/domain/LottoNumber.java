package domain;

public class LottoNumber  {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("로또 번호는 " + MIN + " 이상 " + MAX + " 이하의 숫자여야 합니다.");
        }
    }
}
