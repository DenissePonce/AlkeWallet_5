package utils;

public enum Currency {
    USD, EUR;

    public static double getConversionRate(Currency from, Currency to) {
        if (from == USD && to == EUR) {
            return 0.85;
        } else if (from == EUR && to == USD) {
            return 1.18;
        }
        return 1.0;
    }
}
