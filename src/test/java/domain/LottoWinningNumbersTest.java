package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoWinningNumbersTest {

    LottoWinningNumbers lottoWinningNumbers;

    @Test
    @DisplayName("LottoWinningNumbers가_로또의_맞는개수를_정확히_판단한다")
    void LottoWinningNumbers가_로또의_맞는개수를_정확히_판단한다() {
        //given
        List<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lottoWinningNumbers = new LottoWinningNumbers(numbers1);

        List<Integer> numbers2 = new ArrayList<>(List.of(1, 2, 3, 9, 9, 9));
        Lotto lotto = new Lotto(numbers2);

        //then
        Assertions.assertThat(lottoWinningNumbers.matchCount(lotto)).isEqualTo(3);
    }
}