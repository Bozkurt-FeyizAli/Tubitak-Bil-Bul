import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Answer2_1 {
    public static void main(String[] args) {
        
        
        
        String[] words={"Teknofest", 
                        "Tübitakbilgem",
                        "Şifrebilimsoruları", 
                        "Adana",
                        "Şakirpaşa", 
                        "seyhan",
                        "Adaltaf", 
                        "bamyadolması",
                        "kabakçintmesi",
                        "babagannuş",
                        "siniköfte", 
                        "taşkadayıf"
                    };
                    ŞifreSonuç[] şifreler= {
                        new ŞifreSonuç("05011922", 68), //0
                        new ŞifreSonuç("1923", 9),  //1
                        new ŞifreSonuç("19051919", 54), //2
                        new ŞifreSonuç("30111973", 49), //3  
                        new ŞifreSonuç("23041920", 59),  
                        new ŞifreSonuç("1071",  39),  //4  f
                        new ŞifreSonuç("4815162342", 35)  //5  f
                    };
                    for (int i = 0; i < words.length; i++) {
                        words[i] = words[i].toLowerCase();
                    }
                    char[] c=words[0].toCharArray();
                    int[] arr=new int[c.length];
                        for (int i = 0; i < arr.length; i++) {
                            arr[i]=HarfSayiDonusum.harfToSayi(c[i]);
                        }
                        ötele(arr, şifreler[3].şifre);
                        for (int i : arr) {
                            System.out.println(i);
                        }
        // HashMap<String, ArrayList<ŞifreSonuç>> table =new HashMap<>();           
        // for (String st : words) {
        //     for (ŞifreSonuç şifreSonuç : sonuçVarMıKelime(st, şifreler)) {
        //         table.putIfAbsent(st, new ArrayList<>());
        //         table.get(st).add(şifreSonuç);
        //     }
        // }

        // for (var vars : table.entrySet()) {
        //     System.out.println(vars.getKey());
        //     if(vars.getValue().isEmpty()){
        //         System.out.println("No şifresonuç"); break;}
        //     for (ŞifreSonuç şifreSonuç : vars.getValue()) {
        //         System.out.println(şifreSonuç);
        //     }
        // }
        // for (String string : words) {
        //     ArrayList<ŞifreSonuç> şifreSonuç= sonuçVarMıKelime(string, şifreler);
        //     if(şifreSonuç.isEmpty()) 
        //         continue;
        //     System.out.println(string);
        //     for (ŞifreSonuç ş  : şifreSonuç) {
        //         System.out.println(ş.şifre+" "+ş.sonuç);
        //     }
        //     System.out.println();
        // }

        for (String s : words) {
            System.out.println(sonuçVarMıKelime(s, şifreler));
        }
        
        
        
    }

    public static boolean sonuçVarMı(String[] words, ŞifreSonuç[] şifreSonuçs){
        if(şifreSonuçs.length==0) return true;
        for (ŞifreSonuç şifreSonuç : şifreSonuçs) {
            for (String word : words) {
                char[] c=word.toCharArray();
                int[] arr=new int[c.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i]=HarfSayiDonusum.harfToSayi(c[i]);
                }
                ötele(arr, şifreSonuç.şifre);
                if(baştanSondanToplamıVarMı(arr, 0, arr.length-1 ,şifreSonuç.sonuç)){
                    List<String> wordss = new ArrayList<>(Arrays.asList(words));
                    wordss.remove(word);
                    List<ŞifreSonuç> şifreSonuçss = new ArrayList<>(Arrays.asList(şifreSonuçs));
                    şifreSonuçss.remove(şifreSonuç);
                    return sonuçVarMı(
                        wordss.toArray(new String[0]), 
                        şifreSonuçss.toArray(new ŞifreSonuç[0])
                                    );
                }
            }
        }
        return false;
    }

    
    public static boolean ilkNdeToplamıVarMı(int[] arr, int index, int res){
        if(res==0){
            //System.out.println(index);
            return true;}
        if(res<0) return false;
        if(index<0||index>=arr.length) return false;
        if(arr[index]>res) return false;
        res-=arr[index];
        return ilkNdeToplamıVarMı(arr, index+1, res);
    }

    public static boolean baştanSondanToplamıVarMı(int[] arr, int st, int fn, int res){
        if(res==0){ 
            //System.out.println(st);
            return true;}
        if(arr[st]==res||arr[fn]==res) return true;
        if(res<0) return false;
        if(st>fn) return false;
        if(st==fn&&arr[st]!=res) return false;
        if(arr[st]>res) return false;
        res-=(arr[st]+arr[fn]);
        return baştanSondanToplamıVarMı(arr, st+1, fn-1, res);
    }
    public static boolean baştanSondanToplamıVarMı(int[] arr, int res) {
        int st = 0;
        int fn = arr.length - 1;
    
        while (st <= fn) {
            //System.out.println(String.format("ilk: %d, son: %d", st, fn));
            // Eğer res, baştan veya sondan bir elemana eşitse true döndür
            if (arr[st] == res || arr[fn] == res) {
                return true;
            }
    
            // Eğer res, baştan ve sondan elemanların toplamından büyükse, baştan elemanı çıkar
            if (arr[st] + arr[fn] < res) {
                res -= arr[st];
                st++;
            }
            // Eğer res, baştan ve sondan elemanların toplamından küçükse, sondan elemanı çıkar
            else if (arr[st] + arr[fn] > res) {
                res -= arr[fn];
                fn--;
            }
            // Eğer res, baştan ve sondan elemanların toplamına eşitse true döndür
            else {
                return true;
            }
        }
    
        // Eğer döngü sonunda res değeri 0 ise true, değilse false döndür
        return res == 0;
    }
    
    public static ArrayList<ŞifreSonuç> sonuçVarMıKelime(String word, ŞifreSonuç[] şifreSonuçs){
        ArrayList<ŞifreSonuç> results= new ArrayList<>();
        char[] c=word.toCharArray();
        for (ŞifreSonuç şifreSonuç : şifreSonuçs) {
            int[] arr=new int[c.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=HarfSayiDonusum.harfToSayi(c[i]);
            }
            ötele(arr, şifreSonuç.şifre);
            if(ilkNdeToplamıVarMı(arr, 0, şifreSonuç.sonuç))
            //if(ilkNdeToplamıVarMı(arr, 0, şifreSonuç.sonuç)) 
                results.add(şifreSonuç);
        }
        return results;
    }

    public static void ötele(int[] arr, String s){
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

}


class ŞifreSonuç{
    String şifre;
    int sonuç;
    public ŞifreSonuç(String şifre, int sonuç) {
        this.şifre = şifre;
        this.sonuç = sonuç;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return şifre+" "+Integer.toString(sonuç) ;
    }
    
}


class HarfSayiDonusum {
    
    // Türk alfabesindeki harflerin sırası
    private static final String ALFABE = "abcçdefgğhiıjklmnoöprsştuüvyz";

    // Sayıyı harfe dönüştürme fonksiyonu
    public static char sayiToHarf(int sayi) {
        return ALFABE.charAt(sayi);
    }

    // Harfi sayıya dönüştürme fonksiyonu
    public static int harfToSayi(char harf) {
        harf=Character.toLowerCase(harf);
        return ALFABE.indexOf(harf);
    }


}


