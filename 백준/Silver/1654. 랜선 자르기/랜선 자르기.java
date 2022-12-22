import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k, n, len[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        len = new int[k];
        int max = 0;
        for(int i=0; i<k; i++){
            len[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, len[i]);
        }
        long le = 1;
        long ri = max;
        long res = 0;
        while(le<=ri){
            long mid = (le+ri)/2;
            if(count(mid)<n){
                ri = mid-1;
            }
            else{
                res = Math.max(res, mid);
                le = mid+1;
            }
        }
        System.out.println(res);




    }
    // n길이로 자른 경우 나오는 랜선 개수
    public static long count(long n){
        long count = 0;
        for(int i=0; i<k; i++){
            count += len[i]/n;
        }
        return count;
    }
}