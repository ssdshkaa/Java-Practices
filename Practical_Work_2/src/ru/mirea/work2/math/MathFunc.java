package ru.mirea.work2.math;
public class MathFunc implements MathCalculable {
    public double power(double value, int exponent) { return Math.pow(value, exponent); }
    public double complexModulus(double real, double imaginary) { return Math.sqrt(real * real + imaginary * imaginary); }
    public double circleLength(double radius) { return 2 * PI * radius; }
    public static void main(String[] args) {
        MathFunc math = new MathFunc();
        System.out.println(math.power(2, 3));
        System.out.println(math.complexModulus(3, 4));
        System.out.println(math.circleLength(5));
    }
}
