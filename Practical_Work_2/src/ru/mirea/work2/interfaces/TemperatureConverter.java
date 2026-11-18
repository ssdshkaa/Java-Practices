package ru.mirea.work2.interfaces;

public class TemperatureConverter {
    private final Convertable kelvinConverter = new CelsiusToKelvinConverter();
    private final Convertable fahrenheitConverter = new CelsiusToFahrenheitConverter();

    public double toKelvin(double celsius) {
        return kelvinConverter.convert(celsius);
    }

    public double toFahrenheit(double celsius) {
        return fahrenheitConverter.convert(celsius);
    }
}
