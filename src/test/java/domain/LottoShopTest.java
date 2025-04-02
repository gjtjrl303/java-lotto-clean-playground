package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.*;

class LottoShopTest {

    LottoShop lottoShop;
    LottoMachine lottoMachine;
    List<Lotto> lottos;

    @BeforeEach
    void beforeEach() {
        List<List<Integer>> fixedNumbersList = List.of(
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)),
                new ArrayList<>(List.of(2, 3, 4, 5, 6, 7)),
                new ArrayList<>(List.of(3, 4, 5, 6, 7, 8))
        );
        lottoMachine = new LottoMachine(new FakeNumberGenerator(fixedNumbersList));
        lottoShop = new LottoShop(lottoMachine);

        lottos = new ArrayList<>();
        lottos.add(Lotto.from(List.of(4, 5, 6, 7, 8, 9)));
        lottos.add(Lotto.from(List.of(5, 6, 7, 8, 9, 10)));
        lottos.add(Lotto.from(List.of(6, 7, 8, 9, 10, 11)));
    }

    @Test
    @DisplayName("수동로또개수는 로또개수보다 많으면 예외를 던진다")
    void 수동로또개수는_로또개수보다_많으면_예외를_던진다() {
        assertThatThrownBy(() -> lottoShop.purchaseLottos(Money.from(3000), LottoCount.from(4), lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoShop이_수동로또_자동로또를_알맞게_반환한다")
    void LottoShop이_수동로또_자동로또를_알맞게_반환한다() {
        //given
        List<List<Integer>> fixedNumbersList = List.of(
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)),
                new ArrayList<>(List.of(2, 3, 4, 5, 6, 7)),
                new ArrayList<>(List.of(3, 4, 5, 6, 7, 8))
        );
        lottoMachine = new LottoMachine(new FakeNumberGenerator(fixedNumbersList));
        lottoShop = new LottoShop(lottoMachine);

        List<Lotto> manualLottos = new ArrayList<>();
        manualLottos.add(Lotto.from(List.of(4, 5, 6, 7, 8, 9)));
        manualLottos.add(Lotto.from(List.of(5, 6, 7, 8, 9, 10)));

        //when
        LottoPurchase lottoPurchase = lottoShop.purchaseLottos(Money.from(3000), LottoCount.from(2), manualLottos);
        List<Lotto> purchasedLottos = lottoPurchase.getLottos();

        // then
        assertThat(purchasedLottos)
                .hasSize(3) // 3개의 로또가 있어야 함
                .extracting(Lotto::getLottoNumbers) // Lotto 객체의 번호 리스트만 추출
                .containsExactly(
                        new TreeSet<>(List.of(LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6), LottoNumber.from(7), LottoNumber.from(8), LottoNumber.from(9))),
                        new TreeSet<>(List.of(LottoNumber.from(5), LottoNumber.from(6), LottoNumber.from(7), LottoNumber.from(8), LottoNumber.from(9), LottoNumber.from(10))),
                        new TreeSet<>(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)))
                );
    }
}
