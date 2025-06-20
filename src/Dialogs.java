import javax.swing.*;

public class Dialogs {
    public static void main(String[] args) {
        // 1. Message Dialog - Simple message dikhane ke liye
        JOptionPane.showMessageDialog(null, "Hello! Yeh ek message dialog hai.", "Message", JOptionPane.INFORMATION_MESSAGE);

        // 2. Input Dialog - User se input lene ke liye
        String name = JOptionPane.showInputDialog(null, "Apna naam batao:", "Input", JOptionPane.QUESTION_MESSAGE);
        if (name != null) {
            JOptionPane.showMessageDialog(null, "Hi " + name + "!", "Welcome", JOptionPane.PLAIN_MESSAGE);
        }

        // 3. Confirm Dialog - Yes/No puchne ke liye
        int choice = JOptionPane.showConfirmDialog(null, "Kya tum Swing seekhna chahte ho?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Great choice!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Okay, no problem!", "Bye", JOptionPane.WARNING_MESSAGE);
        }
    }
}

