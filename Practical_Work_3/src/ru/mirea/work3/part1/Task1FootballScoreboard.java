package ru.mirea.work3.part1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task1FootballScoreboard extends JFrame implements ActionListener {
    private int milanScore;
    private int madridScore;
    private JLabel result = new JLabel("Result: 0 X 0", JLabel.CENTER);
    private JLabel lastScorer = new JLabel("Last Scorer: N/A", JLabel.CENTER);
    private JLabel winner = new JLabel("Winner: DRAW", JLabel.CENTER);

    public Task1FootballScoreboard() {
        super("Футбольное табло");
        setLayout(new GridLayout(4, 1, 5, 5));
        JPanel buttons = new JPanel();
        JButton milan = new JButton("AC Milan");
        JButton madrid = new JButton("Real Madrid");
        milan.addActionListener(this);
        madrid.addActionListener(this);
        buttons.add(milan);
        buttons.add(madrid);
        add(buttons);
        add(result);
        add(lastScorer);
        add(winner);
        setSize(360, 230);
        setMinimumSize(new Dimension(320, 210));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String team = event.getActionCommand();
        if ("AC Milan".equals(team)) {
            milanScore++;
        } else {
            madridScore++;
        }
        result.setText("Result: " + milanScore + " X " + madridScore);
        lastScorer.setText("Last Scorer: " + team);
        String leader = "DRAW";
        if (milanScore > madridScore) {
            leader = "AC Milan";
        } else if (madridScore > milanScore) {
            leader = "Real Madrid";
        }
        winner.setText("Winner: " + leader);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task1FootballScoreboard().setVisible(true);
            }
        });
    }
}
