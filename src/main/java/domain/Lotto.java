package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        validateLotto(lotto);
        this.lotto = lotto;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lotto);
    }

    private void validateLotto(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다");
        }
    }
}
