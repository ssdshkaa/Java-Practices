import ru.mirea.work3.part2.*;
import ru.mirea.work3.part3.Arithmetic;
import ru.mirea.work3.part3.Task3TextEditor;
import ru.mirea.pr3.Circle;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Work3Checks {
    public static void main(String[] args) throws Exception {
        check(Arithmetic.calculate(12, 24, "+") == 36, "addition");
        check(Arithmetic.calculate(12, 24, "-") == -12, "subtraction");
        check(Arithmetic.calculate(12, 24, "*") == 288, "multiplication");
        check(Arithmetic.calculate(24, 12, "/") == 2, "division");
        check(Arithmetic.calculate(-1.5, 0.25, "+") == -1.25, "decimals");
        try {
            Arithmetic.calculate(1, 0, "/");
            throw new AssertionError("division by zero accepted");
        } catch (IllegalArgumentException expected) {
            check(!expected.getMessage().isEmpty(), "error message");
        }
        int[][] cases = {{}, {1}, {3, -2, 3, 0}, {5, 4, 3, 2, 1}};
        for (int[] values : cases) {
            int[] expected = values.clone();
            Arrays.sort(expected);
            Task7SelectionSort.selectionSort(values);
            check(Arrays.equals(values, expected), "selection sort");
        }
        Circle[] circles = {new Circle(2), new Circle(5), new Circle(1)};
        check(Task5CircleArray.findLargest(circles) == circles[1], "largest circle");
        StopWatch watch = new StopWatch();
        check(watch.getStartTime() > 0, "constructor time");
        watch.start();
        Thread.sleep(30);
        watch.stop();
        check(watch.getElapsedTime() == watch.getEndTime() - watch.getStartTime(), "elapsed difference");
        check(watch.getElapsedTime() >= 20, "elapsed duration");
        Path directory = Files.createTempDirectory("pr3-save-");
        Path target = directory.resolve("text.txt");
        try {
            Files.writeString(target, "Старый текст");
            Task3TextEditor.saveTo(target.toFile(), "Новый текст\nJava");
            check(Files.readString(target).equals("Новый текст\nJava"), "replace UTF-8 file");
            try {
                Task3TextEditor.saveTo(directory.toFile(), "Недопустимая цель");
                throw new AssertionError("directory accepted as file");
            } catch (IOException expected) {
                check(Files.readString(target).equals("Новый текст\nJava"), "failed save preserves files");
            }
            check(directory.toFile().list().length == 1, "temporary save file removed");
        } finally {
            Files.deleteIfExists(target);
            Files.deleteIfExists(directory);
        }
        System.out.println("Work3Checks: OK");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
