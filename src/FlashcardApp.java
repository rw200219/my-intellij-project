import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashcardApp {
    private static List<String> questions = new ArrayList<>();  // Store questions
    private static List<String> answers = new ArrayList<>();    // Store answers
    private static Scanner scanner = new Scanner(System.in);    // Scanner instance for input
    private static int correctAnswers = 0;  // Track correct answers
    private static int incorrectAnswers = 0; // Track incorrect answers

    public static void main(String[] args) {
        System.out.println("Welcome to the Flashcard App!");
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Flashcard");
            System.out.println("2. Quiz Yourself");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFlashcard();
                    break;
                case 2:
                    quizYourself();
                    break;
                case 3:
                    running = false;
                    System.out.println("Thank you for using the Flashcard App!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addFlashcard() {
        System.out.print("Enter the question: ");
        String question = scanner.nextLine();  // Get the question from user
        System.out.print("Enter the answer: ");
        String answer = scanner.nextLine();    // Get the answer from user

        questions.add(question);  // Add question to the list
        answers.add(answer);      // Add answer to the list

        System.out.println("Flashcard added!");
    }

    public static void quizYourself() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question: " + questions.get(i));
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();  // Get user's answer

            if (userAnswer.equalsIgnoreCase(answers.get(i))) {
                System.out.println("Correct!");
                correctAnswers++;  // Increment correct answers
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers.get(i));
                incorrectAnswers++;  // Increment incorrect answers
            }
        }
        trackPerformance(); // Show performance after the quiz
    }

    public static void trackPerformance() {
        System.out.println("Performance Summary:");
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Incorrect answers: " + incorrectAnswers);
    }
}
