import java.util.HashMap;

public class Answer2_5{
        public static void main(String[] args) {
        ŞifreSonuç[] şifreler = {
            new ŞifreSonuç("05011922", 68), // 4-8, 2-4, 1-12 
            new ŞifreSonuç("1923", 9),
            new ŞifreSonuç("19051919", 54),
            new ŞifreSonuç("30111973", 49),
            new ŞifreSonuç("1071", 39),
            new ŞifreSonuç("4815162342", 35)
        };

        String[] words = {
            "Teknofest", // 9 
            "Tübitakbilgem", //13
            "Şifrebilimsoruları", //18
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

        HashMap<String, ŞifreSonuç> table= new HashMap<>();

        for (String string : words) {
            for (ŞifreSonuç şs : şifreler) {
                if(sonuçVarMıKelime(string, şs))
                    table.put(string, şs);
            }
        }

        for (var t : table.entrySet()) {
            System.out.println(t.getKey()+", "+t.getValue() );
        }
    }

    public static int[] stringtoArr(String s){
        char[] c=s.toCharArray();
        int[] arr= new int[c.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=HarfSayiDonusum.harfToSayi(c[i]);
        }
        return arr;
    }

    public static boolean sonuçVarMıKelime(String word, ŞifreSonuç şifreSonuç){
        int[] arr= stringtoArr(word);
        öteleM(arr, şifreSonuç.şifre);
        //return baştanSondanToplamıVarMı(arr, 0, arr.length-1, şifreSonuç.sonuç, true);
        return checkStartEndSubset(arr, şifreSonuç.sonuç);
    }

    public static void ötele(int[] arr, String s){
        if(s.length()>arr.length) return;
        int i=0;
        for (char si : s.toCharArray()) {
            arr[i]=arr[i]+si-48;
            if(arr[i]>28) arr[i]-=28;
            i++;
        }
    }

    public static void öteleMinus(int[] arr, String s){
        if(s.length()>arr.length) return;
        int i=0;
        for (char si : s.toCharArray()) {
            arr[i]=arr[i]-si+48;
            if(arr[i]>28) arr[i]-=28;
            else if(arr[i]<0) arr[i]+=28;
            i++;
        }
    }

    public static boolean checkStartEndSubset(int[] arr, int res) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            //if(arr[left]==res||arr[right]==res) return true;
            if (arr[left] + arr[right] == res) {
                return true;
            } else if (arr[left] + arr[right] < res) {
                left++; // Toplam res'ten küçükse sol tarafı artır
            } else {
                right--; // Toplam res'ten büyükse sağ tarafı azalt
            }
        }
        return false;
    }
}