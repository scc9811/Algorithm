import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] whole = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        whole[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++) {
            whole[i] = Math.max(whole[i-1], Integer.parseInt(st.nextToken()) + i);
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<q; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int l = 0;
            int r = n-1;
            int mid;
            int res = r;
            while(l <= r) {
                mid = (l + r) / 2;
                if(whole[mid] >= cur) {
                    res = Math.min(res, mid);
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            sb.append(res+1).append(' ');
        }
        System.out.println(sb);
















    }
}