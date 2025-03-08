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

    public static boolean checkConsecutiveSubset(int[] arr, int res) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum == res) {
                    return true;
                }
                if (currentSum > res) {
                    break; // Toplam res'ten büyükse iç döngüyü sonlandır
                }
            }
        }
        return false;
    }

    // Baştan ve sondan seçilen elemanların toplamını kontrol eder
    public static boolean checkStartEndSubset(int[] arr, int res) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (arr[left] + arr[right] == res) {
                return true;
            } else if (arr[left] + arr[right] < res) {
                left++; // Toplam res'ten küçükse sol tarafı artır
            } else {
                right--; // Toplam res'ten büyükse sağ tarafı azalt
            }
        }
        return false;
    }

    public static boolean baştanSondanToplamıVarMı(int[] arr, int st, int fn, int res, boolean bool){
        if(res==0) return true;
        if(res<0) return false;
        if(st>fn) return false;
        if(st==fn&&arr[st]!=res) return false;
        if(bool){
            res-=arr[st];
            return baştanSondanToplamıVarMı(arr, st+1, fn, res, !bool);
        }
        else{
            res-=arr[fn];
            return baştanSondanToplamıVarMı(arr, st+1, fn, res, !bool);
        }
    }

    public static boolean isSubsetSum(int[] arr, int n, int res) {
        // Eğer res 0 ise, boş küme toplamı 0'dır, bu yüzden true döner.
        if (res == 0) {
            return true;
        }
        // Eğer n 0 ise ve res 0 değilse, hiçbir alt küme toplamı res'e eşit olamaz.
        if (n == 0) {
            return false;
        }
        // Eğer son eleman res'ten büyükse, bu elemanı alt kümeye dahil etmeyiz.
        if (arr[n - 1] > res) {
            return isSubsetSum(arr, n - 1, res);
        }
        // Son elemanı alt kümeye dahil edip etmeme durumlarını kontrol ederiz.
        return isSubsetSum(arr, n - 1, res) || isSubsetSum(arr, n - 1, res - arr[n - 1]);
    }

    public static boolean ilkNdeToplamıVarMı(int[] arr, int index, int res){
        if(index<0||index>=arr.length) return false;
        if(arr[index]>res) return false;
        if(arr[index]==res) return true;
        res-=arr[index];
        return ilkNdeToplamıVarMı(arr, index+1, res);
    }
}
