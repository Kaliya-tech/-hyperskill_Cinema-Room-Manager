import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s1 = scanner.nextInt();
        int s2 = scanner.nextInt();
        int s3 = scanner.nextInt();
        
        var check1 = s1 % 2;
        var check2 = s2 % 2;
        var check3 = s3 % 2;
        
        var result1 = 0;
        var result2 = 0;
        var result3 = 0;
    
        if (check1 != 0) {
            result1 = s1 / 2 + 1;
        } else {
            result1 = s1 / 2;
        }
        
        if (check2 != 0) {
            result2 = s2 / 2 + 1;
        } else {
            result2 = s2 / 2;
        } 
        
        if (check3 != 0) {
            result3 = s3 / 2 + 1;
        } else {
            result3 = s3 / 2;
        }
                   
        var result = result1 + result2 + result3;
        System.out.println(result);
    }
}
