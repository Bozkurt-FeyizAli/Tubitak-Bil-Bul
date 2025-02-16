import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer2 {
    public static void main(String[] args) {
        // char[][] arr = new char[11][11];
        // String s ="TIRALUROSMİEAAYMABFATLKDDABABİSLİNAOGTETFEABONLAAIYÖMDEFAMNŞFAKTAREŞANKADİNNFSASUŞSİNİAİTKIKABAKÇHŞTİRPAŞASEYMÜBİTAKBİLGE";

       
        // char[] all = s.toCharArray();
        
        // int j = 0;  // Row index for the 2D array
        // for (int i = 0; i < all.length && j < 11; i++) {
        //     // Copy 11 characters from the 'all' array to the row of 'arr'
        //     arr[j] = Arrays.copyOfRange(all, i, Math.min(i + 11, all.length));
        //     i += 10;  // Move to the next set of 11 characters
        //     j++;  // Move to the next row in 'arr'
        // }

        // // Transpose the array: convert each column to a row
        // char[][] transposed = new char[11][11];
        // for (int i = 0; i < 11; i++) {
        //     for (int k = 0; k < 11; k++) {
        //         transposed[i][k] = arr[k][i];  // Swap rows and columns
        //     }
        // }

        // // Output the transposed array
        // // for (int i = 0; i < transposed.length; i++) {
        // //     System.out.println(Arrays.toString(transposed[i]));
        // // }
        

        // // charrArr2d(transposed);

        // int[][] inta= new int[11][11];
        // for (int i = 0; i < inta.length; i++) {
        //     for (int k = 0; k < inta.length; k++) {
        //         inta[i][k]=LetterToNumber(transposed[i][k]);
        //     }
        // }

        // for (int[] is : inta) {
        //     for (int is2 : is) {
        //         System.out.print(is2+" ");
        //     }
        //     System.out.println();
        // }

        // aNumbertimes(inta, "1923");
        // System.out.println();

        // for (int[] is : inta) {
        //     for (int is2 : is) {
        //         System.out.print(is2+" ");
        //     }
        //     System.out.println();
        // }
        
        String[] words={"Teknofest" , //
                        "Tübitakbilgem" , //
                        "Şifrebilimsoruları" , //
                        "Adana" , //
                        "Şakirpaşa" , //
                        "seyhan" , //
                        "Adaltaf" , //
                        "bamyadolması" , //
                        "kabakçintmesi" ,//
                        "babagannuş" , //
                        "siniköfte" , //
                        "taşkadayıf"};
        String s= words[8];
        char[] c=s.toCharArray();
        int[] arr= new int[c.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=LetterToNumber(c[i])-1;
        }
        ötele(arr, "05011922");

        for (int i : arr) {
            System.out.println(i);
        }
        ArrayList<Integer> subset= new ArrayList<>();

        
        System.out.println(isArrange(arr, 68, subset, 0));
        for (int iterable_element : subset) {
            System.out.println(iterable_element);
        }


    }

    public static boolean isArrange(int[] arr, int res, List<Integer> subset, int index) {
        // Base case: If the remaining sum is 0, we found a valid subset
        if (res == 0) {
            return true;
        }

        // If we've reached the end of the array or the remaining sum is negative, backtrack
        if (index >= arr.length || res < 0) {
            return false;
        }

        // Include the current element in the subset
        subset.add(arr[index]);
        if (isArrange(arr, res - arr[index], subset, index + 1)) {
            return true;
        }

        // Exclude the current element from the subset
        subset.remove(subset.size() - 1);
        return isArrange(arr, res, subset, index + 1);
    }

    public static void ötele(int[] arr, String s){
        int i=0;
        for (char si : s.toCharArray()) {
            arr[i]=arr[i]+si-48;
            if(arr[i]>28) arr[i]-=28;
            i++;
        }
    }

    public static void aNumbertimes(int[][] arr, String ti){
        
        int i=0;
        for (char c: ti.toCharArray()) {
            rotateDowninColoumn(arr, i, c-48);
            i++;
        }
    }

    public static void rotateDowninColoumn(int[][] arr, int col, int ti) { 
        // ti kadar döndürme işlemi yapılacak
        for (int i = 0; i < ti; i++) {
            // Sütunun son elemanını sakla
            int emp = arr[arr.length - 1][col];
            
            // Sütundaki elemanları bir aşağı kaydır
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j][col] = arr[j - 1][col];  // Bir önceki satırı geçerli satıra taşı
            }
            
            // İlk sıraya, sakladığımız son elemanı yerleştir
            arr[0][col] = emp;
        }
    }

    

    public static void rotateUpinColoumn(int[][] arr, int col, int ti) { 
        // ti kadar döndürme işlemi yapılacak (sütunları yukarı kaydırma)
        for (int i = 0; i < ti; i++) {
            // Sütunun ilk elemanını sakla
            int emp = arr[0][col];
            
            // Sütundaki elemanları bir yukarı kaydır
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j][col] = arr[j + 1][col];  // Bir sonraki satırı geçerli satıra taşı
            }
            
            // Son sıraya, sakladığımız ilk elemanı yerleştir
            arr[arr.length - 1][col] = emp;
        }
    }

    public static void aNumbertimesRow(int[][] arr, String ti){
        
        int i=0;
        for (char c: ti.toCharArray()) {
            rotateRow(arr, i, c-48);
            i++;
        }
    }

    public static void rotateRow(int[][] arr, int row, int ti) {
        // ti kadar döndürme işlemi yapılacak (satır sağa kaydırma)
        for (int i = 0; i < ti; i++) {
            // Satırın son elemanını sakla
            int emp = arr[row][arr[row].length - 1];
            
            // Satırdaki elemanları bir sağa kaydır
            for (int j = arr[row].length - 1; j > 0; j--) {
                arr[row][j] = arr[row][j - 1];
            }
            
            // İlk sıraya, sakladığımız son elemanı yerleştir
            arr[row][0] = emp;
        }
    }

    public static void rotateRightinRow(int[][] arr, int row, int ti) {
        // ti kadar döndürme işlemi yapılacak (satır sağa kaydırma)
        for (int i = 0; i < ti; i++) {
            // Satırın son elemanını sakla
            int emp = arr[row][arr[row].length - 1];
            
            // Satırdaki elemanları bir sağa kaydır
            for (int j = arr[row].length - 1; j > 0; j--) {
                arr[row][j] = arr[row][j - 1];
            }
            
            // İlk sıraya, sakladığımız son elemanı yerleştir
            arr[row][0] = emp;
        }
    }

    //

    public static void aNumbertimes(char[][] arr, String ti){
        
        int i=0;
        for (char c: ti.toCharArray()) {
            rotateDowninColoumn(arr, i, c-48);
            i++;
        }
    }

    public static void rotateDowninColoumn(char[][] arr, int col, int ti) { 
        // ti kadar döndürme işlemi yapılacak
        for (int i = 0; i < ti; i++) {
            // Sütunun son elemanını sakla
            char emp = arr[arr.length - 1][col];
            
            // Sütundaki elemanları bir aşağı kaydır
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j][col] = arr[j - 1][col];  // Bir önceki satırı geçerli satıra taşı
            }
            
            // İlk sıraya, sakladığımız son elemanı yerleştir
            arr[0][col] = emp;
        }
    }

    

    public static void rotateUpinColoumn(char[][] arr, int col, int ti) { 
        // ti kadar döndürme işlemi yapılacak (sütunları yukarı kaydırma)
        for (int i = 0; i < ti; i++) {
            // Sütunun ilk elemanını sakla
            char emp = arr[0][col];
            
            // Sütundaki elemanları bir yukarı kaydır
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j][col] = arr[j + 1][col];  // Bir sonraki satırı geçerli satıra taşı
            }
            
            // Son sıraya, sakladığımız ilk elemanı yerleştir
            arr[arr.length - 1][col] = emp;
        }
    }

    public static void aNumbertimesRow(char[][] arr, String ti){
        
        int i=0;
        for (char c: ti.toCharArray()) {
            rotateRow(arr, i, c-48);
            i++;
        }
    }

    public static void rotateRow(char[][] arr, int row, int ti) {
        // ti kadar döndürme işlemi yapılacak (satır sağa kaydırma)
        for (int i = 0; i < ti; i++) {
            // Satırın son elemanını sakla
            char emp = arr[row][arr[row].length - 1];
            
            // Satırdaki elemanları bir sağa kaydır
            for (int j = arr[row].length - 1; j > 0; j--) {
                arr[row][j] = arr[row][j - 1];
            }
            
            // İlk sıraya, sakladığımız son elemanı yerleştir
            arr[row][0] = emp;
        }
    }

    public static void rotateRightinRow(char[][] arr, int row, int ti) {
        // ti kadar döndürme işlemi yapılacak (satır sağa kaydırma)
        for (int i = 0; i < ti; i++) {
            // Satırın son elemanını sakla
            char emp = arr[row][arr[row].length - 1];
            
            // Satırdaki elemanları bir sağa kaydır
            for (int j = arr[row].length - 1; j > 0; j--) {
                arr[row][j] = arr[row][j - 1];
            }
            
            // İlk sıraya, sakladığımız son elemanı yerleştir
            arr[row][0] = emp;
        }
    }
    
 
    public static char[][] translate(char[][] arr){
        char[][] result= new char[arr.length][arr[1].length];
        for (int i = 0, j=0; i < arr.length; i++) {
            result[i][j]=arr[j][i];
            if(i==10){i=0; j++;}
            if(j==10) break;
        }
        return result;
    }

    public static void charrArr1d(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void charrArr2d(char[][] arr) {
        for (char[] c : arr) {
            charrArr1d(c);
            System.out.println();
        }
    }

    public static int LetterToNumber(char c){
        c=Character.toLowerCase(c);
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
}
