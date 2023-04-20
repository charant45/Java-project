import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Question {
    // instance variables
    String ques;
    // array to store the options
    String[] options = new String[4];
    // correct answer
    String answer;

    // constructor
    public Question(String ques, String[] options, String answer) {
        this.ques = ques;
        this.options = options;
        this.answer = answer;
    }

    // default constructor
    public Question() {
    }

    // getters
    public String getQues() {
        return ques;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public String toString() {
        return "Question: " + ques + " Options: " + Arrays.toString(options) + " Answer: " + answer + "\n";
    }

    // main method
    public Question[] getQuestions() {
        try {
            // create a file object
            File file = new File("questions.txt");

            // create a scanner object
            Scanner sc = new Scanner(file);

            // read the first line
            int numOfQuestions = sc.nextInt();
            // create an array of questions
            Question[] questions = new Question[numOfQuestions];
            // read the rest of the file
            // read the question
            // read the options
            // read the answer
            // create a question object
            // add the question object to the array
            // repeat the above steps until the end of the file
            sc.nextLine();
            for (int i = 0; i < numOfQuestions; i++) {
                String ques = sc.nextLine();
                String[] options = new String[4];
                for (int j = 0; j < 4; j++) {
                    options[j] = sc.nextLine();
                }
                String answer = sc.nextLine();
                Question q = new Question(ques, options, answer);
                questions[i] = q;
            }
            // close the scanner
            sc.close();
            return questions;
        } catch (Exception e) {
            System.out.println("inside getQuestions");
            System.out.println(e);
        }
        return null;
    }

    // count the number of questions
    // first line of the file contains the number of questions
    public static int countQuestions() {
        try {
            // create a file object
            File file = new File("questions.txt");

            // create a scanner object
            Scanner sc = new Scanner(file);

            // read the first line
            int numOfQuestions = sc.nextInt();
            // close the scanner
            sc.close();
            return numOfQuestions;
        } catch (Exception e) {
            System.out.println("inside countQuestions");
            System.out.println(e);
        }
        return 0;

    }

    public static void main(String[] args) {
        Question[] questions = new Question().getQuestions();
        System.out.println(questions.length);
        for (Question q : questions) {
            System.out.println(q);
        }
    }

}
