package learning;
public class array {
    public static void main() {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(numbers[2]);

        for (int x=0; x<numbers.length; x++) {
            System.out.println(numbers[x]);
        }
        System.out.println("================================================");

        int[][] multy = {
            {1,2,3}, 
            {4,5,6},
            {7,8,9},
        };
        for (int y = 0; y < multy.length; y++) {
            for (int x: multy[y]) {
                System.out.println(x);
            }
        }

    }
}
