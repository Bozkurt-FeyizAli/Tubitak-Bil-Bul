
public class Answer1 {
    public static void main(String[] args) {
        // int[] ns = new int[51];
        // int i = 2;
        // int j = 0;
        // while (j < 51) {
        //     if (AsalMı(i)) {
        //         ns[j] = i;
        //         j++;
        //     }
        //     i++;
        // }
        
        // // Print letters based on the numbers
        // for (int n : ns) {
        //     if (n % 2 == 0) {
        //         System.out.print("y");
        //     } else if ((n + 1) % 4 == 0) {
        //         System.out.print("m");
        //     } else {
        //         System.out.print("k");
        //     }
        // }
        // makb
        System.out.println(30111973&11);
    }

    public static boolean AsalMı(int n) {
        if (n < 2) return false;
        if (n < 4) return true;
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {  // Check divisors up to sqrt(n)
            if (n % i == 0) return false;
        }
        return true;
    }
}
