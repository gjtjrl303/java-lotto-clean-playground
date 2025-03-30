package domain;

import enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.lottoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    lottoService lottoService;
    LottoMachine lottoMachine;

    @BeforeEach
    void beforeEach() {
        List<List<Integer>> fixedNumbersList = List.of(
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)),
                new ArrayList<>(List.of(2, 3, 4, 5, 6, 7)),
                new ArrayList<>(List.of(3, 4, 5, 6, 7, 8)),
                new ArrayList<>(List.of(4, 5, 6, 7, 8, 9)),
                new ArrayList<>(List.of(5, 6, 7, 8, 9, 10)),
                new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))
        );
        lottoMachine = new LottoMachine(new FakeNumberGenerator(fixedNumbersList));
        lottoService = new lottoService(lottoMachine);
    }

    @Test
    @DisplayName("가격에_맞춰서_로또를_발급한다")
    void 가격에_맞춰서_로또를_발급한다() {

        //given
        lottoService.inputMoney(new Money(5000));

        //when
        lottoService.generateLottos();
        List<Lotto> purchasedLottos = lottoService.getPurchasedLottos();

        //then
        assertThat(purchasedLottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또수를_알맞게_발급한다")
    void 로또수를_알맞게_발급한다() {
        //given
        lottoService.inputMoney(new Money(5000));

        //when
        int lottoCount = lottoService.getLottoCount();
        //then
        assertThat(lottoCount).isEqualTo(5);
    }

    @Test
    @DisplayName("생성된_로또를_정확히_반환한다")
    void 생성된_로또를_정확히_반환한다() {
        //given
        lottoService.inputMoney(new Money(2000));
        lottoService.generateLottos();

        //when
        List<Lotto> lottos = lottoService.getPurchasedLottos();

        //then
        assertThat(lottos.get(0).getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList()))
                .containsExactly(1, 2, 3, 4, 5, 6);

        assertThat(lottos.get(1).getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList()))
                .containsExactly(2, 3, 4, 5, 6, 7);
    }

    @Test
    @DisplayName("로또별_맞춘_숫자의_개수를_찾는다")
    void 로또별_맞춘_숫자의_개수를_찾는다() {
        //given
        lottoService.inputMoney(new Money(5000));
        lottoService.generateLottos();
        lottoService.inputWinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        //when
        Map<LottoRank, Integer> resultByRank = lottoService.getResultByRank();


        //then
        assertThat(resultByRank.get(LottoRank.NO_MATCH)).isEqualTo(1);
        assertThat(resultByRank.get(LottoRank.MATCH_3)).isEqualTo(1);
        assertThat(resultByRank.get(LottoRank.MATCH_4)).isEqualTo(1);
        assertThat(resultByRank.get(LottoRank.MATCH_5)).isEqualTo(1);
        assertThat(resultByRank.get(LottoRank.MATCH_6)).isEqualTo(1);

    }
}
