package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoShopTest {

    LottoShop lottoShop = new LottoShop();

    @Test
    @DisplayName("가격에_맞춰서_로또를_발급한다")
    void 가격에_맞춰서_로또를_발급한다() {
        //given
        lottoShop.inputMoney(14000);

        //when
        List<Lotto> purchasedLottos = lottoShop.getPurchasedLottos();

        //then
        Assertions.assertThat(purchasedLottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또수를_알맞게_발급한다")
    void 로또수를_알맞게_발급한다() {
        //given
        lottoShop.inputMoney(14000);

        //when
        int lottoCount = lottoShop.getLottoCount();
        //then
        Assertions.assertThat(lottoCount).isEqualTo(14);
    }
}
