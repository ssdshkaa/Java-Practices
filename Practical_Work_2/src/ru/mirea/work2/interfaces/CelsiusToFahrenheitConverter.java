package ru.mirea.work2.interfaces;

public class CelsiusToFahrenheitConverter implements Convertable {
    @Override
    public double convert(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
