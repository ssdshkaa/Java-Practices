package ru.mirea.pr4;
import java.util.Scanner;
public class ShopMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Логин: ");
        String login = sc.nextLine();
        System.out.print("Пароль: ");
        String password = sc.nextLine();
        if (!login.equals("student") || !password.equals("1234")) {
            System.out.println("Неверный логин или пароль");
            return;
        }
        System.out.println("Вход выполнен");
        Product[] products = {
            new Product("Мышь", 800, Category.ELECTRONICS),
            new Product("Монитор", 9000, Category.ELECTRONICS),
            new Product("Футболка", 1000, Category.CLOTHES),
            new Product("Джинсы", 2500, Category.CLOTHES),
            new Product("Учебник Java", 700, Category.BOOKS)
        };
        Product[] basket = new Product[20];
        int basketCount = 0;
        int menu = -1;
        while (menu != 0) {
            System.out.println("1 - Каталоги, 2 - Товары каталога, 3 - В корзину, 4 - Купить, 0 - Выход");
            menu = sc.nextInt();
            if (menu == 1) {
                for (Category category : Category.values()) System.out.println(category);
            } else if (menu == 2) {
                System.out.println("Введите номер каталога: 1 ELECTRONICS, 2 CLOTHES, 3 BOOKS");
                int number = sc.nextInt();
                if (number >= 1 && number <= 3) {
                    Category category = Category.values()[number - 1];
                    for (int i = 0; i < products.length; i++) {
                        if (products[i].getCategory() == category) System.out.println((i + 1) + " - " + products[i]);
                    }
                }
            } else if (menu == 3) {
                for (int i = 0; i < products.length; i++) System.out.println((i + 1) + " - " + products[i]);
                System.out.print("Номер товара: ");
                int number = sc.nextInt();
                if (number >= 1 && number <= products.length && basketCount < basket.length) {
                    basket[basketCount] = products[number - 1];
                    basketCount++;
                    System.out.println("Добавлено в корзину");
                } else System.out.println("Неверный номер или корзина заполнена");
            } else if (menu == 4) {
                int total = 0;
                for (int i = 0; i < basketCount; i++) {
                    System.out.println(basket[i]);
                    total += basket[i].getPrice();
                }
                System.out.println("Покупка на сумму: " + total + " руб.");
                basketCount = 0;
            }
        }
    }
}
