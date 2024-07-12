package services;

public class CurrencyConverterService {

    private static final double USD_TO_EUR_RATE = 0.85;

    public double convertToEuros(double usd) {
        return usd * USD_TO_EUR_RATE;
    }
}
