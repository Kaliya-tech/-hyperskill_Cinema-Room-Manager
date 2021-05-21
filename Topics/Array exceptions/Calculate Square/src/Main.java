class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {

        try {
            if (index < 0 || index > array.length - 1) {
                System.out.println("Exception!");
            } else {
                System.out.println(array[index] * array[index]);
            }
        } catch (NullPointerException exception) {
            System.out.println("Exception!");
        }
    }
}
