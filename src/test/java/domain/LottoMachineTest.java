package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("로또머신에_돈이_들어가면_올바른_로또수를_계산해야한다")
    void 로또머신에_돈이_들어가면_올바른_로또수를_계산해야한다() {

        //given
        lottoMachine.inputMoney(14000);

        //when
        int lottoCount = lottoMachine.getLottoCount();

        //then
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    @DisplayName("로또수만큼_로또를_생성해야한다")
    void 로또수만큼_로또를_생성해야한다() {

        //given
        lottoMachine.inputMoney(14000);

        //when
        int lottoCount = lottoMachine.getLottoCount();
        lottoMachine.generateLottos();

        //then
        assertThat(lottoMachine.getLottos().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("천원_이상_입력하지않으면_예외를_던진다")
    void 천원_이상_입력하지않으면_예외를_던진다() {

        //then
        assertThatThrownBy(() -> lottoMachine.inputMoney(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("천원_단위로_입력하지않으면_예외를_던진다")
    void 천원_단위로_입력하지않으면_예외를_던진다() {

        //then
        assertThatThrownBy(() -> lottoMachine.inputMoney(2001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}