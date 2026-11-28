package ru.mirea.work3.part1;

import java.awt.event.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Task4FrameAnimation extends JFrame {
    private ImageIcon[] frames = new ImageIcon[6];
    private int frameIndex;
    private JLabel picture = new JLabel();
    private Timer timer;

    public Task4FrameAnimation(File directory) throws IOException {
        super("Покадровая анимация");
        int width = 0;
        int height = 0;
        for (int i = 0; i < frames.length; i++) {
            File file = new File(directory, "frame" + (i + 1) + ".png");
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                throw new IOException("Неподдерживаемый кадр: " + file);
            }
            frames[i] = new ImageIcon(image);
            width = Math.max(width, image.getWidth());
            height = Math.max(height, image.getHeight());
        }
        picture.setIcon(frames[0]);
        picture.setPreferredSize(new Dimension(width, height));
        add(picture);
        timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frameIndex = (frameIndex + 1) % frames.length;
                picture.setIcon(frames[frameIndex]);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent event) {
                timer.stop();
            }
        });
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        timer.start();
    }

    public static void main(String[] args) {
        final File directory = new File(args.length == 0 ? "resources/frames" : args[0]);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Task4FrameAnimation(directory).setVisible(true);
                } catch (IOException exception) {
                    System.err.println("Не удалось загрузить кадры: " + exception.getMessage());
                }
            }
        });
    }
}
