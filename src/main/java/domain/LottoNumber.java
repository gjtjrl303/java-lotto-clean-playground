package domain;

public class LottoNumber  {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 번호는 " + MIN + " 이상 " + MAX + " 이하의 숫자여야 합니다.");
        }
    }
}
