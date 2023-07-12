import java.io.*;
import java.util.*;
public class Main{
    static int count, capacity[], rain[], cityCount[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        capacity = new int[n+1];
        rain = new int[n+1];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        count = 0;
        for(int i=1; i<=n; i++){
            capacity[i] = Integer.parseInt(st.nextToken());
            rain[i] = Integer.parseInt(st2.nextToken());
            if(capacity[i] < rain[i]) count++;
        }
        par = new int[n+1];
        for(int i=1; i<=n; i++){
            par[i] = i;
        }
        cityCount = new int[n+1];
        Arrays.fill(cityCount, 1);



        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if(flag==1){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            else{
                sb.append(count).append('\n');
            }
        }
        System.out.println(sb);


    }
    static int[] par;
    static int find(int a){
        if(a==par[a]) return a;
        return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a != p_b) {
            if(capacity[p_a] < rain[p_a]) count -= cityCount[p_a];
            if(capacity[p_b] < rain[p_b]) count -= cityCount[p_b];
            capacity[p_a] += capacity[p_b];
            rain[p_a] += rain[p_b];
            cityCount[p_a] += cityCount[p_b];
            if(capacity[p_a] < rain[p_a]) count += cityCount[p_a];
            par[p_b] = p_a;
        }
    }
}
