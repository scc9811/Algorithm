import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        par = new int[n+1];
        for(int i=0; i<=n; i++){
            par[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(flag==0){
                union(a, b);
            }
            else{
                int p_a = find(a);
                int p_b = find(b);
                sb.append(p_a==p_b ? "YES" : "NO").append('\n');
            }
        }
        System.out.println(sb);


    }

    static int[] par;

    static int find(int a) {
        if (par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        par[p_a] = p_b;
    }
}