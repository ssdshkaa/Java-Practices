package ru.mirea.work2.shop;
import java.util.Scanner;
import ru.mirea.pr4.*;
public class ScannerComputerInput implements ComputerInput {
    private final Scanner scanner;
    public ScannerComputerInput(Scanner scanner) {
        this.scanner = scanner;
    }
    public Computer readComputer() {
        System.out.println("Марки: ASUS, ACER, LENOVO, HP");
        Brand brand = Brand.valueOf(scanner.nextLine().trim().toUpperCase());
        System.out.print("Модель процессора: "); String model = scanner.nextLine();
        System.out.print("Частота (МГц): "); int frequency = Integer.parseInt(scanner.nextLine());
        System.out.print("Память (ГБ): "); int memory = Integer.parseInt(scanner.nextLine());
        System.out.print("Диагональ монитора: "); double diagonal = Double.parseDouble(scanner.nextLine());
        return new Computer(brand, new Processor(model, frequency), new Memory(memory), new Monitor(diagonal));
    }
}
