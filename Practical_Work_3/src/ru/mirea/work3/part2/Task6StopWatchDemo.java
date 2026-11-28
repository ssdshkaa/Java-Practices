package ru.mirea.work3.part2;

public class Task6StopWatchDemo {
    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        Thread.sleep(100); // Только консольный пример, не поток Swing.
        watch.stop();
        System.out.println("Начало: " + watch.getStartTime());
        System.out.println("Окончание: " + watch.getEndTime());
        System.out.println("Прошло: " + watch.getElapsedTime() + " мс");
    }
}
