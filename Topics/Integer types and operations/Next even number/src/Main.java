import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int n1 = n + 1;
        int n2 = n + 2;

        if(n1 % 2 == 0) {
            System.out.println(n1);
        } else {
            System.out.println(n2);
        }
    }
}