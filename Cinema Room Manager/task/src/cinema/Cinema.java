package cinema;
import java.util.Scanner;

public class Cinema {

    private static final char NOT_EMPTY_SEAT = 'B';
    private static final char EMPTY_SEAT = 'S';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();

        char[][] arr = prepareCinema(rows, columns);
        showMenu(arr, scanner);
    }

    private static void showMenu(char[][] arr, Scanner scanner) {

        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                drawCinema(arr, scanner);
                break;
            case 2:
                promptInput(arr, scanner);
                break;
            case 3:
                showStatistics(arr,scanner);
                break;
            case 0:
                break;
        }
    }

    private static char[][] prepareCinema(int rows, int columns) {
        char[][] arr = new char[rows + 1][columns + 1];

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
                arr[i][j] = EMPTY_SEAT;
            }
        }

        return arr;
    }

    private static void drawCinema(char[][] arr, Scanner scanner) {
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
        showMenu(arr, scanner);
    }

    private static void promptInput(char[][] arr, Scanner scanner) {
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();

        checkAllInput(arr, rowNum,seatNum,scanner);
    }

    private static void checkAllInput(char[][] arr, int rowNum, int seatNum, Scanner scanner) {
        try {
            checkRow(arr, rowNum, scanner);
            checkSeat(arr, seatNum, scanner);
            orderSeat(scanner, arr, rowNum, seatNum);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input!");
            promptInput(arr, scanner);
        }
    }

    private static void checkRow(char[][] arr, int rowNum, Scanner scanner)
            throws ArrayIndexOutOfBoundsException {
        try {
            if (rowNum == 0) {
                System.out.println("Wrong input!");
                promptInput(arr, scanner);
            }
            int ch = (arr[rowNum][0]);
        } catch(ArrayIndexOutOfBoundsException ex) {
            throw ex;
        }
    }

    private static void checkSeat(char[][] arr, int seatNum, Scanner scanner)
            throws ArrayIndexOutOfBoundsException {
        try {
            if (seatNum == 0) {
                System.out.println("Wrong input!");
                promptInput(arr, scanner);
            }
            int ch = arr[0][seatNum];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw ex;
        }
    }

    private static void orderSeat(Scanner scanner, char[][] arr, int rowNum, int seatNum) {
        if (arr[rowNum][seatNum] == NOT_EMPTY_SEAT) {
            System.out.println("That ticket has already been purchased!");
            promptInput(arr, scanner);
            return;
        }
        arr[rowNum][seatNum] = NOT_EMPTY_SEAT;
        System.out.println("Ticket price: $" + calculateLargePlaceTicket(arr, rowNum));
        showMenu(arr, scanner);
    }

    private static int calculateTicketPrice(char[][] arr, int rowNum) {
        int ticketPrice = 0;
        String place = "";
        int allSeats = (arr.length - 1) * (arr[0].length - 1);

        if (allSeats > 60) {
            place = "large";
        } else {
            place = "small";
        }

        switch (place) {
            case "large":
                ticketPrice = calculateLargePlaceTicket(arr, rowNum);
                break;
            case "small":
                ticketPrice = 10;
                break;
        }
        return ticketPrice;
    }

    private static int calculateLargePlaceTicket (char[][] arr, int rowNum) {
        final int TICKET_ON_FIRST_ROWS = 10;
        final int TICKET_ON_LAST_ROWS = 8;
        int allSeats = (arr.length - 1) * (arr[0].length - 1);
        int frontHalf = 0;
        int ticketprice = 10;

        if (allSeats > 60) {
            frontHalf = (arr.length - 1) / 2;
            if (((arr.length - 1) - rowNum) < frontHalf) {
                return TICKET_ON_LAST_ROWS;
            }
            frontHalf = (arr.length - 1) / 2;
            if (((arr.length - 1) - rowNum) <= frontHalf) {
                return TICKET_ON_LAST_ROWS;
            }
            return TICKET_ON_FIRST_ROWS;
        }

        return ticketprice;
    }

    private static void printIncome(char[][] arr) {
        int allSeats =(arr.length - 1) * (arr[0].length - 1);
        int income = 0;
        String place = "";

        if (allSeats > 60) {
            place = "large";
        } else {
            place = "small";
        }

        switch (place) {
            case "large":
                income = calculateLargeTotalIncome(arr);
                break;
            case "small":
                income = 10 * allSeats;
                break;
        }
        System.out.println("Total income: $" + income);
    }

    private static int calculateLargeTotalIncome(char[][] arr) {

        int allSeats =(arr.length - 1) * (arr[0].length - 1);
        int income;
        int frontHalf;
        int backHalf;

        if ((arr.length - 1) % 2 == 0) {
            frontHalf = allSeats / 2;
            backHalf = allSeats - frontHalf;
            income = (backHalf * 8) + (frontHalf * 10);
            return income;
        }
        frontHalf = (arr.length - 1) / 2;
        backHalf = (arr.length - 1) - frontHalf;
        income = (10 * (frontHalf * (arr[0].length - 1))) + ((8 * backHalf * (arr[0].length - 1)));
        return income;
    }

    private static void showStatistics(char[][] arr, Scanner scanner) {
        int countTickets = 0;
        int currentIncome = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == NOT_EMPTY_SEAT) {
                    countTickets++;
                    currentIncome += calculateTicketPrice(arr, i);
                }
            }
        }

        System.out.printf("Number of purchased tickets: %d%n", countTickets);
        double allSeats = (arr.length - 1) * (arr[0].length - 1);
        double percentage = (countTickets / allSeats) * 100;

        System.out.printf("Percentage: %.2f%s%n", percentage, "%");
        System.out.printf("Current income: %s%d%n", "$", currentIncome);
        printIncome(arr);
        showMenu(arr, scanner);
    }

}