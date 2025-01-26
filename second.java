public class second {
    public static void main(String[] args) {
        System.out.println(asallıMı(314159, 314159));
        System.out.println(sıralıAsallıMı(314159, 0, 314159));
        System.out.println(isAsal(314159));
    }
    public static boolean isAsal(long n){
        if(n<2) return false;
        if(n<4) return true;
        if(n%2==0) return false;
        double sqrt=Math.sqrt(n);
        for(int i=2; i<sqrt;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static boolean asallıMı(long n, long original){
        if(isAsal(n)&&n!=original) return true;
        int length=Long.toString(n).length();
        for (int i = 1; i <= length; i++) {
            if(isAsal(ilkParça(n, i))){
                System.out.println(ilkParça(n, i));
                int m=birdenSonra(n, i);
                return asallıMı(m, original);
            }
        }
        return false;
    }

    public static int birdenSonra(long n, int b){
        String s=Long.toString(n);
        s=s.substring(b);
        return Integer.parseInt(s);
    }
    public static long ilkParça(long n, int ilk){
        return Long.parseLong(Long.toString(n).substring(0,ilk));
    }

    public static boolean sıralıAsallıMı(long n, long küçük, long original){
        if(isAsal(n)&&n!=original) return true;
        int length=Long.toString(n).length();
        for (int i = 1; i <= length; i++) {
            long ilkParça=ilkParça(n, i);
            if(ilkParça>küçük){
            if(isAsal(ilkParça)){
                int m=birdenSonra(n, i);
                return sıralıAsallıMı(m, ilkParça, original);
            }
        }
        }
        return false;
    }

}

