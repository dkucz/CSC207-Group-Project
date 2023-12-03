package Workout.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScheduleView extends JFrame implements ActionListener, PropertyChangeListener {

    private JButton close;
    private String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private String[][] exercises = {
            {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
            {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
            {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
            {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
            {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
            {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
            {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"}
    };

    public ScheduleView() {


        setTitle("Exercise Schedule");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        close = new JButton("Close");
        buttonPanel.add(close);
        JPanel mainPanel = new JPanel(new GridLayout(6, 7, 5, 0));
        mainPanel.setSize(500, 400);

        for (String day : days) {
            mainPanel.add(createLabel(day));
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < days.length; j++) {
                mainPanel.add(createLabel(exercises[j][i]));
            }
        }

        add(mainPanel);
        add(buttonPanel, BorderLayout.SOUTH);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScheduleView schedule = new ScheduleView();
            schedule.setLocationRelativeTo(null);
            schedule.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
