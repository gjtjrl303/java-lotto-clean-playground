package service;

import domain.*;
import domain.LottoWinningNumbers;
import enums.LottoRank;

import java.util.List;
import java.util.Map;

public class LottoShop {

    private final LottoMachine lottoMachine;
    private LottoWinningNumbers winningNumbers;
    private LottoResult lottoResult;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void inputWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new LottoWinningNumbers(winningNumbers);
    }

    public void inputMoney(Money money) {
        lottoMachine.inputMoney(money);
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

    public int getLottoCount() {
        return lottoMachine.getLottoCount();
    }
}
