package cinema;
import java.util.Scanner;

        //int countTickets = 0;
        //countTickets++;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int colums = scanner.nextInt();

        char[][] arr = prepareCinema(rows, colums);
        promtTheMenu(scanner, rows, colums, arr);

    }

    public static void promtTheMenu (Scanner scanner, int rows, int colums, char[][] arr) {
        System.out.println();
        System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit\n");

        int menu = scanner.nextInt();
        int countTickets = 0;

        switch (menu) {
            case 1:
                prepareCinema(rows, colums);
                drawCinema(arr);
                promtTheMenu(scanner, rows, colums, arr);
            case 2:
                chooseSeat(arr, rows, colums);
                promtTheMenu(scanner, rows, colums, arr);
            case 3:
                showStatistics(arr, rows, colums, ticketPrice);
                promtTheMenu(scanner, rows, colums, arr);

            case 0:
                break;

            default:
                System.out.println("Wrong input!");
                promtTheMenu(scanner, rows, colums, arr);


        }
    }

    public static char[][] prepareCinema(int rows, int colums) {
        char[][] arr = new char[rows + 1][colums + 1];

        // draw columns index
        for (int i = 1; i < arr[0].length; i++) {
            arr[0][i] = (char) (i + '0');
        }

        // draw rows index
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = (char) (i + '0');
        }
        // draw seats
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = 'S';
            }
        }
        return arr;
    }

    public static void drawCinema(char[][] arr) {
        System.out.println("Cinema:");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(" ");
            }
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] chooseSeat(char[][] arr, int rows, int colums) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();

        if (rowNum > rows || rowNum < 1) {
            System.out.println("Wrong input!");
            System.out.println("Enter a row number:");
        }

        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();

        if (seatNum > colums || seatNum < 1) {
            System.out.println("Wrong input!");
            System.out.println("Enter a row number:");
        }

        arr[rowNum][seatNum] = 'B';
        printThePrice(rows, colums, rowNum);

        return arr;
    }

    public static void printThePrice(int rows, int colums, int rowNum) {
        int allSeats = rows * colums;
        int frontHalf;
        int backHalf;
        int income;
        int ticketPrice;
        String place = "";

        if (allSeats > 60) {
            place = "large";
        }
        switch (place) {
            case "large":
                if (rows % 2 == 0) {
                    frontHalf = allSeats / 2;
                    //backHalf = allSeats - frontHalf;
                    //income = (backHalf * 8) + (frontHalf * 10);
                    if ((rows - rowNum) <= frontHalf) {
                        ticketPrice = 8;
                    } else {
                        ticketPrice = 10;
                    }
                    System.out.println("Ticket price: \n" + "$" + ticketPrice);
                    break;
                } else {
                    frontHalf = rows / 2;
                    //backHalf = rows - frontHalf; //
                    //income = (10 * (frontHalf * colums)) + ((8 * backHalf * colums));
                    if ((rows - rowNum) <= frontHalf) {
                        ticketPrice = 8;
                    } else {
                        ticketPrice = 10;
                    }
                    System.out.println("Ticket price: \n" + "$" + ticketPrice);
                    break;
                }

            default:
                income = 10 * allSeats;
                System.out.println("Ticket price: \n" + "$" + income / allSeats);
                break;
        }
    }

    public static void showStatistics(char[][] arr, int rows, int colums, int ticketPrice) {

        int countTickets = 0;
        int currentIncome = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 'B') {
                    countTickets++;
                    currentIncome =+ ticketPrice;
                }
            }
        }
        System.out.println("Number of purchased tickets: " + countTickets);
        double allSeats = rows * colums;
        double percentage = (countTickets / allSeats) * 100;
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Current income: $" + currentIncome);

        //System.out.println("Total income: $" 360);

       // 1 The number of purchased tickets;
       // 2 The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
       // 3 Current income;
       // 4 The total income that shows how much money the theatre will get if all the tickets are sold.
    }
}