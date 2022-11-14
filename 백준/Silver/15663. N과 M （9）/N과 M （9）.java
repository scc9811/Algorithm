import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m, arr[];
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        store = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTracking(0);
        System.out.println(result);





    }
    static int[] store;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    public static void backTracking(int depth){
        if(depth==m){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<m; i++){
                sb.append(store[i]).append(' ');
            }
            sb.append('\n');
            if(!set.contains(sb.toString())){
                result.append(sb);
                set.add(sb.toString());
            }

            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            store[depth] = arr[i];
            visited[i] = true;
            backTracking(depth+1);
            visited[i] = false;
        }






    }
}
