package controller;

import domain.*;
import domain.numberGenerator.LottoNumberGenerator;
import enums.LottoRank;
import service.LottoShop;
import utils.LottoNumberFormatter;
import view.LottoView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoShop lottoShop;
    private final LottoView lottoView;

    public LottoController() {
        lottoShop = new LottoShop(new LottoMachine(new LottoNumberGenerator()));
        lottoView = new LottoView();
    }

    public void inputMoney() {
        Integer amount = lottoView.inputMoneyView();
        Money money = new Money(amount);
        lottoShop.inputMoney(money);
    }

    public void printLottoCount() {
        int lottoCount = lottoShop.getLottoCount();
        lottoView.printLottoCount(lottoCount);
    }

    public void createLottos() {
        lottoShop.generateLottos();
    }

    public void printLottos() {
        List<Lotto> lottos = lottoShop.getPurchasedLottos();
        lottoView.printLottosView(lottos);
    }

    public void inputWinningNumbers() {
        String winningNumberInput = lottoView.inputWinningNumbersView();
        List<Integer> winningNumbers = LottoNumberFormatter.parse(winningNumberInput);
        if (winningNumbers.size() != 6) {
            throw new IllegalStateException("숫자를 6개 입력하세요");
        }
        lottoShop.inputWinningNumbers(winningNumbers);
    }

    public void printResultByRank() {
        Map<LottoRank, Integer> resultByRank = lottoShop.getResultByRank();
        lottoView.printResultByRanks(resultByRank);
    }

    public void printProfitRate() {
        Double profitRate = lottoShop.getProfitRate();
        lottoView.printProfitRate(profitRate);
    }
}
