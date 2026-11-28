package ru.mirea.work3.part3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task2Countries extends JFrame {
    private String[] countries = {"Australia", "China", "England", "Russia"};
    private String[] descriptions = {
        "Australia\nСтолица: Канберра\nГосударство на материке Австралия.",
        "China\nСтолица: Пекин\nГосударство в Восточной Азии.",
        "England\nСтолица: Лондон\nЧасть Соединённого Королевства на острове Великобритания.",
        "Russia\nСтолица: Москва\nГосударство в Европе и Азии."
    };
    private JComboBox<String> selection = new JComboBox<String>(countries);
    private JTextArea information = new JTextArea(5, 30);

    public Task2Countries() {
        super("Выбор страны");
        information.setEditable(false);
        information.setLineWrap(true);
        information.setWrapStyleWord(true);
        information.setMargin(new Insets(10, 10, 10, 10));
        information.setText(descriptions[0]);
        selection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                information.setText(descriptions[selection.getSelectedIndex()]);
            }
        });
        add(selection, BorderLayout.NORTH);
        add(new JScrollPane(information), BorderLayout.CENTER);
        setSize(440, 230);
        setMinimumSize(new Dimension(300, 180));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task2Countries().setVisible(true);
            }
        });
    }
}
