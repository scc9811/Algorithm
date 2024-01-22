import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, a, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long l = 1;
        long r = (long)1e10;
        long mid;
        long res = r;
        while(l<=r){
            mid = (l+r)/2;
//            System.out.println("mid = "+mid);
            if (isValid(mid)) {
                r = mid-1;
                res = Math.min(res, mid);
            }
            else{
                l = mid+1;
            }
        }
        System.out.println(res);















    }
    static boolean isValid(long skillScore) {
        long totalScore = 0;
        for(int i=0; i<m; i++){
            int l = 0;
            int r = n-1;
            int mid;
            int res = 0;
            while(l<=r){
                mid = (l+r)/2;
                if(arr[mid] <= skillScore){
                    res = Math.max(res, arr[mid]);
                    l = mid+1;
                }
                else r = mid-1;
            }
            totalScore += res;
            skillScore += res;
        }
//        System.out.println("totalScore = "+totalScore);
        return totalScore >= a;
    }
}