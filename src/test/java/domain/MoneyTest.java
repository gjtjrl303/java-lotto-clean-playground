package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("로또를_한장도_구입할수없으면_예외를_던진다")
    void 로또를_한장도_구입할수없으면_예외를_던진다() {

        Assertions.assertThatThrownBy(() -> new Money(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또별_가격에_맞지않으면_예외를_던진다")
    void 로또별_가격에_맞지않으면_예외를_던진다() {

        Assertions.assertThatThrownBy(() -> new Money(2001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}