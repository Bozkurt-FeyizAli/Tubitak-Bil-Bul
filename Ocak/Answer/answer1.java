import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class answer1{
public static void main(String[] args) {
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
}

public static int LetterToNumber(char c){
    switch (c) {
        case 'a':
        return 1;
        case 'b':
        return 2;
        case 'c':
        return 3;
        case 'ç':
        return 4;
        case 'd':
        return 5;
        case 'e':
        return 6;
        case 'f':
        return 7;
        case 'g':
        return 8;
        case 'ğ':
        return 9;
        case 'h':
        return 10;
        case 'ı':
        return 11;
        case 'i':
        return 12;
        case 'j':
        return 13;
        case 'k':
        return 14;
        case 'l':
        return 15;
        case 'm':
        return 16;
        case 'n':
        return 17;
        case 'o':
        return 18;
        case 'ö':
        return 19;
        case 'p':
        return 20;
        case 'r':
        return 21;
        case 's':
        return 22;
        case 'ş':
        return 23;
        case 't':
        return 24;
        case 'u':
        return 25;
        case 'ü':
        return 26;
        case 'v':
        return 27;
        case 'y':
        return 28;
        case 'z':
        return 29;
    }
    return 0;
}
public static String CityOfNumber(int n, HashMap<Integer, String> plakaSehirMap){
        return plakaSehirMap.get(n);
}
public static List<String> listOfCities(HashMap<Integer, String> plakaSehirMap){
        ArrayList<String> list= new ArrayList<>();
        for (String string : plakaSehirMap.values()) {
            int last=string.length()-1;
            int total=0;
            for (int i = 0; i < 3; i++) {
                total+=LetterToNumber(string.charAt(last));
                last--;
            }
            System.out.println();
            //System.out.println(string+" : "+CityOfNumber(total-3, plakaSehirMap));
            if(CityOfNumber(total-3, plakaSehirMap)==string)
                list.add(string);
        }
        return list;
    }
}