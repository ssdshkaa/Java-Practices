import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import ru.mirea.work3.part1.*;
import ru.mirea.work3.part3.*;

public class SwingChecks {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                try {
                    checkScoreboard();
                    checkTwoNumbers();
                    checkButtons();
                    checkCountries();
                    checkEditor();
                    JFrame image = new Task3ImageViewer(ImageIO.read(new File("resources/sample.png")));
                    showAndClose(image);
                    JFrame shapes = new Task2RandomShapes();
                    shapes.setVisible(true);
                    click(shapes, "Обновить");
                    shapes.setSize(250, 200);
                    shapes.validate();
                    showAndClose(shapes);
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        final Task4FrameAnimation[] animation = new Task4FrameAnimation[1];
        final CountDownLatch changed = new CountDownLatch(1);
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                try {
                    animation[0] = new Task4FrameAnimation(new File("resources/frames"));
                    animation[0].setVisible(true);
                    find(animation[0], JLabel.class, 0).addPropertyChangeListener("icon",
                            new PropertyChangeListener() {
                                @Override
                                public void propertyChange(PropertyChangeEvent event) {
                                    changed.countDown();
                                }
                            });
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        try {
            check(changed.await(2, TimeUnit.SECONDS), "animation changes frame");
        } finally {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    animation[0].dispatchEvent(new WindowEvent(animation[0], WindowEvent.WINDOW_CLOSING));
                }
            });
        }
        System.out.println("SwingChecks: OK");
    }

    private static void checkScoreboard() {
        JFrame window = new Task1FootballScoreboard();
        check(hasLabel(window, "Result: 0 X 0") && hasLabel(window, "Last Scorer: N/A")
                && hasLabel(window, "Winner: DRAW"), "initial score");
        click(window, "AC Milan");
        check(hasLabel(window, "Winner: AC Milan"), "Milan leads");
        click(window, "Real Madrid");
        check(hasLabel(window, "Winner: DRAW"), "draw");
        click(window, "Real Madrid");
        click(window, "Real Madrid");
        check(hasLabel(window, "Result: 1 X 3") && hasLabel(window, "Winner: Real Madrid")
                && hasLabel(window, "Last Scorer: Real Madrid"), "Madrid leads");
        showAndClose(window);
    }

    private static void checkTwoNumbers() {
        JFrame window = new Task1Calculator();
        JTextField first = find(window, JTextField.class, 0);
        JTextField second = find(window, JTextField.class, 1);
        String[] operations = {"+", "-", "*", "/"};
        String[] expected = {"36.0", "-12.0", "288.0", "0.5"};
        for (int i = 0; i < operations.length; i++) {
            first.setText("12");
            second.setText("24");
            click(window, operations[i]);
            check(hasLabel(window, "Результат: " + expected[i]), "two fields " + operations[i]);
        }
        first.setText("24");
        second.setText("12");
        click(window, "/");
        check(hasLabel(window, "Результат: 2.0"), "24 / 12");
        first.setText("-1.5");
        second.setText("0.25");
        click(window, "+");
        check(hasLabel(window, "Результат: -1.25"), "signed decimals");
        second.setText("0");
        click(window, "/");
        check(hasLabel(window, "Деление на ноль невозможно"), "zero error");
        first.setText("");
        click(window, "+");
        check(hasLabel(window, "Введите два числа"), "empty input");
        first.setText("abc");
        click(window, "+");
        check(hasLabel(window, "Введите два числа"), "text input");
        first.setText("1");
        click(window, "+");
        check(hasLabel(window, "Результат: 1.0"), "recovery");
        showAndClose(window);
    }

    private static void checkButtons() {
        JFrame window = new Task4ButtonCalculator();
        String[][] cases = {{"12+24=", "36.0"}, {"12-24=", "-12.0"}, {"12*24=", "288.0"},
                {"24/12=", "2.0"}, {"1.5+0.25=", "1.75"}, {"1..5+0=", "1.5"},
                {"8/0=", "Ошибка"}, {"2+3+4=", "9.0"}, {"5-8=", "-3.0"}};
        for (String[] test : cases) {
            for (char key : test[0].toCharArray()) {
                click(window, String.valueOf(key));
            }
            check(find(window, JTextField.class, 0).getText().equals(test[1]), "buttons " + test[0]);
        }
        click(window, "+");
        click(window, "2");
        click(window, "=");
        check(find(window, JTextField.class, 0).getText().equals("-1.0"), "continue from result");
        showAndClose(window);
    }

    private static void checkCountries() {
        JFrame window = new Task2Countries();
        JComboBox<?> countries = find(window, JComboBox.class, 0);
        String[] capitals = {"Канберра", "Пекин", "Лондон", "Москва"};
        for (int i = 0; i < capitals.length; i++) {
            countries.setSelectedIndex(i);
            check(find(window, JTextArea.class, 0).getText().contains(capitals[i]), "country " + i);
        }
        showAndClose(window);
    }

    private static void checkEditor() throws Exception {
        Task3TextEditor window = new Task3TextEditor();
        JTextArea text = find(window, JTextArea.class, 0);
        text.setText("Проверка UTF-8\nJava");
        File file = File.createTempFile("pr3-editor-", ".txt");
        try {
            Task3TextEditor.saveTo(file, text.getText());
            check(Files.readString(file.toPath()).equals(text.getText()), "saved UTF-8");
        } finally {
            Files.deleteIfExists(file.toPath());
        }
        text.selectAll();
        window.getJMenuBar().getMenu(1).getItem(0).doClick();
        text.setCaretPosition(text.getText().length());
        window.getJMenuBar().getMenu(1).getItem(2).doClick();
        check(text.getText().equals("Проверка UTF-8\nJavaПроверка UTF-8\nJava"), "copy paste");
        text.selectAll();
        window.getJMenuBar().getMenu(1).getItem(1).doClick();
        check(text.getText().isEmpty(), "cut");
        text.setText("Очистить");
        click(window, "Очистить");
        check(text.getText().isEmpty(), "clear button");
        showAndClose(window);
    }

    private static void showAndClose(JFrame window) {
        window.setVisible(true);
        check(window.isShowing(), "visible " + window.getTitle());
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        check(!window.isDisplayable(), "closed " + window.getTitle());
    }

    private static void click(Container parent, String label) {
        for (Component component : parent.getComponents()) {
            if (component instanceof JButton && ((JButton) component).getText().equals(label)) {
                ((JButton) component).doClick();
                return;
            }
            if (component instanceof Container && containsButton((Container) component, label)) {
                click((Container) component, label);
                return;
            }
        }
        throw new AssertionError("Button missing: " + label);
    }

    private static boolean containsButton(Container parent, String label) {
        for (Component component : parent.getComponents()) {
            if (component instanceof JButton && ((JButton) component).getText().equals(label)) {
                return true;
            }
            if (component instanceof Container && containsButton((Container) component, label)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLabel(Container parent, String text) {
        for (Component component : parent.getComponents()) {
            if (component instanceof JLabel && ((JLabel) component).getText().equals(text)) {
                return true;
            }
            if (component instanceof Container && hasLabel((Container) component, text)) {
                return true;
            }
        }
        return false;
    }

    private static <T> T find(Container parent, Class<T> type, int index) {
        java.util.List<T> matches = new java.util.ArrayList<T>();
        collect(parent, type, matches);
        return matches.get(index);
    }

    private static <T> void collect(Container parent, Class<T> type, java.util.List<T> matches) {
        for (Component component : parent.getComponents()) {
            if (type.isInstance(component)) {
                matches.add(type.cast(component));
            }
            if (component instanceof Container) {
                collect((Container) component, type, matches);
            }
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
