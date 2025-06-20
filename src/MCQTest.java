import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MCQTest {
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton, submitButton;
    private ButtonGroup group;
    private int currentQuestion = 0;
    private int correctAnswers = 0;
    private int attemptedQuestions = 0;
    private long startTime = 0, endTime = 0;
    private boolean testStarted = false;
    
    private List<Question> questions = new ArrayList<>();
    
    public MCQTest() {
        frame = new JFrame("DSA MCQ Test");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        questionLabel = new JLabel("", JLabel.CENTER);
        frame.add(questionLabel, BorderLayout.NORTH);
        
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        options = new JRadioButton[4];
        group = new ButtonGroup();
        
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
            optionsPanel.add(options[i]);
            options[i].addActionListener(e -> startTimer());
        }
        frame.add(optionsPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        nextButton = new JButton("Next");
        submitButton = new JButton("Submit");
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        nextButton.addActionListener(e -> nextQuestion(getSelectedIndex() != -1));
        submitButton.addActionListener(e -> submitTest());
        
        loadQuestions();
        displayQuestion();
        
        frame.setVisible(true);
    }
    
    private void loadQuestions() {
        questions.add(new Question("What is the time complexity of binary search?", new String[]{"O(N)", "O(N log N)", "O(log N)", "O(1)"}, 2));
        questions.add(new Question("Which data structure is used for implementing LRU cache?", new String[]{"Queue", "Stack", "HashMap and Doubly Linked List", "Heap"}, 2));
        questions.add(new Question("Which sorting algorithm is best for small arrays?", new String[]{"Merge Sort", "Quick Sort", "Insertion Sort", "Heap Sort"}, 2));
        // Add more questions up to 50
    }
    
    private void displayQuestion() {
        if (currentQuestion >= questions.size()) {
            submitTest();
            return;
        }
        
        Question q = questions.get(currentQuestion);
        questionLabel.setText((currentQuestion + 1) + ". " + q.getQuestion());
        
        for (int i = 0; i < 4; i++) {
            options[i].setText(q.getOptions()[i]);
            options[i].setSelected(false);
        }
        
        frame.revalidate();
        frame.repaint();
    }
    
    private void nextQuestion(boolean answered) {
        if (answered) {
            int selectedIndex = getSelectedIndex();
            if (selectedIndex == questions.get(currentQuestion).getCorrectOption()) {
                correctAnswers++;
            }
            attemptedQuestions++;
        }
        currentQuestion++;
        displayQuestion();
    }
    
    private int getSelectedIndex() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }
    
    private void submitTest() {
        endTime = System.currentTimeMillis();
        long timeTaken = (endTime - startTime) / 1000; // in seconds
        
        double accuracy = (attemptedQuestions == 0) ? 0 : ((double) correctAnswers / attemptedQuestions) * 100;
        
        JOptionPane.showMessageDialog(frame, "Test Completed!\n" +
                "Correct Answers: " + correctAnswers + " / " + questions.size() + "\n" +
                "Accuracy: " + String.format("%.2f", accuracy) + "%\n" +
                "Time Taken: " + timeTaken + " seconds");
        
        frame.dispose();
    }
    
    private void startTimer() {
        if (!testStarted) {
            startTime = System.currentTimeMillis();
            testStarted = true;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MCQTest::new);
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctOption;
    
    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
    
    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public int getCorrectOption() { return correctOption; }
}