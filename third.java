import java.math.BigInteger;

public class third {
    public static void main(String[] args) {
        BigInteger number = new BigInteger("12345678910987654321");
        System.out.println(asallıMı(number, number));
        System.out.println(sıralıAsallıMı(number, BigInteger.ZERO, number));
        System.out.println(isAsal(number));
    }

    public static boolean isAsal(BigInteger n) {
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
        if (isAsal(n)&&n!=original) return true;
        String numStr = n.toString();
        int length = numStr.length();
        for (int i = 1; i <= length; i++) {
            BigInteger ilkParça = ilkParça(n, i);
            if (isAsal(ilkParça)) {
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
        if (isAsal(n)&&n!=original)
         return true;
        String numStr = n.toString();
        int length = numStr.length();
        for (int i = 1; i <= length; i++) {
            BigInteger ilkParça = ilkParça(n, i);
            if (ilkParça.compareTo(küçük) > 0) {
                if (isAsal(ilkParça)) {
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
