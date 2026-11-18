package ru.mirea.work2.api;
import java.util.Date;
import java.util.Random;
import java.util.GregorianCalendar;
public class DateRandomCalendarDemo {
    public static void main(String[] args) {
        Date date = new Date();
        long[] values = {10000,100000,1000000,10000000,100000000,1000000000,10000000000L,100000000000L};
        for (long value : values) { date.setTime(value); System.out.println(date.toString()); }
        Random random = new Random(1000);
        for (int i = 0; i < 50; i++) System.out.print(random.nextInt(100) + " ");
        System.out.println();
        GregorianCalendar calendar = new GregorianCalendar(); show(calendar);
        calendar.setTimeInMillis(1234567898765L); show(calendar);
    }
    private static void show(GregorianCalendar c) { System.out.println(c.get(GregorianCalendar.YEAR) + "-" + (c.get(GregorianCalendar.MONTH)+1) + "-" + c.get(GregorianCalendar.DAY_OF_MONTH)); }
}
