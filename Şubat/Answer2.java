import java.util.Arrays;

public class Answer2 {
    public static void main(String[] args) {
        char[][] arr = new char[11][11];
        String s ="TIRALUROSMİEAAYMABFATLKDDABABİSLİNAOGTETFEABONLAAIYÖMDEFAMNŞFAKTAREŞANKADİNNFSASUŞSİNİAİTKIKABAKÇHŞTİRPAŞASEYMÜBİTAKBİLGE";

       
        char[] all = s.toCharArray();
        
        int j = 0;  // Row index for the 2D array
        for (int i = 0; i < all.length && j < 11; i++) {
            // Copy 11 characters from the 'all' array to the row of 'arr'
            arr[j] = Arrays.copyOfRange(all, i, Math.min(i + 11, all.length));
            i += 10;  // Move to the next set of 11 characters
            j++;  // Move to the next row in 'arr'
        }

        // Transpose the array: convert each column to a row
        char[][] transposed = new char[11][11];
        for (int i = 0; i < 11; i++) {
            for (int k = 0; k < 11; k++) {
                transposed[i][k] = arr[k][i];  // Swap rows and columns
            }
        }

        // Output the transposed array
        // for (int i = 0; i < transposed.length; i++) {
        //     System.out.println(Arrays.toString(transposed[i]));
        // }
        

        // charrArr2d(transposed);

        int[][] inta= new int[11][11];
        for (int i = 0; i < inta.length; i++) {
            for (int k = 0; k < inta.length; k++) {
                inta[i][k]=LetterToNumber(transposed[i][k]);
            }
        }

        for (int[] is : inta) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }

        aNumbertimes(inta, "1923");
        System.out.println();

        for (int[] is : inta) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
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
