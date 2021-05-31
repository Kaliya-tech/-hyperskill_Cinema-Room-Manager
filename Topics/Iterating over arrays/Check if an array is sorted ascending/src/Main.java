import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean broke = false;
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        for (int j = 1; j < array.length; j++) {

            if (array[j] < array[j - 1]) {
                broke = true;
                break;
            }
        }

        if (broke) {
            System.out.println(false);

            } else System.out.println(true);
    }
}