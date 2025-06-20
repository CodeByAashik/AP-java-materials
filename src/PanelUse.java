import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;

public class PanelUse {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Using Panel");
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,2));
        JPanel panel1 = new JPanel();
        JLabel lblname = new JLabel();
        lblname.setText("Username : ");
        JLabel lblpassword = new JLabel();
        lblpassword.setText("Password : ");
        JTextField txtusername =new JTextField(15);
        JPasswordField pwdpassword = new JPasswordField(15);
        panel1.add(lblname);
        panel1.add(txtusername);
        panel1.add(lblpassword);
        panel1.add(pwdpassword);
        panel1.setLayout( new GridLayout(2,2));
        JPanel panel2 = new JPanel();
        JButton btnsubmit = new JButton("Submit");
        panel2.add(btnsubmit);
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }
}
