import java.util.Scanner;

public class guess {
    public static void main() {
        int secretNumber = 10;
        Scanner cs = new Scanner(System.in);
        System.out.println("please enter the secret number: ");
        int input = cs.nextInt();
        if(input == secretNumber) {
            System.out.println("You win!");
        } else { 
            System.out.println("You lose!");
        }
    }
}