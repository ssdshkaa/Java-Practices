package ru.mirea.work3.part3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task4ButtonCalculator extends JFrame implements ActionListener {
    private JTextField display = new JTextField("0");
    private double firstNumber;
    private String operation = "";
    private boolean newNumber = true;

    public Task4ButtonCalculator() {
        super("Кнопочный калькулятор");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("SansSerif", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);
        JPanel keys = new JPanel(new GridLayout(4, 4, 5, 5));
        keys.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        String[] labels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            button.addActionListener(this);
            keys.add(button);
        }
        add(keys, BorderLayout.CENTER);
        setSize(330, 330);
        setMinimumSize(new Dimension(280, 280));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String key = event.getActionCommand();
        if ("0123456789.".contains(key)) {
            if (newNumber) {
                display.setText(".".equals(key) ? "0." : key);
                newNumber = false;
            } else if (".".equals(key)) {
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
            } else if ("0".equals(display.getText())) {
                display.setText(key);
            } else {
                display.setText(display.getText() + key);
            }
            return;
        }
        if ("Ошибка".equals(display.getText())) {
            return;
        }
        try {
            double value = Double.parseDouble(display.getText());
            if (!operation.isEmpty() && !newNumber) {
                value = Arithmetic.calculate(firstNumber, value, operation);
                display.setText(Double.toString(value));
            }
            firstNumber = value;
            operation = "=".equals(key) ? "" : key;
            newNumber = true;
        } catch (IllegalArgumentException exception) {
            display.setText("Ошибка");
            operation = "";
            newNumber = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task4ButtonCalculator().setVisible(true);
            }
        });
    }
}
