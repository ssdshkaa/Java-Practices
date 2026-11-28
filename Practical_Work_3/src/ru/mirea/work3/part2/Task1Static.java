package ru.mirea.work3.part2;

public class Task1Static {
    static class F {
        int i = 7;
        static String s = "Общее поле";

        void imethod() {
            System.out.println("Метод объекта");
        }

        static void smethod() {
            System.out.println("Метод класса");
        }
    }

    public static void main(String[] args) {
        F f = new F();
        System.out.println(f.i);
        System.out.println(f.s);
        f.imethod();
        f.smethod();

        // F.i и F.imethod() нельзя вызвать без объекта.
        System.out.println(F.s);
        F.smethod();
    }
}
