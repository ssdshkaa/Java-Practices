package ru.mirea.work2.shop;

import java.util.Scanner;
import ru.mirea.pr4.Computer;

public class ComputerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        ComputerInput input = new ScannerComputerInput(scanner);

        while (true) {
            System.out.println("1 Добавить, 2 Удалить, 3 Найти, 4 Список, 0 Выход");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                break;
            } else if (choice.equals("1")) {
                shop.addComputer(input.readComputer());
                System.out.println("Компьютер добавлен");
            } else if (choice.equals("2")) {
                showAll(shop);
                System.out.print("Номер компьютера: ");
                try {
                    int index = Integer.parseInt(scanner.nextLine());
                    if (shop.removeComputer(index)) {
                        System.out.println("Компьютер удалён");
                    } else {
                        System.out.println("Нет компьютера с таким номером");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Введите номер компьютера цифрами");
                }
            } else if (choice.equals("3")) {
                System.out.print("Текст для поиска: ");
                Computer found = shop.findComputer(scanner.nextLine());
                if (found == null) {
                    System.out.println("Компьютер не найден");
                } else {
                    System.out.println(found);
                }
            } else if (choice.equals("4")) {
                showAll(shop);
            }
        }
    }

    private static void showAll(Shop shop) {
        if (shop.getComputerCount() == 0) {
            System.out.println("Список пуст");
            return;
        }
        for (int i = 0; i < shop.getComputerCount(); i++) {
            System.out.println(i + ": " + shop.getComputer(i));
        }
    }
}
