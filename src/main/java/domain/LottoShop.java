package domain;

import enums.LottoRank;

import java.util.List;
import java.util.Map;

public class LottoShop {

    private final LottoMachine lottoMachine;
    private LottoWinningNumbers winningNumbers;
    private LottoResult lottoResult;

    public LottoShop() {
        lottoMachine = new LottoMachine();
    }

    public void inputWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new LottoWinningNumbers(winningNumbers);
    }

    public void inputMoney(Integer money) {
        lottoMachine.inputMoney(money);
    }

    public int getLottoCount() {
        return lottoMachine.getLottoCount();
    }

    public void generateLottos() {
        lottoMachine.generateLottos();
    }

    public List<Lotto> getPurchasedLottos() {
        return lottoMachine.getLottos();
    }

    public Map<LottoRank, Integer> getResultByRank() {
        List<Lotto> lottos = lottoMachine.getLottos();
        lottoResult = new LottoResult(winningNumbers, lottos);
        return lottoResult.getResultByRank();
    }

    public Double getProfitRate() {
        return lottoResult.calculateProfitRate();
    }
}
