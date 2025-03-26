package domain;

import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int PRICE_PER_LOTTO = 1000;

    private final LottoNumberGenerator numberGenerator;
    private final LottoRepository lottoRepository;
    private Money money;


    public LottoMachine() {
        lottoRepository = new LottoRepository();
        numberGenerator = new LottoNumberGenerator();
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
        return lottoRepository.getLottoList();
    }

    private Lotto createSingleLotto() {
        List<Integer> numbers = numberGenerator.generateNumbers();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void saveLotto(Lotto lotto) {
        lottoRepository.addLotto(lotto);
    }

    public int getLottoCount() {
        return (int) money.getPurchasedLottoCount();
    }

}
