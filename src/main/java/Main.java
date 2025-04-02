import controller.LottoController;
import domain.Lotto;
import domain.LottoMachine;
import domain.LottoNumber;
import domain.numberGenerator.LottoNumberGenerator;
import domain.numberGenerator.NumberGenerator;
import domain.LottoShop;
import view.LottoView;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(numberGenerator);
        LottoShop lottoShop = new LottoShop(lottoMachine);

        LottoController lottoController = new LottoController(lottoShop, new LottoView());

        lottoController.run();
    }

}
