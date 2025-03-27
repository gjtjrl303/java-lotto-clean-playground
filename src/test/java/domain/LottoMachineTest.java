package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

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
    }

    @Test
    @DisplayName("값에_맞는_로또수를_생성해야한다")
    void 값에_맞는_로또수를_생성해야한다() {

        //given
        lottoMachine.inputMoney(new Money(5000));

        //when
        int lottoCount = lottoMachine.getLottoCount();
        lottoMachine.generateLottos();

        //then
        assertThat(lottoMachine.getLottos().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("천원_이상_입력하지않으면_예외를_던진다")
    void 천원_이상_입력하지않으면_예외를_던진다() {

        //then
        assertThatThrownBy(() -> lottoMachine.inputMoney(new Money(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("천원_단위로_입력하지않으면_예외를_던진다")
    void 천원_단위로_입력하지않으면_예외를_던진다() {

        //then
        assertThatThrownBy(() -> lottoMachine.inputMoney(new Money(2001)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}