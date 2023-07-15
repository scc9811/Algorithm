import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            int f = Integer.parseInt(br.readLine());
            int nameCount = 1;
            Connection[] arr = new Connection[f];
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<f; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                if(!map.containsKey(s1)) map.put(s1, nameCount++);
                if(!map.containsKey(s2)) map.put(s2, nameCount++);
                arr[i] = new Connection(map.get(s1), map.get(s2));
            }
            par = new int[nameCount];
            for(int i=1; i<nameCount; i++){
                par[i] = i;
            }
            count = new int[nameCount];
            Arrays.fill(count, 1);
            for(Connection c : arr){
                union(c.from, c.to);
                sb.append(count[find(c.from)]).append('\n');
            }

        }
        System.out.println(sb);


    }
    static class Connection{
        int from, to;
        Connection(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

    static int[] par, count;

    static int find(int a) {
        if (par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a != p_b) {
            count[p_a] += count[p_b];
            par[p_b] = p_a;
        }

    }
}