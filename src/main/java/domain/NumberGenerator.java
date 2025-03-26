package domain;

import java.util.*;
import java.util.stream.Collectors;

public class NumberGenerator {

    private final List<Integer> numbers = new ArrayList<>();

    public NumberGenerator() {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> generateNumbers() {

        Collections.shuffle(numbers);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(this.numbers.get(i));
        }

        return numbers;
    }
}
