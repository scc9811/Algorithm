import java.util.*;
import java.io.*;

public class Main{
    static int n, m, par[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        par = new int[n+1];
        for(int i=1; i<=n; i++){
            par[i] = i;
        }

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                if(st.nextToken().charAt(0) == '1'){
                    union(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int group = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<m; i++){
            if(group != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
        System.exit(0);







    }
    static int find(int a){
        if(par[a] != a) return par[a] = find(par[a]);
        return a;
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        par[p_a] = p_b;
    }
}