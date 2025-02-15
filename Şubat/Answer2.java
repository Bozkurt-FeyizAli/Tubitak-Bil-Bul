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
