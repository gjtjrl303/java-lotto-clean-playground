package domain;


import enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    LottoResult lottoResult;
    List<Lotto> lottos;
    LottoWinningNumbers lottoWinningNumbers;

    @BeforeEach
    void beforeEach() {
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(4, 5, 6, 7, 8, 9)));
        Lotto lotto3 = new Lotto(new ArrayList<>(List.of(1, 2, 5, 6, 9, 10)));

        lottos = new ArrayList<>(List.of(lotto1, lotto2, lotto3));
        lottoWinningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("lottoResult가_로또의_맞춘숫자를_정확히_계산한다")
    void lottoResult가_로또의_맞춘숫자를_정확히_계산한다() {

        //given
        lottoResult = new LottoResult(lottoWinningNumbers, lottos);

        //when
        Map<LottoRank, Integer> resultByRank = lottoResult.getResultByRank();

        //then
        assertThat(resultByRank.get(LottoRank.NO_MATCH)).isEqualTo(0);
        assertThat(resultByRank.get(LottoRank.MATCH_3)).isEqualTo(1);
        assertThat(resultByRank.get(LottoRank.MATCH_4)).isEqualTo(1);
        assertThat(resultByRank.get(LottoRank.MATCH_5)).isEqualTo(0);
        assertThat(resultByRank.get(LottoRank.MATCH_6)).isEqualTo(1);
    }

    @Test
    @DisplayName("lottoResult가_상금수익률을_정확히_계산한다")
    void lottoResult가_상금수익률을_정확히_계산한다() {

        //given
        lottoResult = new LottoResult(lottoWinningNumbers, lottos);

        //when
        Double profitRate = lottoResult.calculateProfitRate();

        //then
        assertThat(profitRate).isEqualTo(666_685);
    }
}