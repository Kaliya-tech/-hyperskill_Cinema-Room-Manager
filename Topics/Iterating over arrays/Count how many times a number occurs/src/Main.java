import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        int num3 = scanner.nextInt();
        int counter = 0;
        for (int b : numbers) {
            if (b == num3) {
                counter++;
            }
        } System.out.println(counter);
    }
}

