package ru.mirea.work3.part1;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Task3ImageViewer extends JFrame {
    public Task3ImageViewer(BufferedImage image) {
        super("Просмотр изображения");
        add(new JScrollPane(new JLabel(new ImageIcon(image))));
        setSize(640, 480);
        setMinimumSize(new Dimension(220, 180));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Укажите путь: Task3ImageViewer resources/sample.png");
            return;
        }
        File file = new File(args[0]);
        if (!file.isFile()) {
            System.err.println("Файл не найден: " + file);
            return;
        }
        try {
            final BufferedImage image = ImageIO.read(file);
            if (image == null) {
                System.err.println("Файл не является поддерживаемым изображением: " + file);
                return;
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Task3ImageViewer(image).setVisible(true);
                }
            });
        } catch (IOException exception) {
            System.err.println("Не удалось прочитать изображение: " + exception.getMessage());
        }
    }
}
