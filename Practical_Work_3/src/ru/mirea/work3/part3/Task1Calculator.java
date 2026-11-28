package ru.mirea.work3.part3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task1Calculator extends JFrame implements ActionListener {
    private JTextField first = new JTextField(12);
    private JTextField second = new JTextField(12);
    private JLabel result = new JLabel("Результат: ", JLabel.CENTER);

    public Task1Calculator() {
        super("Калькулятор двух чисел");
        JPanel fields = new JPanel(new GridLayout(2, 2, 8, 8));
        fields.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        fields.add(new JLabel("Первое число"));
        fields.add(first);
        fields.add(new JLabel("Второе число"));
        fields.add(second);
        add(fields, BorderLayout.NORTH);
        JPanel buttons = new JPanel();
        String[] operations = {"+", "-", "*", "/"};
        for (int i = 0; i < operations.length; i++) {
            JButton button = new JButton(operations[i]);
            button.addActionListener(this);
            buttons.add(button);
        }
        add(buttons, BorderLayout.CENTER);
        add(result, BorderLayout.SOUTH);
        setSize(440, 210);
        setMinimumSize(new Dimension(410, 200));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double a = Double.parseDouble(first.getText().trim());
            double b = Double.parseDouble(second.getText().trim());
            result.setText("Результат: " + Arithmetic.calculate(a, b, event.getActionCommand()));
        } catch (NumberFormatException exception) {
            result.setText("Введите два числа");
        } catch (IllegalArgumentException exception) {
            result.setText(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task1Calculator().setVisible(true);
            }
        });
    }
}
