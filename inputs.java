import java.util.Scanner;

public class inputs {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        
        System.out.println("Hello, " + name + " : " + age);
    }
}
