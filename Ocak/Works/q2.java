import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {



        HashMap<Character, Integer> listC=new HashMap<>();
        File file = new File("map.txt");
        try {
            Scanner reader= new Scanner(file);

            while(reader.hasNext()){
                
            String line=reader.nextLine();

            for (Character character : line.toCharArray()) {

                listC.putIfAbsent(character, 1);
                if(listC.containsKey(character))
                    listC.put(character, listC.get(character)+1);
                

            }
            reader.close();

        }
            
        } catch (Exception e) {
            
        } 


        for (var character : listC.entrySet()) {
            System.out.println(character.getKey()+" : "+character.getValue());
        }

        System.out.println(listC.size());
        
    }
}
