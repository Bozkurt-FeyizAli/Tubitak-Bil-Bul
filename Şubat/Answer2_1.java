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
