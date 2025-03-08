public class Answer3 {
    public static void main(String[] args) {
        ŞifreSonuç[] şifreler = {
            new ŞifreSonuç("05011922", 68),
            new ŞifreSonuç("1923", 9),
            new ŞifreSonuç("19051919", 54),
            new ŞifreSonuç("30111973", 49),
            new ŞifreSonuç("1071", 39),
            new ŞifreSonuç("4815162342", 35)
        };

        String[] words = {
            "Teknofest", 
            "Tübitakbilgem", 
            "Şifrebilimsoruları", 
            "Adana", // 5
            "Şakirpaşa", // 9
            "seyhan",  // 6
            "Adaltaf", // 7
            "bamyadolması", // 12
            "kabakçintmesi", // 13
            "babagannuş", // 10
            "siniköfte", // 9
            "taşkadayıf" // 10
        };

        //char[] c = words[11].toCharArray();
        int[] arr = kelimeyiSayiyaDonustur(words[0]);
        System.out.println(nthsindexesSum(arr,  şifreler[1].şifre));
    }

    /**
     * Belirtilen kelimenin sayısal değerleriyle verilen şifreler eşleşiyor mu?
     */
    // public static ArrayList<ŞifreSonuç> sonuçVarMıKelime(String word, ŞifreSonuç[] şifreSonuçs) {
    //     ArrayList<ŞifreSonuç> results = new ArrayList<>();
        
    //     // Kelimenin harflerini sayılara dönüştür
    //     int[] arr = kelimeyiSayiyaDonustur(word);
        
    //     // Tüm şifreleri kontrol et
    //     for (ŞifreSonuç şifreSonuç : şifreSonuçs) {
    //         if (nthsindexesSum(arr, şifreSonuç.şifre, şifreSonuç.sonuç)) {
    //             results.add(şifreSonuç);
    //         }
    //     }
    //     return results;
    // }

    /**
     * Bir kelimenin harflerini sayılara dönüştürüp bir dizi olarak döndürür.
     */
    private static int[] kelimeyiSayiyaDonustur(String word) {
        char[] c = word.toCharArray();
        int[] arr = new int[c.length];

        for (int i = 0; i < c.length; i++) {
            arr[i] = HarfSayiDonusum.harfToSayi(c[i]);
        }
        return arr;
    }

    /**
     * Bir kelimenin karakterlerinin sayısal değerlerinden belirli indisleri kullanarak verilen sonucu elde etmeye çalışır.
     */
    public static int nthsindexesSum(int[] arr, String s) {
        int res=0;
        for (int i = 0; i < s.length(); i++) {  // Eğer hedeflenen sonuç sıfırsa, doğru dönüş yap
            
            int index = s.charAt(i) - '0';  // ASCII dönüşümü güvenli hale getirildi
            
            // Güvenli index kontrolü
            if (index < 0 || index >= arr.length) {
                return -1;  // Geçersiz index, fonksiyonu bitir
            }

            res += arr[index];
// Eğer sonuç negatif olduysa, mümkün değil
        }
        return res;
    }
}
