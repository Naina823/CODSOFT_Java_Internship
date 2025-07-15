import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        String playAgain;

        do {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int guess = 0;
            System.out.println("Guess a number between 1 and 100 (Max 7 attempts):");

            while (guess != numberToGuess && attempts < 7) {
                System.out.print("Enter guess: ");
                guess = sc.nextInt();
              while( guess>100 || guess<1)
              {
                  System.out.println("WRONG INPUT!!");
                  System.out.println("Please guess a number between 1 to 100");
                  guess=sc.nextInt();
              }
                attempts++;

                if (guess-numberToGuess<-10)
                    System.out.println("Too low!");
                else if (guess-numberToGuess>10)
                    System.out.println("Too high!");
                    else if(guess-numberToGuess>-10&&guess-numberToGuess<0)
                    System.out.println("low but close");
                    else if(guess-numberToGuess<10&&guess-numberToGuess>0)
                    System.out.println("high but close");
                else
                    System.out.println("Correct! You guessed in " + attempts + " attempts.");
            }

            if (guess == numberToGuess) score++;
            else System.out.println("Out of attempts! The number was " + numberToGuess);
                  

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Your final score: " + score);
        sc.close();
    }
}