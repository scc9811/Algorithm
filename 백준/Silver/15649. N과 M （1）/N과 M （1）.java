import java.io.*;
import java.util.*;


public class Main {
    static boolean[] visited;
    static int[] array;
    static int m,n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        visited = new boolean[n + 1];
        array = new int[m + 1];

        function(0);
        System.out.println(sb);


    }
    public static void function(int depth){
        if (depth==m){
            for (int i=0; i<m; i++){
                sb.append(array[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            visited[i]=true;
            array[depth]=i;
            function(depth+1);
            visited[i]=false;
        }



    }

}
