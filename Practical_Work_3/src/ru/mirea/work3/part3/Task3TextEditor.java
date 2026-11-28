package ru.mirea.work3.part3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.*;

public class Task3TextEditor extends JFrame implements ActionListener {
    private JTextArea text = new JTextArea(15, 45);

    public Task3TextEditor() {
        super("Текстовый редактор");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu editMenu = new JMenu("Правка");
        JMenu helpMenu = new JMenu("Справка");

        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem("Выйти");
        JMenuItem copy = new JMenuItem("Копировать");
        JMenuItem cut = new JMenuItem("Вырезать");
        JMenuItem paste = new JMenuItem("Вставить");
        JMenuItem about = new JMenuItem("Информация о программе");

        JMenuItem[] commands = {save, exit, copy, cut, paste, about};
        for (JMenuItem command : commands) {
            command.addActionListener(this);
        }
        fileMenu.add(save);
        fileMenu.add(exit);
        editMenu.add(copy);
        editMenu.add(cut);
        editMenu.add(paste);
        helpMenu.add(about);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        JPanel buttons = new JPanel();
        String[] labels = {"Очистить", "Добавить текст"};
        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            button.addActionListener(this);
            buttons.add(button);
        }
        add(buttons, BorderLayout.NORTH);
        text.setMargin(new Insets(6, 6, 6, 6));
        add(new JScrollPane(text), BorderLayout.CENTER);
        pack();
        setMinimumSize(new Dimension(400, 250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void saveTo(File file, String content) throws IOException {
        Files.writeString(file.toPath(), content, StandardCharsets.UTF_8);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Сохранить":
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    if (file.exists() && JOptionPane.showConfirmDialog(this, "Заменить существующий файл?",
                            "Сохранение", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                        return;
                    }
                    try {
                        saveTo(file, text.getText());
                    } catch (IOException exception) {
                        JOptionPane.showMessageDialog(this, "Не удалось сохранить файл: " + exception.getMessage(),
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Выйти":
                dispose();
                break;
            case "Копировать":
                text.copy();
                break;
            case "Вырезать":
                text.cut();
                break;
            case "Вставить":
                text.paste();
                break;
            case "Очистить":
                text.setText("");
                break;
            case "Добавить текст":
                String addition = JOptionPane.showInputDialog(this, "Введите текст");
                if (addition != null) {
                    text.append(addition);
                }
                break;
            case "Информация о программе":
                JOptionPane.showMessageDialog(this, "Учебный текстовый редактор. Практическая работа №3.");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task3TextEditor().setVisible(true);
            }
        });
    }
}
