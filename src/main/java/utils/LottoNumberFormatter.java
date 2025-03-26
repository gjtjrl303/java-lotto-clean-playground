package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberFormatter {

    public static List<Integer> parse(String winningNumberList) {

        return Arrays.stream(winningNumberList.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
