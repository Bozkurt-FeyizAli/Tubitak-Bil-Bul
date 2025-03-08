import java.util.ArrayList;
import java.util.HashMap;

public class Answer2_4 {
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

    public static int indexSum(int[] arr, String indexes, int sum){
        if(arr.length<10){
            int[] temp=new int[arr.length*2];
            for (int i = 0, j=arr.length; i < arr.length; i++, j++) {
                temp[i]=arr[i];
                temp[j]=arr[i];
            }
            arr=temp;
        }
        int res=0;
        while(indexes.length()>0){
        int index=(int)indexes.charAt(0)-48;
        if(res==sum) return 0;
        res+=arr[index];
        indexes=indexes.substring(1);
        }
        
        return res- sum;
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
        ötele(arr, şifreSonuç.şifre);
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

    public static void ötele2(int[] arr, String s){
        if(s.length()>arr.length) return;
        if(s.length()<arr.length){
            while(s.length()<arr.length)
                s+=s;
            s=s.substring(0, arr.length);
        }
        else if(arr.length<s.length()){
            int[] arr1= new int[s.length()];
            for (int i = 0, j=0; i < arr1.length; i++, j++) {
                if(j==arr.length) j=0;
                arr1[i]=arr[j];
            } 
            arr=arr1;
        }
        int i=0;
        for (char si : s.toCharArray()) {
            arr[i]=arr[i]+si-48;
            if(arr[i]>28) arr[i]-=28;
            i++;
            //System.out.println(arr[i-1]);
        }
    }

    public static boolean checkConsecutiveSubset(int[] arr, int res) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum == res) {
                    return true;
                }
                if (currentSum > res) {
                    break; // Toplam res'ten büyükse iç döngüyü sonlandır
                }
            }
        }
        return false;
    }

    // Baştan ve sondan seçilen elemanların toplamını kontrol eder
    public static boolean checkStartEndSubset(int[] arr, int res) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
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

    public static boolean baştanSondanToplamıVarMı(int[] arr, int st, int fn, int res, boolean bool){
        if(res==0) return true;
        if(res<0) return false;
        if(st>fn) return false;
        if(st==fn&&arr[st]!=res) return false;
        if(bool){
            res-=arr[st];
            return baştanSondanToplamıVarMı(arr, st+1, fn, res, !bool);
        }
        else{
            res-=arr[fn];
            return baştanSondanToplamıVarMı(arr, st+1, fn, res, !bool);
        }
    }

    public static boolean isSubsetSum(int[] arr, int n, int res) {
        // Eğer res 0 ise, boş küme toplamı 0'dır, bu yüzden true döner.
        if (res == 0) {
            return true;
        }
        // Eğer n 0 ise ve res 0 değilse, hiçbir alt küme toplamı res'e eşit olamaz.
        if (n == 0) {
            return false;
        }
        // Eğer son eleman res'ten büyükse, bu elemanı alt kümeye dahil etmeyiz.
        if (arr[n - 1] > res) {
            return isSubsetSum(arr, n - 1, res);
        }
        // Son elemanı alt kümeye dahil edip etmeme durumlarını kontrol ederiz.
        return isSubsetSum(arr, n - 1, res) || isSubsetSum(arr, n - 1, res - arr[n - 1]);
    }

    public static boolean ilkNdeToplamıVarMı(int[] arr, int index, int res){
        if(index<0||index>=arr.length) return false;
        if(arr[index]>res) return false;
        if(arr[index]==res) return true;
        res-=arr[index];
        return ilkNdeToplamıVarMı(arr, index+1, res);
    }
}
