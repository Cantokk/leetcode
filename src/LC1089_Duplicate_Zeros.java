import java.util.Arrays;

public class LC1089_Duplicate_Zeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] a = Arrays.copyOf(arr, n);
        int p = 0;
        for(int i = 0;i < n;i++){
            if(a[i] == 0){
                if(p < n)arr[p++] = 0;
                if(p < n)arr[p++] = 0;
            }else{
                if(p < n)arr[p++] = a[i];
            }
        }
    }
}
