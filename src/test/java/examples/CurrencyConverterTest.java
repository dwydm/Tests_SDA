package examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CurrencyConverterTest {

    @ParameterizedTest(name = "Converting {0}")
    @EnumSource(CurrencyConverter.class)
    void shouldConvertCurrency(CurrencyConverter converter) {
        double value = 10.0;
        double actual = converter.convert(value);
        assertThat(actual).isLessThan(value);
    }

    //include oznacza, że będzie użyty tylko ten enum, ktory jest obecny w name
    //podobnie, ale odwrotnie można użyć exclude
    @ParameterizedTest(name = "Converting {0}")
    @EnumSource(
            value = CurrencyConverter.class,
            names = {"PLN_TO_USD"},
            mode = EnumSource.Mode.INCLUDE)
    void shouldConvertCurrencies(CurrencyConverter converter) {
        double value = 10.0;
        double actual = converter.convert(value);
        assertThat(actual).isLessThan(value);
    }
}