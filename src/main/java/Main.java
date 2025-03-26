import controller.LottoController;

public class Main {

    public static void main(String[] args) {

        LottoController lottoController = new LottoController();

        lottoController.inputMoney();
        lottoController.printLottoCount();
        lottoController.createLottos();
        lottoController.printLottos();
        lottoController.inputWinningNumbers();
        lottoController.printResultByRank();
        lottoController.printProfitRate();
    }

}
