import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBagLayouts {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField txtUsername = new JTextField(15);
        JPasswordField pwdPassword = new JPasswordField(15);
        JButton btnSubmit = new JButton("Submit");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(lblUsername, gbc);

        gbc.gridx = 1;
        frame.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(lblPassword, gbc);

        gbc.gridx = 1;
        frame.add(pwdPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(btnSubmit, gbc);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                JOptionPane.showMessageDialog(frame, "Welcome, " + username + "!");
                JLabel lbl = new JLabel("Hello "+username);
                lbl.setForeground(Color.BLUE);
                gbc.gridx=0;
                gbc.gridy=3;
                frame.add(lbl,gbc);
                frame.revalidate();
//                frame.repaint();
            }
        });
        frame.setVisible(true);
    }
}
