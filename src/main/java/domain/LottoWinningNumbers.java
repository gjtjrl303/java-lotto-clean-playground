package domain;

import java.util.List;

public class LottoWinningNumbers {

    private final Lotto winningNumbers;

    public LottoWinningNumbers(List<Integer> numbers) {
        winningNumbers = Lotto.from(numbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(number -> winningNumbers.getLottoNumbers().contains(number))
                .count();
    }
}
