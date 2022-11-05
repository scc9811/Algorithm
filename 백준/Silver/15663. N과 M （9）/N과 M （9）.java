import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main{
    static int n, m, arr[], store[];
    static StringBuilder result = new StringBuilder();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        store = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTracking(0);
        System.out.println(result);

















    }
    static boolean[] visited;
    static void backTracking(int depth){
        if(depth==m){
            StringBuilder tmp = new StringBuilder();
            for(int i=0; i<m; i++){
                tmp.append(store[i]).append(' ');
            }
            tmp.append('\n');
            if(!set.contains(tmp.toString())){
                result.append(tmp);
                set.add(tmp.toString());
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                store[depth] = arr[i];
                visited[i] = true;
                backTracking(depth+1);
                visited[i] = false;
            }
        }





    }
}