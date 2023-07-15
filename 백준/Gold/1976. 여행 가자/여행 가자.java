import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        par = new int[n+1];
        for(int i=1; i<=n; i++){
            par[i] = i;
        }
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                if(Integer.parseInt(st.nextToken())==1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<m; i++){
            set.add(find(Integer.parseInt(st.nextToken())));
        }
        System.out.println(set.size()==1 ? "YES" : "NO");


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