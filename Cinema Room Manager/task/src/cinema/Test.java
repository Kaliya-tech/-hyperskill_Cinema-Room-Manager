package cinema;

public class Test {
    public static void inttoChar () {
        char[] arr = new char[9];
        for (int i = 1; i < 10; i++) {
            arr[i - 1] = (char)(i + '0');
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
