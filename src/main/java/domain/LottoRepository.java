package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {

    List<Lotto> lottoList = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }
}
