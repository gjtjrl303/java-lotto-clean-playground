package view;

import domain.Lotto;
import domain.LottoNumber;
import enums.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoView {

    final Scanner scanner = new Scanner(System.in);

    public int inputMoneyView() {
        System.out.println("구입금액을 입력해 주세요");
        int money = scanner.nextInt();
        return money;
    }

    public void printLottosView(List<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            printLotto(lottos.get(i));
        }
    }

    public String inputWinningNumbersView() {
        scanner.nextLine();
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
         return scanner.nextLine();

    }

    public void printLotto(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        System.out.println(lottoNumbers);

    }

    public void printLottoCount(Integer lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printResultByRanks(Map<LottoRank, Integer> resultByRank) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        for (LottoRank lottoRank : resultByRank.keySet()) {
            printSingleRankResult(resultByRank, lottoRank);
        }
    }

    private void printSingleRankResult(Map<LottoRank, Integer> resultByRank, LottoRank lottoRank) {
        if (!(lottoRank == LottoRank.NO_MATCH)) {
            System.out.println(lottoRank.getMatchCount() + "개 일치 (" + lottoRank.getPrize() + ")- " + resultByRank.get(lottoRank));
        }
    }

    public void printProfitRate(Double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
