package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또에 숫자가 정확히 들어가야한다")
    void 로또에_숫자가_정확히_들어가야한다() {
        //given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        //when
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        //then
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 숫자가 6개가 아니면 예외를 던진다")
    void 로또_숫자가_6개가_아니면_예외를_던진다() {
        //given
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        //then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("외부에서 리스트 수정 시 예외 발생")
    void 외부에서_리스트_수정_시_예외_발생() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> lotto.getLottoNumbers().add(4))
                .isInstanceOf(UnsupportedOperationException.class);
    }

}