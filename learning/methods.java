package learning;
public class methods {
    static int sum (int a, int b) {
        return a + b;
    }
    static void percent(double num, int percentage) {
        double result = (num / 100) * percentage;
        System.out.println(percentage + "% of " + num + " is " + result);
    }
    static void person(String name, int age) {
        System.out.println(name + " is " + age + " years old");
    }
    public static void main() {
        person("Pepa pig", 100);
        person("Pepas dad", 200);
        System.out.println("================================================================");
        percent(50, 25);
        percent(100, 50);
        percent(200, 10);
        percent(500, 25);
        System.out.println("================================================================");
        int sum = sum(2, 4);
        System.out.println("Sum of 2 and 4 is: " + sum);
    }
}
