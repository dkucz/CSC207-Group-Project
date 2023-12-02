package Workout.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScheduleView extends JFrame implements ActionListener, PropertyChangeListener {

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


        JPanel mainPanel = new JPanel(new GridLayout(6, 7, 5, 0));
        mainPanel.setSize(500, 400);


        // Adding day labels
        for (String day : days) {
            mainPanel.add(createLabel(day));
        }

        // Adding exercise labels
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < days.length; j++) {
                mainPanel.add(createLabel(exercises[j][i]));
            }
        }

        add(mainPanel);
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




//    private void initComponents() {
//
//        JScrollPane jScrollPane1 = new JScrollPane();
//        JTable jTable1 = new JTable();
//        JLabel jLabel1 = new JLabel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
//                        {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
//                        {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
//                        {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
//                        {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
//                        {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"},
//                        {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5"}
//                },
//                new String [] {
//                        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
//                }
//        ) {
//            Class[] types = new Class [] {
//                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
//        jScrollPane1.setViewportView(jTable1);
//
//        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//        jLabel1.setText("Workout Schedule");
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addGap(306, 306, 306)
//                                                .addComponent(jLabel1)))
//                                .addContainerGap(158, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                .addContainerGap(51, Short.MAX_VALUE)
//                                .addComponent(jLabel1)
//                                .addGap(36, 36, 36)
//                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(35, 35, 35))
//        );
//
//        pack();
//    }// </editor-fold>
}
