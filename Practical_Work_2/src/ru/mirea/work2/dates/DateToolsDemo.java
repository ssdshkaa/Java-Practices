package ru.mirea.work2.dates;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import ru.mirea.pr2.Student;

public class DateToolsDemo {
    private static final Scanner in = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.uuuu")
            .withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm")
            .withResolverStyle(ResolverStyle.STRICT);

    public static void main(String[] args) {
        System.out.print("Дата получения задания (dd.MM.yyyy): ");
        LocalDate receivedDate = LocalDate.parse(in.nextLine(), DATE_FORMAT);
        System.out.print("Время получения задания (HH:mm): ");
        LocalTime receivedTime = LocalTime.parse(in.nextLine(), TIME_FORMAT);
        Date received = Date.from(LocalDateTime.of(receivedDate, receivedTime)
                .atZone(ZoneId.systemDefault()).toInstant());
        Date submitted = new Date();
        System.out.println("Разработчик: Соломатников");
        System.out.println("Получено: " + received + "; дата и время сдачи: " + submitted);

        System.out.print("Введите календарную дату для сравнения (dd.MM.yyyy): ");
        LocalDate entered = LocalDate.parse(in.nextLine(), DATE_FORMAT);
        int compare = entered.compareTo(LocalDate.now());
        System.out.println(compare < 0 ? "Прошлое" : compare > 0 ? "Будущее" : "Сегодня");

        System.out.print("Введите дату рождения студента (dd.MM.yyyy): ");
        LocalDate birthDate = LocalDate.parse(in.nextLine(), DATE_FORMAT);
        Date studentBirthDate = Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Student student = new Student("Студент", 5, studentBirthDate);
        System.out.println(student);
        student.printBirthDate();

        System.out.println("Введите год, месяц, день, часы и минуты:");
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        int hour = in.nextInt();
        int minute = in.nextInt();
        Calendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute);
        Date date = calendar.getTime();
        System.out.println("Date: " + date);
        System.out.println("Calendar: " + calendar.getTime());
    }
}
