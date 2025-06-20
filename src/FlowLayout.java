import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowLayout {
        FlowLayout(){
            JFrame frame= new JFrame(". . . . . . . . . . . . . A simple event listener frame . . . . . . . . . . .");
            frame.setSize(1000,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBackground(Color.RED);
            frame.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 20));
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
            frame.add(comboBox);
            JRadioButton radioButton = new JRadioButton("Option A");
            frame.add(radioButton);
            JButton btnblue = new JButton("Blue");
            frame.add(btnblue);
            JButton btngreen = new JButton("Green");
            frame.add(btngreen);
            JButton btnpink = new JButton("Pink");
            frame.add(btnpink);
            JButton btnyellow = new JButton("Yellow");
            frame.add(btnyellow);
            JButton btnpurple = new JButton("Purple");
            frame.add(btnpurple);
            JButton btnred = new JButton("Red");
            frame.add(btnred);
            JLabel lbltext = new JLabel();
            lbltext.setText("I Am A Text");
            frame.add(lbltext);
            btnblue.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lbltext.setForeground(Color.WHITE);
//                frame.getContentPane().setBackground(Color.RED);
                    lbltext.setBackground(Color.BLUE);
                    lbltext.setOpaque(true);
                }
            });
            btngreen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lbltext.setBackground(Color.GREEN);
                    lbltext.setForeground(Color.BLACK);
                    lbltext.setOpaque(true);
                }
            });
            frame.setVisible(true);
        }
        }