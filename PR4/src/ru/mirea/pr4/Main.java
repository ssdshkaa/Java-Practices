package ru.mirea.pr4;

public class Main {
    public static void printFavoriteSeason(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }

    public static void main(String[] args) {
        // Пример перечисления Level
        Level level = Level.LOW;
        Level level1 = Level.HIGH;
        if (level == level1)
            System.out.println("равны");
        else
            System.out.println("не равны");

        for (Level l : Level.values()) {
            System.out.println(l + " " + l.getLevelCode());
        }

        // Задание 1. Времена года
        Season season = Season.SUMMER;
        printFavoriteSeason(season);
        for (Season s : Season.values()) {
            System.out.println(s + " " + s.getAverageTemperature() + " " + s.getDescription());
        }

        // Задание 2. Ателье
        Clothes[] clothes = {
                new TShirt(Size.M, 500, "белая"),
                new Pants(Size.S, 1200, "черные"),
                new Skirt(Size.XS, 900, "синяя"),
                new Tie(Size.L, 300, "красный")
        };
        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        atelier.dressMan(clothes);

        // Задание 4. Компьютер
        Computer computer = new Computer(Brand.ASUS,
                new Processor("Intel Core i5", 3000),
                new Memory(16), new Monitor(24));
        System.out.println(computer);

        // Задание 3. Интернет-магазин запускается из ShopMain.java
    }
}
