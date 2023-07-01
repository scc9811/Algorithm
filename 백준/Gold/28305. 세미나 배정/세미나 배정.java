import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n, t, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int lo = 1;
        int hi = 200000;
        int res = n;
        while(lo<=hi){
            int mid = (lo+hi)/2;

            int key = BinarySearch(mid);

            if(key==-1){
                lo = mid+1;
            }
            else {
                res = Math.min(res, key);
                hi = mid - 1;
            }
        }
        System.out.println(res);



    }
    static int BinarySearch(int dup){
        int count = 0;
        int res = 0;
        Queue<Integer> lastPoints = new LinkedList<>();
        for(int i=0; i<n; i++){

            int startT;
            // 최대한 왼쪽으로 붙여서
            if(count<dup){
                if(arr[i]-t<0) startT = 1;
                else startT = arr[i]-t+1;
            }
            else{
                int last = lastPoints.poll();
                count--;
                if(last>=arr[i]) return -1;
//                if(arr[i]-t<0) startT = 1;
//                else startT = arr[i]-t+1;
                startT = last+1;
            }
            // 시간 지난거 제거
            while(!lastPoints.isEmpty() && lastPoints.peek()<startT){
                lastPoints.poll();
                count--;
            }

            lastPoints.add(startT+t-1);
            count++;
            if(count>dup) return -1;
            res = Math.max(res, count);
        }
        return res;
    }
}
