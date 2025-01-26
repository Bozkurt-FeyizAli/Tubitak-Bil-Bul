import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ocak{
    public static void main(String[] args) {
        // String a="MGCFA???ACŞCĞCNMŞCÖCK";
        // for (char string : a.toCharArray()) {
        //     System.out.println(LetterToNumber(Character.toLowerCase(string)));
        // }
        
        HashMap<Integer, String> plakaSehirMap= new HashMap<>();
        plakaSehirMap.put(1, "adana");
        plakaSehirMap.put(2, "adıyaman");
        plakaSehirMap.put(3, "afyonkarahisar");
        plakaSehirMap.put(4, "ağrı");
        plakaSehirMap.put(5, "amasya");
        plakaSehirMap.put(6, "ankara");
        plakaSehirMap.put(7, "antalya");
        plakaSehirMap.put(8, "artvin");
        plakaSehirMap.put(9, "aydın");
        plakaSehirMap.put(10, "balıkesir");
        plakaSehirMap.put(11, "bilecik");
        plakaSehirMap.put(12, "bingöl");
        plakaSehirMap.put(13, "bitlis");
        plakaSehirMap.put(14, "bolu");
        plakaSehirMap.put(15, "burdur");
        plakaSehirMap.put(16, "bursa");
        plakaSehirMap.put(17, "çanakkale");
        plakaSehirMap.put(18, "çankırı");
        plakaSehirMap.put(19, "çorum");
        plakaSehirMap.put(20, "denizli");
        plakaSehirMap.put(21, "diyarbakır");
        plakaSehirMap.put(22, "edirne");
        plakaSehirMap.put(23, "elazığ");
        plakaSehirMap.put(24, "erzincan");
        plakaSehirMap.put(25, "erzurum");
        plakaSehirMap.put(26, "eskişehir");
        plakaSehirMap.put(27, "gaziantep");
        plakaSehirMap.put(28, "giresun");
        plakaSehirMap.put(29, "gümüşhane");
        plakaSehirMap.put(30, "hakkari");
        plakaSehirMap.put(31, "hatay");
        plakaSehirMap.put(32, "ısparta");
        plakaSehirMap.put(33, "mersin");
        plakaSehirMap.put(34, "istanbul");
        plakaSehirMap.put(35, "izmir");
        plakaSehirMap.put(36, "kars");
        plakaSehirMap.put(37, "kastamonu");
        plakaSehirMap.put(38, "kayseri");
        plakaSehirMap.put(39, "kırklareli");
        plakaSehirMap.put(40, "kırşehir");
        plakaSehirMap.put(41, "kocaeli");
        plakaSehirMap.put(42, "konya");
        plakaSehirMap.put(43, "kütahya");
        plakaSehirMap.put(44, "malatya");
        plakaSehirMap.put(45, "manisa");
        plakaSehirMap.put(46, "kahramanmaraş");
        plakaSehirMap.put(47, "mardin");
        plakaSehirMap.put(48, "muğla");
        plakaSehirMap.put(49, "muş");
        plakaSehirMap.put(50, "nevşehir");
        plakaSehirMap.put(51, "niğde");
        plakaSehirMap.put(52, "ordu");
        plakaSehirMap.put(53, "rize");
        plakaSehirMap.put(54, "sakarya");
        plakaSehirMap.put(55, "samsun");
        plakaSehirMap.put(56, "siirt");
        plakaSehirMap.put(57, "sinop");
        plakaSehirMap.put(58, "sivas");
        plakaSehirMap.put(59, "tekirdağ");
        plakaSehirMap.put(60, "tokat");
        plakaSehirMap.put(61, "trabzon");
        plakaSehirMap.put(62, "tunceli");
        plakaSehirMap.put(63, "şanlıurfa");
        plakaSehirMap.put(64, "uşak");
        plakaSehirMap.put(65, "van");
        plakaSehirMap.put(66, "yozgat");
        plakaSehirMap.put(67, "zonguldak");
        plakaSehirMap.put(68, "aksaray");
        plakaSehirMap.put(69, "bayburt");
        plakaSehirMap.put(70, "karaman");
        plakaSehirMap.put(71, "kırıkkale");
        plakaSehirMap.put(72, "batman");
        plakaSehirMap.put(73, "şırnak");
        plakaSehirMap.put(74, "bartın");
        plakaSehirMap.put(75, "ardahan");
        plakaSehirMap.put(76, "ığdır");
        plakaSehirMap.put(77, "yalova");
        plakaSehirMap.put(78, "karabük");
        plakaSehirMap.put(79, "kilis");
        plakaSehirMap.put(80, "osmaniye");
        plakaSehirMap.put(81, "düzce"); 

        System.out.println("results");

        List<String> list=listOfCities(plakaSehirMap);

        for (String string : list) {
            System.out.println(string);
        }
        // System.out.println(sıralıAsallıMı(314159, 0));
        // HashMap<Character, Integer> listC=new HashMap<>();
        // File file = new File("map.txt");
        // int[] arr= new int[21];
        // char[][] carr= new char[11][21];
        // try {
        //     Scanner reader= new Scanner(file);
        //     int k=0;
        //     while(reader.hasNext()){
                
        //     String line=reader.nextLine();
        //     int i=0;
        //     for (Character character : line.toCharArray()) {
        //         arr[i]+=LetterToNumber(Character.toLowerCase(character));
        //         carr[k][i]=character;
        //         i++;
                
        //         carr[i][k]=character;
        //         listC.putIfAbsent(character, 1);
        //         if(listC.containsKey(character))
        //             listC.put(character, listC.get(character)+1);
                

        //     }
        //     k++;
        // }
        
        // // for (int i : arr) {
        // //     System.out.println(modM(i, 29));
        // // }
            
        // } catch (Exception e) {
        //     // TODO: handle exception
        // } 

        // for (var character : listC.entrySet()) {
        //     System.out.println(character.getKey()+" : "+character.getValue());
        // }


        // System.out.println();
        // System.out.println();
        // int[] total= new int[21];
        // for (int i = 0; i < 21; i++) {
        //     for (int j = 0; j < 11; j++) {
        //         // System.out.print(LetterToNumber(Character.toLowerCase(carr[j][i]))+" ");
        //         total[i]+=LetterToNumber(Character.toLowerCase(carr[j][i]));
        //     }
        //     // System.out.println();
        // }

        // // for (int i = 0; i < 21; i++) {
        // //     System.out.println(total[i]);
        // // }

        // int[] deneme= new int[6];
        // deneme[0]=total[2];
        // deneme[1]=total[9];
        // deneme[2]=total[11];
        // deneme[3]=total[13];
        // deneme[4]=total[17];
        // deneme[5]=total[19];

       



        // System.out.println(denemeall(deneme));
        
    }
