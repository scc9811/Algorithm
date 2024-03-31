import java.util.*;
import java.io.*;

public class Main {
    static int n, halfIdx, m;
//    static long lSum, rSum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        long totalP = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalP += arr[i];
        }
        Arrays.sort(arr);
        long halfP = (totalP + 1) / 2;
        long sum = 0;
        halfIdx = n-1;
        for(int i=n-1; i>=0; i--){
            sum += arr[i];
            if(sum >= halfP){
                halfIdx = i;
                break;
            }
        }

//        rSum = sum;
//        lSum = totalP - rSum;


        int res = 0;
        int l = 1;
        int r = m;
        int mid;
        while(l <= r){
            mid = (l+r)/2;
//            System.out.println("mid = "+mid);

            if(isValid(mid)){
                res = Math.max(res, mid);
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }


        System.out.println(res);

















    }
    static boolean isValid(int myBudget){
//        System.out.println("value = "+((long)myBudget * (n-halfIdx)  + myBudget));
        if((long)myBudget * (n-halfIdx) + myBudget <= m) return true;
        return false;
    }
}
