package controller;

import domain.*;
import enums.LottoRank;
import service.lottoService;
import utils.LottoNumberFormatter;
import view.LottoView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final lottoService lottoService;
    private final LottoView lottoView;

    public LottoController(lottoService lottoShop, LottoView lottoView) {
        this.lottoService = lottoShop;
        this.lottoView = lottoView;
    }

    public void inputMoney() {
        Integer amount = lottoView.inputMoneyView();
        Money money = new Money(amount);
        lottoService.inputMoney(money);
    }

    public void printLottoCount() {
        int lottoCount = lottoService.getLottoCount();
        lottoView.printLottoCount(lottoCount);
    }

    public void createLottos() {
        lottoService.generateLottos();
    }

    public void printLottos() {
        List<Lotto> lottos = lottoService.getPurchasedLottos();
        lottoView.printLottosView(lottos);
    }

    public void inputWinningNumbers() {
        String winningNumberInput = lottoView.inputWinningNumbersView();
        List<Integer> inputNumbers = LottoNumberFormatter.parse(winningNumberInput);
        if (inputNumbers.size() != 6) {
            throw new IllegalStateException("숫자를 6개 입력하세요");
        }
        lottoService.inputWinningNumbers(inputNumbers);
    }

    public void printResultByRank() {
        Map<LottoRank, Integer> resultByRank = lottoService.getResultByRank();
        lottoView.printResultByRanks(resultByRank);
    }

    public void printProfitRate() {
        Double profitRate = lottoService.getProfitRate();
        lottoView.printProfitRate(profitRate);
    }
}
