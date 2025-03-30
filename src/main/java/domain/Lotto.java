package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    List<LottoNumber> lotto;

    public static Lotto from(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private Lotto(List<LottoNumber> lotto) {
        validateLotto(lotto);
        this.lotto = lotto;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lotto);
    }

    private void validateLotto(List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다");
        }
    }
}
