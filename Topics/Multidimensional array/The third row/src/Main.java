class ArrayOperations {
    public static void printTheThirdRow(int[][] twoDimArray) {
//
        for (int i = 0; i < twoDimArray.length; i++) {
            if (i == 2) {
                for (int j = 0; j < twoDimArray[0].length; j++) {
                    System.out.print(twoDimArray[i][j] + " ");
                }
            }
        }
    }
}
