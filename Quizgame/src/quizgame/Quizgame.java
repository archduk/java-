package quizgame;

import java.util.Scanner;

public class Quizgame  {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize questions, options, and answers
        String[] questions = {
            "1. What is the capital of France?",
            "2. What is the largest planet in the Solar System?",
            "3. What does 'HTTP' stand for?",
            "4. Who wrote 'Romeo and Juliet'?",
            "5. What is the square root of 64?"
        };

        String[][] options = {
            {"A. Berlin", "B. Madrid", "C. Paris", "D. Rome"},
            {"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
            {"A. Hyper Text Transfer Protocol", "B. High Transmission Transport Protocol", "C. Home Text Transfer Protocol", "D. None of the above"},
            {"A. Charles Dickens", "B. William Shakespeare", "C. Jane Austen", "D. Mark Twain"},
            {"A. 6", "B. 8", "C. 10", "D. 12"}
        };

        char[] answers = {'C', 'C', 'A', 'B', 'B'};

        // Variable to track the score
        int score = 0;

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            // Display the question and options
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Prompt the user for an answer
            System.out.print("Your answer (A, B, C, or D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);
            // Validate input using if statements
            if (userAnswer < 'A' || userAnswer > 'D') {
                System.out.println("Invalid input! Please enter A, B, C, or D.");
                i--; // Repeat the current question
                continue;
            }

            // Check answer using a switch case
            switch (userAnswer) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    if (userAnswer == answers[i]) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Incorrect. The correct answer was " + answers[i] + ".");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

            System.out.println(); // Add a blank line for better readability
        }

        // Calculate and display the final score
        double percentage = ((double) score / questions.length) * 100;
        System.out.printf("You got %d out of %d questions correct.%n", score, questions.length);
        System.out.printf("Your final score is: %.2f%%%n", percentage);

        // Close the scanner
        scanner.close();
    }
}
