package ru.mirea.work2.interfaces;

public class CelsiusToKelvinConverter implements Convertable {
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}
