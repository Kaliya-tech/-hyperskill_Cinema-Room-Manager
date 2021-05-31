import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int companies = scanner.nextInt();

        int[] income = new int[companies];
        for (int i = 0; i < companies; i++) {
            income[i] = scanner.nextInt();
        }

        int[] percent = new int[companies];
        for (int j = 0; j < companies; j++) {
            percent[j] = scanner.nextInt();
        }

        if (companies == 1) {
            System.out.println("1");
            return;
        }

        int companyNum = 0;
        double cash = 0.0;
        for (int i = 0; i < companies; i++) {
            double percentF = percent[i];
            double percentFinal = percentF / 100;
            double incomeFinal = income[i];
            double tmpCash = incomeFinal * percentFinal;

            if (tmpCash > cash) {
                cash = tmpCash;
                companyNum = i + 1;
            }
        }
        System.out.println(companyNum);
    }
}