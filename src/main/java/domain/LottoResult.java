package domain;

import enums.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> resultByRank;
    private final LottoWinningNumbers winningNumbers;
    private final List<Lotto> lottos;

    public LottoResult(LottoWinningNumbers winningNumbers, List<Lotto> lottos) {
        resultByRank = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            resultByRank.put(lottoRank, 0);
        }
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;

        calculateMatchCount();
    }

    public Double calculateProfitRate() {
        Double totalPrize = calculatePrize();
        return totalPrize / (lottos.size() * 1000);
    }

    public Map<LottoRank, Integer> getResultByRank() {
        return resultByRank;
    }

    private void calculateMatchCount() {
        for (Lotto lotto : lottos) {
            calculateSingleLottoMatchCount(lotto);
        }
    }

    private void calculateSingleLottoMatchCount(Lotto lotto) {
        LottoRank lottoRank = LottoRank.from(winningNumbers.matchCount(lotto));
        resultByRank.put(lottoRank, resultByRank.get(lottoRank) + 1);
    }

    private Double calculatePrize() {
        Double totalPrize = 0.0;

        for (Map.Entry<LottoRank, Integer> matchCount : resultByRank.entrySet()) {
            totalPrize += matchCount.getKey().getPrize() * matchCount.getValue();
        }
        return totalPrize;
    }
}
