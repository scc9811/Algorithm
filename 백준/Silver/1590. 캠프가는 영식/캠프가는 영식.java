import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());



        boolean[] array = new boolean[1000001];

        int start, step, count;
        // minTime == 최소 대기시간
        int minTime = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            step = Integer.parseInt(st.nextToken());
            count = Integer.parseInt(st.nextToken());

            int lo = 0;
            int hi = count-1;
            int mid = -1;
            while(lo <= hi){
                mid = (lo+hi)/2;

                // k == mid 번째 버스 도착시간
                int k = start + step*mid;

                // 영식이 도착시간 == mid 번째 버스 도착시간
                if(t==k) {
                    minTime = 0;
                    break;
                }
                // 영식 < mid 버스
                else if(t < k){
                    minTime = Math.min(minTime, k-t);
                    hi = mid -1;
                }
                // 영식 > mid 버스
                else{
                    lo = mid +1;
                }
            }





        }
        if(minTime==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minTime);


















    }
}