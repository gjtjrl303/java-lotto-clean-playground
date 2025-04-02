package domain;

import enums.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoShop {

    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoPurchase purchaseLottos(Money money, LottoCount manualCount, List<Lotto> manualLottos) {
        if (money.getPurchasedLottoCount() < manualCount.getLottoCount()) {
            throw new IllegalArgumentException("금액이 수동 로또 개수보다 부족합니다.");
        }
        LottoCount autoLottoCount = LottoCount.from(money.getPurchasedLottoCount() - manualCount.getLottoCount());
        List<Lotto> autoLottos = lottoMachine.generateLottos(autoLottoCount);

        List<Lotto> allLottos = new ArrayList<>(manualLottos);
        allLottos.addAll(autoLottos);

        return LottoPurchase.createLottoPurchase(money, manualCount, allLottos);
    }
}
