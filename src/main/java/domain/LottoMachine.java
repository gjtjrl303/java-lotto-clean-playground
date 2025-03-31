package domain;

import domain.numberGenerator.NumberGenerator;

import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final NumberGenerator numberGenerator;
    private final Lottos lottos;
    private Money money;


    public LottoMachine(NumberGenerator numberGenerator) {
        lottos = new Lottos();
        this.numberGenerator = numberGenerator;
    }

    public void inputMoney(Money money) {
        this.money = money;
    }

    public void generateLottos() {
        for (int i = 0; i < money.getPurchasedLottoCount(); i++) {
            Lotto lotto = createSingleLotto();
            saveLotto(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    private Lotto createSingleLotto() {
        List<Integer> numbers = numberGenerator.generateNumbers();
        Collections.sort(numbers);
        return Lotto.from(numbers);
    }

    private void saveLotto(Lotto lotto) {
        lottos.addLotto(lotto);
    }

    public int getLottoCount() {
        return (int) money.getPurchasedLottoCount();
    }

}
