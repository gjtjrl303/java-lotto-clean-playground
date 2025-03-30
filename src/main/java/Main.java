import controller.LottoController;
import domain.LottoMachine;
import domain.numberGenerator.LottoNumberGenerator;
import domain.numberGenerator.NumberGenerator;
import domain.lottoShop;
import view.LottoView;

public class Main {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(numberGenerator);
        lottoShop lottoShop = new lottoShop(lottoMachine);

        LottoController lottoController = new LottoController(lottoShop, new LottoView());

        lottoController.inputMoney();
        lottoController.printLottoCount();
        lottoController.createLottos();
        lottoController.printLottos();
        lottoController.inputWinningNumbers();
        lottoController.printResultByRank();
        lottoController.printProfitRate();
    }

}
