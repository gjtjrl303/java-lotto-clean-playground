package domain;

import controller.LottoController;

import java.util.List;

public class LottoWinningNumbers {

    private final Lotto winningNumbers;

    public LottoWinningNumbers(List<Integer> numbers) {
        winningNumbers = new Lotto(numbers);
    }

    public Integer matchCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers.getLottoNumbers()::contains)
                .count();
    }
}
