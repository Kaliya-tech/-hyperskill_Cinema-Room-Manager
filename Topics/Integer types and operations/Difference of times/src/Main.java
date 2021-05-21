import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int h1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int s1 = scanner.nextInt();
        int num1 = h1 * 3600 + m1 * 60 + s1;
        
        int h2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int s2 = scanner.nextInt();
        int num2 = h2 * 3600 + m2 * 60 + s2;
        
        System.out.println(num2 - num1);
    }
}
