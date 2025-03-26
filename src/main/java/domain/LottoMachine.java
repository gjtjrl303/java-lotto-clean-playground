package domain;

import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final Integer PRICE_PER_LOTTO = 1000;

    private final NumberGenerator numberGenerator;
    private final LottoRepository lottoRepository;
    private Integer lottoCount;


    public LottoMachine() {
        lottoRepository = new LottoRepository();
        numberGenerator = new NumberGenerator();
    }

    public void inputMoney(Integer money) {
        validateMoney(money);
        lottoCount = money / PRICE_PER_LOTTO;
    }

    private void validateMoney(Integer money) {
        if (money < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("티켓은 1000원 입니다");
        }

        if ((money %= PRICE_PER_LOTTO) != 0) {
            throw new IllegalArgumentException("티켓은 한장은 1000원 입니다");
        }
    }

    public void generateLottos() {
        for (int i = 0; i < lottoCount; i++) {
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
        return lottoCount;
    }
}
