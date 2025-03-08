public class Answer2_3 {
    public static void main(String[] args) {
        String word="taşkadayıf";
        int[] arr= new int[word.length()];
        int i=0;
        for (char c : word.toCharArray()) {
            arr[i]=HarfSayiDonusum.harfToSayi(c);
            i++;
        }
        int k=0;
        for (int j : arr) {
            k+=j;
            System.out.println("toplam :"+k);
            System.out.println(j);
            System.out.println();
        }

        //System.out.println(enBuyukAsalCarpanBul(1071 ));
    }

    public static long enBuyukAsalCarpanBul(long n) {
        long enBuyukCarpan = -1;

        // 2 ile bölünebildiği sürece böl
        while (n % 2 == 0) {
            enBuyukCarpan = 2;
            n /= 2;
        }

        // Tek sayılar için 3'ten başlayarak kareköküne kadar kontrol et
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                enBuyukCarpan = i;
                n /= i;
            }
        }

        // Eğer n hala 1'den büyükse, kendisi asaldır
        if (n > 2) {
            enBuyukCarpan = n;
        }

        return enBuyukCarpan;
    }
}
