package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    List<Lotto> Lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        Lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(Lottos);
    }
}
