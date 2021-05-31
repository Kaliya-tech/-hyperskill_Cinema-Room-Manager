import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int nMax = 1;
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        if (size <= 1) {
            System.out.println(size);
            return;
        }
        for (int j = 1; j < array.length - 1; j++) {

            if (array[j] > array[j - 1]) {
                counter++;

            } else {
                if (nMax < counter) {
                    nMax = counter;
                }
                counter = 1;
            }
        }
        if (counter == nMax) {
            System.out.println(counter);
        } else {
            System.out.println(Math.max(nMax, counter + 1));
        }

    }
}
