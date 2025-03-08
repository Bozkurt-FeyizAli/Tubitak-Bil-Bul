import java.util.ArrayList;
import java.util.HashMap;

public class Answer2_2 {
    public static void main(String[] args) {
        ŞifreSonuç[] şifreler= {
            new ŞifreSonuç("05011922", 68),
            new ŞifreSonuç("1923", 9),
            new ŞifreSonuç("19051919", 54),
            new ŞifreSonuç("30111973", 49),
            //new ŞifreSonuç("23041920", 5?),
            new ŞifreSonuç("1071", 39),
            new ŞifreSonuç("4815162342", 35)
        };
        HashMap<Integer, Integer> sayılar= new HashMap<>();
        for (ŞifreSonuç şifreSonuç : şifreler) {
            int i=0;
            for (char c : şifreSonuç.şifre.toCharArray()) {
                i+=c-48;
            }
            sayılar.put(i, şifreSonuç.sonuç);
        }
        
        
        String[] words={"Teknofest" , //
                        "Tübitakbilgem" , //
                        "Şifrebilimsoruları" , //
                        "AdanaŞakirpaşa",
                        "Şakirpaşa", //
                        //
                        "seyhan",
                        "Adaltaf", //
                        //
                        "bamyadolması" , //
                        "kabakçintmesi" ,//
                        "babagannuş" , //
                        "siniköfte" , //
                        "taşkadayıf"
                    };
        
        for (String string : words) {
            int[] arr=new int[string.length()];
            int j=0;
            for (char c : string.toCharArray()) {
                arr[j]=HarfSayiDonusum.harfToSayi(c);
            }
            System.out.println(ilkNdeToplamıVarMı(arr, 0, 30));
        }
        
        
    }

    public static ArrayList<String> sonuçVarMıKelime(String word, HashMap<Integer, Integer> sayılar){
        ArrayList<String> results= new ArrayList<>();
        char[] c=word.toCharArray();
        for (var vars: sayılar.entrySet()) {
            int[] arr=new int[c.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=HarfSayiDonusum.harfToSayi(c[i]);
            }
            // if(baştanSondanToplamıVarMı(arr, 0, arr.length-1, şifreSonuç.sonuç)) results.add(şifreSonuç);
            if(ilkNdeToplamıVarMı(arr, 0, Math.abs(vars.getValue()-vars.getKey()))) 
                results.add(vars.getValue()+" "+vars.getValue());
        }
        return results;
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
}
