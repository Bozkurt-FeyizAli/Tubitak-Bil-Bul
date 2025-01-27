import java.math.BigInteger;

public class answer3{
    public static void main(String[] args) {
        System.out.println("asallı mı:");
        System.out.println(forLong.asallıMı(19051919, 19051919));
        System.out.println("sıralı asallı mı:");
        System.out.println(forLong.sıralıAsallıMı(19051919, 0, 19051919));
        System.out.println("asal mı:");
        System.out.println(forLong.AsalMı(19051919));
    
    }

}

class forInteger{
    public static boolean AsalMı(int n){
        if(n<2) return false;
        if(n<4) return true;
        double sqrt=Math.sqrt(n);
        for(int i=2; i<sqrt;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static boolean asallıMı(int n){
        if(AsalMı(n)) return true;
        int length=Integer.toString(n).length();
        for (int i = 1; i <= length; i++) {
            if(AsalMı(ilkParça(n, i))){
                int m=birdenSonra(n, i);
                System.out.println(ilkParça(n, i));
                return asallıMı(m);
            }
        }
        return false;
    }

    public static int birdenSonra(int n, int b){
        String s=Integer.toString(n);
        s=s.substring(b);
        return Integer.parseInt(s);
    }
    public static int ilkParça(int n, int ilk){
        return Integer.parseInt(Integer.toString(n).substring(0,ilk));
    }

    public static boolean sıralıAsallıMı(int n, int küçük){
        if(AsalMı(n)) return true;
        int length=Integer.toString(n).length();
        for (int i = 1; i <= length; i++) {
            int ilkParça=ilkParça(n, i);
            if(ilkParça>küçük){
            if(AsalMı(ilkParça)){
                System.out.println(ilkParça); 
                int m=birdenSonra(n, i);
                return sıralıAsallıMı(m, ilkParça);
            }
        }
        }
        return false;
    }


}


class forLong{
    public static boolean AsalMı(long n){
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
        if(AsalMı(n)&&n!=original) {
        System.out.println(n);
            return true;
        }
        int length=Long.toString(n).length();
        for (int i = 1; i <= length; i++) {
            if(Long.toString(n).charAt(i)=='0')
                continue;
            if(AsalMı(ilkParça(n, i))){
                System.out.print(ilkParça(n,i)+" || "); // for documantatiomn
                int m=birdenSonra(n, i);
                return asallıMı(m, original);
            }
        }
        return false;
    }

    public static int birdenSonra(long n, int b){
        String s=Long.toString(n);
        // if(s.charAt(b)=='0')
        //     s=s.substring(b-1);
        // else 
            s=s.substring(b);
        return Integer.parseInt(s);
    }
    public static long ilkParça(long n, int ilk){
        return Long.parseLong(Long.toString(n).substring(0,ilk));
    }

    public static boolean sıralıAsallıMı(long n, long küçük, long original){
        if(AsalMı(n)&&n!=original&&n>küçük) return true;
        int length=Long.toString(n).length()-1;
        for (int i = 1; i <= length; i++) {
            long ilkParça=ilkParça(n, i);
            if(Long.toString(n).charAt(i)=='0')
                continue;
            if(ilkParça>küçük){
            if(AsalMı(ilkParça)){
                System.out.print(ilkParça+" || "); // for documantatiomn
                int m=birdenSonra(n, i);
                return sıralıAsallıMı(m, ilkParça, original);
            }
        }
        }
        return false;
    }
}
class forBigInteger{
    public static boolean AsalMı(BigInteger n) {
        if (n.compareTo(new BigInteger("2")) < 0) return false; // n < 2
        if (n.compareTo(new BigInteger("4")) < 0) return true; // n == 2
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return false; // Çift sayı kontrolü
        BigInteger sqrt = sqrt(n);
        for (BigInteger i = BigInteger.valueOf(3); i.compareTo(sqrt) <= 0; i = i.add(BigInteger.TWO)) {
            if (n.mod(i).equals(BigInteger.ZERO)) return false;
        }
        return true;
    }

    public static boolean asallıMı(BigInteger n, BigInteger original) {
        if (AsalMı(n)&&n!=original) return true;
        String numStr = n.toString();
        int length = numStr.length();
        for (int i = 1; i <= length; i++) {
            BigInteger ilkParça = ilkParça(n, i);
            if (AsalMı(ilkParça)) {
                BigInteger kalan = birdenSonra(n, i);
                return asallıMı(kalan, original);
            }
        }
        return false;
    }

    public static BigInteger birdenSonra(BigInteger n, int b) {
        String s = n.toString();
        if (b >= s.length()) return BigInteger.ZERO; // Eğer b uzunluğu aşarsa
        s = s.substring(b);
        return new BigInteger(s);
    }

    public static BigInteger ilkParça(BigInteger n, int ilk) {
        String s = n.toString();
        if (ilk > s.length()) ilk = s.length(); // Eğer ilk uzunluğu aşarsa sınırla
        return new BigInteger(s.substring(0, ilk));
    }

    public static boolean sıralıAsallıMı(BigInteger n, BigInteger küçük, BigInteger original) {
        if (AsalMı(n)&&n!=original)
         return true;
        String numStr = n.toString();
        int length = numStr.length();
        for (int i = 1; i <= length; i++) {
            BigInteger ilkParça = ilkParça(n, i);
            if (ilkParça.compareTo(küçük) > 0) {
                if (AsalMı(ilkParça)) {
                    BigInteger kalan = birdenSonra(n, i);
                    küçük=ilkParça;
                    return sıralıAsallıMı(kalan, ilkParça, original);
                }
            }
        }
        return false;
    }

    // Karekök hesaplama yöntemi
    public static BigInteger sqrt(BigInteger n) {
        BigInteger x = n.divide(BigInteger.TWO);
        BigInteger lastX = BigInteger.ZERO;
        int i=0;
        while (!x.equals(lastX)&&i!=10000) {
            lastX = x;
            x = x.add(n.divide(x)).divide(BigInteger.TWO);
            i++;
        }
        return x;
    }

}