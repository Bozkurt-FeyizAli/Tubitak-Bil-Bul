import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

public class fifth{
    public static void main(String[] args) {
        List<List<Integer>> lists= Arrays.asList(
            Arrays.asList(4,28,3,24,14,14,7,1,12,22,14),
            Arrays.asList(25,26,6,25,1,1,6,15,16,6,18),
            Arrays.asList(14,21,28,7,21,21,14,1,1,28,29),
            Arrays.asList(25,6,10,1,1,1,6,5,16,10,1),
            Arrays.asList(21,9,1,17,24,12,28,1,18,1,17),
            //Arrays.asList(18,12,17,2,1,22,25,9,9,17,28),
            // Arrays.asList(27,21,22,6,23,1,16,14,15,22,26),
            // Arrays.asList(1,1,6,28,22,15,25,1,25,1,21),
            Arrays.asList(22,15,28,15,1,12,21,21,3,12,6),
            Arrays.asList(1,1,10,12,12,7,24,1,6,16,9),
            Arrays.asList(21,5,1,20,16,6,1,12,28,2,12),
            Arrays.asList(12,1,17,18,2,14,15,22,10,6,21),
            Arrays.asList(4,9,7,29,6,6,12,1,1,28,22),
            Arrays.asList(1,12,6,1,28,4,14,15,17,15,1),
            Arrays.asList(16,16,14,17,15,25,22,12,20,12,12),
            Arrays.asList(22,1,6,24,12,14,1,1,18,1,16),
            Arrays.asList(6,16,14,12,14,25,21,15,29,15,2),
            Arrays.asList(28,18,18,7,18,21,12,1,1,1,6),
            Arrays.asList(10,9,29,6,29,18,4,5,17,5,28),
            Arrays.asList(1,15,1,14,1,27,1,1,24,1,15),
            Arrays.asList(17,25,17,6,17,1,16,9,12,9,12)
        );
        int[] keylist={16, 8, 3, 7, 1, 1, 3, 23, 3, 9, 3, 17, 16, 23, 3, 19, 3, 14};
        System.out.println(doesAllHaveSameD(lists, keylist, 2));
        ArrayList<Integer> result= new ArrayList<>();
        int index=0;
        for (List<Integer> list : lists) {
            int difference=0;
            for (int i : list) {
                difference=difference(keylist[index], i);
                if(doesAllHaveSameD(lists, keylist, difference))
                    result.add(difference);
            }
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static int difference(int n, int m){
        int difference=n-m;
        if(difference>0) return difference;
        return 29+difference;
    }

    public static boolean doesAllHaveSameD(List<List<Integer>> lists, int[] keylist, int difference) {
        int len = keylist.length;
    
        for (int i = 0; i < len; i++) {
            List<Integer> list = lists.get(i);
            boolean isDifferenceFound = false;
    
            for (Integer integer : list) {
                int dif = difference(keylist[i], integer);
                if (dif == difference) {
                    isDifferenceFound = true;
                    break;
                }
            }
    
            // Eğer bu listedeki hiçbir eleman verilen farkı sağlamıyorsa false döndür
            if (!isDifferenceFound) {
                return false;
            }
        }
    
        // Eğer tüm listelerde fark bulunduysa true döndür
        return true;
    }
    
    
}
