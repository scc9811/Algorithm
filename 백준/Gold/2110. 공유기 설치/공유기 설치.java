import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, c, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);


        int low = 1;
        int high = (int)1e9;
        int res = 0;
        int mid;
        while (low <= high) {
            mid = (low+high)/2;
//            System.out.println("mid = "+mid);
            int modemCount = modem(mid);
//            System.out.println("modemCount = "+modemCount);
            if(modemCount<c){
                high = mid -1;
            }
//            else if(modemCount==c){
//                res = Math.max(res, mid);
//                low = mid +1;
//            }
            else{
                low = mid +1;
                res = Math.max(res, mid);
            }
        }
        System.out.println(res);




    }
    static int modem(int distance){
        int lastLoc = arr[0];
        int count = 1;
        for(int i=1; i<n; i++){
            if(arr[i]-lastLoc>=distance) {
                count++;
                lastLoc = arr[i];
            }
        }
        return count;
    }
}
