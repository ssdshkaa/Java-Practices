package ru.mirea.work3.part1;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import ru.mirea.work3.part1.shapes.Shape;
import ru.mirea.work3.part1.shapes.Circle;
import ru.mirea.work3.part1.shapes.Rectangle;
import ru.mirea.work3.part1.shapes.Triangle;

public class Task2RandomShapes extends JFrame {
    private DrawingPanel drawing = new DrawingPanel();

    public Task2RandomShapes() {
        super("20 случайных фигур");
        add(drawing, BorderLayout.CENTER);
        JButton refresh = new JButton("Обновить");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                drawing.createShapes();
                drawing.repaint();
            }
        });
        add(refresh, BorderLayout.SOUTH);
        setSize(720, 560);
        setMinimumSize(new Dimension(250, 200));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    static class DrawingPanel extends JPanel {
        private Shape[] shapes = new Shape[20];
        private Random random = new Random();

        DrawingPanel() {
            setBackground(Color.WHITE);
            createShapes();
        }

        void createShapes() {
            for (int i = 0; i < shapes.length; i++) {
                int width = 30 + random.nextInt(80);
                int height = 30 + random.nextInt(80);
                int type = random.nextInt(3);
                if (i < 3) {
                    type = i;
                }
                if (type == 0) {
                    height = width;
                }
                int x = random.nextInt(700 - width + 1);
                int y = random.nextInt(450 - height + 1);
                Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                if (type == 0) {
                    shapes[i] = new Circle(color, x, y, width);
                } else if (type == 1) {
                    shapes[i] = new Rectangle(color, x, y, width, height);
                } else {
                    shapes[i] = new Triangle(color, x, y, width, height);
                }
            }
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            for (Shape shape : shapes) {
                shape.draw(graphics);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task2RandomShapes().setVisible(true);
            }
        });
    }
}
