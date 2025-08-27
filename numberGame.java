import java.util.Random;
import java.util.Scanner;

public class numberGame{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        String playAgain = "ye7s";

        while (playAgain.equals("yes")) {
            int randomNumber = rand.nextInt(100) + 1; // random number between 1-100
            int tryCount = 0;
            int maxTries = 10;
            boolean guessed = false;

            System.out.println("\n=== Number Guessing Game ===");
            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("You have " + maxTries + " tries to guess it.");

            while (tryCount < maxTries) {
                System.out.print("Enter your guess: ");
                int playerGuess = scan.nextInt();
                tryCount++;

                if (playerGuess == randomNumber) {
                    System.out.println("✅ Correct! You win!");
                    System.out.println("You took " + tryCount + " tries.");
                    score += (maxTries - tryCount + 1); // higher score if guessed earlier
                    guessed = true;
                    break;
                } else if (playerGuess > randomNumber) {
                    System.out.println("Too high! Tries left: " + (maxTries - tryCount));
                } else {
                    System.out.println("Too low! Tries left: " + (maxTries - tryCount));
                }
            }

            if (!guessed) {
                System.out.println("❌ Out of tries! The number was: " + randomNumber);
            }

            System.out.println("Current Score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scan.next().toLowerCase();
        }

        System.out.println("\nFinal Score: " + score);
        System.out.println("Thanks for playing! 🎮");
        scan.close();
    }
}