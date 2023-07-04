import javax.swing.text.Segment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        par = new int[n];
        for(int i=0; i<n; i++){
            par[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
            int cur = Integer.parseInt(st.nextToken());
            int min = (int)1e9;
            int lo = 0;
            int hi = n-1;
            while(lo<=hi){
                int mid = (lo + hi)/2;
                if(arr[find(mid)] <= cur){
                    lo = mid+1;
                }
                else{
                    min = Math.min(min, mid);
                    hi = mid-1;
                }
            }
            sb.append(arr[min]).append('\n');
            if(min!=0) union(min, min-1);
        }
        System.out.println(sb);













    }
    static int[] par;
    static int find(int a){
        if(a==par[a]) return a;
        return par[a] = find(par[a]);
    }
    static boolean union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a!=p_b) {
            par[p_a] = p_b;
            return true;
        }
        return false;
    }
}
