package learning;
import java.util.Scanner;

public class whileGuess {
    public static void main() {
        int guess = 0;
        int secretNum = (int)(Math.random() * 11);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the secret number (you have 4 guesses): ");
        int input = sc.nextInt();
        while (!(secretNum == input) && guess < 3) {
            System.out.print("!WRONG! reEnter the secret number: ");
            input = sc.nextInt();
            guess = guess + 1;
        }
        if (guess > 3) {
            System.out.println("you ran out of guesses see you next time :D");
        }else {
        System.out.println("you guessed the secret number. it was: " + secretNum);
        }
    }
}
