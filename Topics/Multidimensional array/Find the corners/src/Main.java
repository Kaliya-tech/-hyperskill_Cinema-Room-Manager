class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        System.out.print(twoDimArray[0][0] + " ");
        System.out.println(twoDimArray[0][twoDimArray[0].length - 1]);
        System.out.print(twoDimArray[twoDimArray.length - 1][0] + " ");
        System.out.print(twoDimArray[twoDimArray.length - 1][twoDimArray[0].length - 1]);
    }

  /*  public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int acc = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = acc++;
            }
        }
        printCorners(arr);
    }*/
}