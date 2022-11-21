package examples;

import java.util.function.Function;

public enum CurrencyConverter {
    PLN_TO_USD(pln -> 0.2 * pln),
    PLN_TO_EURO(pln -> 0.21 * pln);

    private final Function<Double, Double> converter;

    CurrencyConverter(Function<Double, Double> converter) {
        this.converter = converter;
    }

    public double convert(double value) {
        return converter.apply(value);
    }
}
