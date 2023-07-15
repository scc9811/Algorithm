import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        par = new int[n+1];
        for(int i=1; i<=n; i++){
            par[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for(int i=0; i<count; i++){
            par[Integer.parseInt(st.nextToken())] = 0;
        }

        List<Integer>[] lists = new List[m];
        for(int i=0; i<m; i++){
            lists[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());
            lists[i].add(Integer.parseInt(st.nextToken()));
            for(int j=1; j<count; j++){
                int cur = Integer.parseInt(st.nextToken());
                union(cur,  lists[i].get(j-1));
                lists[i].add(cur);
            }
        }



        int res = 0;
        for(int i=0; i<m; i++){
            boolean flag = true;
            for(int j : lists[i]){
                if(find(j)==0) flag = false;
            }
            if(flag) res++;
        }
        System.out.println(res);




    }


    static int[] par;
    static int find(int a) {
        if (par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a<p_b) par[p_b] = p_a;
        else par[p_a] = p_b;
    }
}