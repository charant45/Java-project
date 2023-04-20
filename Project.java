import javax.swing.*;
import java.awt.*;

// movie quiz game
public class Project {
    static int correctScore = 0;
    static int incorrectScore = 0;
    // get questions
    static Question[] questions = new Question().getQuestions();
    static String correctAnswer = "";
    static JLabel correctLabel, incorrectLabel;
    static int questionCount = 0;
    static int totalQuestions = questions.length;

    // main method
    public static void main(String[] args) {
        // increase the count by 1
        questionCount++;

        if (questionCount == 1) {
            // display welcome message
            JOptionPane.showMessageDialog(null, "Welcome to Movie Quiz Game");

            // display a dialog box showing the rules of the game
            JOptionPane.showMessageDialog(null, "You will be given 10 questions to answer\n" +
                    "You will be given 4 options to choose from\n" +
                    "You will be awarded 1 point for each correct answer\n" +
                    "You will be deducted 1 point for each incorrect answer\n" +
                    "You will be awarded 0 points for each unattempted question\n" +
                    "At the end of the game, your total score will be displayed\n" +
                    "Good Luck!");
        }

        if (questionCount == totalQuestions + 1) {
            // show a dialong box showing calculating your result for 2 sec
            // then display the result
            JOptionPane.showMessageDialog(null, "Calculating your result...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // display the result
            JOptionPane.showMessageDialog(null, "You got " + correctScore + " out of " +
                    totalQuestions
                    + "\nYour score is " + (correctScore * 100 / totalQuestions) + "%");
            System.exit(0);
        }
        // create a JFrame and set a heading for the game
        JFrame frame = new JFrame("Movie Quiz");
        frame.setSize(1080, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // JPanel to display game header
        JPanel header = new JPanel();
        header.setBackground(Color.GRAY);
        JLabel heading = new JLabel("Welcome to Game");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        heading.setForeground(Color.decode("#00419e"));
        header.add(heading);
        frame.add(header, BorderLayout.NORTH);

        // footer JPanel to display game footer having correct and incorrect scores
        JPanel footer = new JPanel();
        footer.setBackground(Color.GRAY);
        correctLabel = new JLabel("Correct: " + correctScore);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 15));
        correctLabel.setBorder(BorderFactory.createEmptyBorder(10, 35, 10, 35));
        correctLabel.setForeground(Color.WHITE);

        incorrectLabel = new JLabel("Incorrect: " + incorrectScore);
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 18));
        incorrectLabel.setBorder(BorderFactory.createEmptyBorder(10, 35, 10, 35));
        incorrectLabel.setForeground(Color.WHITE);
        footer.add(correctLabel);
        footer.add(incorrectLabel);

        // game body
        JPanel body = new JPanel();
        body.setBackground(Color.DARK_GRAY);
        body.setLayout(new BorderLayout(12, 12));

        // display the question
        // create a label to display the question
        JLabel question = new JLabel(questions[questionCount - 1].getQues());
        question.setFont(new Font("Arial", Font.BOLD, 20));
        question.setForeground(Color.decode("#FFBF00"));
        question.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // align center
        question.setHorizontalAlignment(JLabel.CENTER);
        body.add(question, BorderLayout.NORTH);
        frame.add(body, BorderLayout.CENTER);

        // create 4 buttons inside a JPanel to display the options
        JPanel optionContainer = new JPanel();
        optionContainer.setBackground(Color.DARK_GRAY);
        optionContainer.setLayout(new BorderLayout());
        optionContainer.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        body.add(optionContainer, BorderLayout.CENTER);
        JPanel options = new JPanel();
        options.setBackground(Color.LIGHT_GRAY);
        options.setLayout(new GridLayout(2, 2, 25, 25));
        int i = 50;
        options.setBorder(BorderFactory.createEmptyBorder(i, i, i, i));

        // get the correct answer
        correctAnswer = questions[questionCount - 1].getAnswer();

        // get the wrong answers
        String[] wrongAnswers = questions[questionCount - 1].getOptions();

        // create 4 buttons
        JButton btn1 = new JButton(wrongAnswers[0] + "");
        btn1.setFont(new Font("Arial", Font.PLAIN, 20));
        btn1.setBackground(Color.WHITE);
        btn1.setForeground(Color.BLACK);
        btn1.setFocusable(false);
        btn1.addActionListener(e -> {
            // check if the answer is correct
            if (btn1.getText().equals(correctAnswer)) {
                correctScore++;
                correctLabel.setText("Correct: " + correctScore);

            } else {
                incorrectScore++;
                incorrectLabel.setText("Incorrect: " + incorrectScore);
            }
            // call the main method again to generate a new question
            main(null);
            // close the current frame
            frame.dispose();
        });

        JButton btn2 = new JButton(wrongAnswers[1] + "");
        btn2.setFont(new Font("Arial", Font.PLAIN, 20));
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(Color.BLACK);
        btn2.setFocusable(false);
        btn2.addActionListener(e -> {
            // check if the answer is correct
            if (btn2.getText().equals(correctAnswer)) {
                correctScore++;
                correctLabel.setText("Correct: " + correctScore);

            } else {
                incorrectScore++;
                incorrectLabel.setText("Incorrect: " + incorrectScore);
            }
            // call the main method again to generate a new question
            main(null);
            // close the current frame
            frame.dispose();
        });

        JButton btn3 = new JButton(wrongAnswers[2] + "");
        btn3.setFont(new Font("Arial", Font.PLAIN, 20));
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(Color.BLACK);
        btn3.setFocusable(false);
        btn3.addActionListener(e -> {
            // check if the answer is correct
            if (btn3.getText().equals(correctAnswer)) {
                correctScore++;
                correctLabel.setText("Correct: " + correctScore);

            } else {
                incorrectScore++;
                incorrectLabel.setText("Incorrect: " + incorrectScore);
            }
            // call the main method again to generate a new question
            main(null);
            // close the current frame
            frame.dispose();
        });

        JButton btn4 = new JButton(correctAnswer + "");
        btn4.setFont(new Font("Arial", Font.PLAIN, 20));
        btn4.setBackground(Color.WHITE);
        btn4.setForeground(Color.BLACK);
        btn4.setFocusable(false);
        btn4.addActionListener(e -> {
            // check if the answer is correct
            if (btn4.getText().equals(correctAnswer)) {
                correctScore++;
                correctLabel.setText("Correct: " + correctScore);

            } else {
                incorrectScore++;
                incorrectLabel.setText("Incorrect: " + incorrectScore);
            }
            // call the main method again to generate a new question
            main(null);
            // close the current frame
            frame.dispose();
        });

        // add buttons to the JPanel
        options.add(btn1);
        options.add(btn2);
        options.add(btn3);
        options.add(btn4);

        optionContainer.add(options, BorderLayout.CENTER);
        // add the JPanel to the body
        body.add(optionContainer, BorderLayout.CENTER);

        // add the footer to the frame
        frame.add(footer, BorderLayout.SOUTH);

        // make the frame visible
        frame.setVisible(true);
    }
}