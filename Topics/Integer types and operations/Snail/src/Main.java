import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pole = scanner.nextInt();
        int day = scanner.nextInt();
        int night = scanner.nextInt();
        var result = 0;
        if (day - night == 1) {
            result = (pole / (day - night)) - night;
            System.out.println(result);
        } else if (night == 0) {
           //result = (pole / (day - night)) + 1;
            result = (pole + day - 1) / day;
            System.out.println(result);
        } else {
            result = pole / (day - night);
            System.out.println(result);
        }
    }
}