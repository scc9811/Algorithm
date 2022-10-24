import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    static boolean[] visited;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m];
        visited = new boolean[n+1];
        function(0);
        System.out.println(sb);




    }
    public static void function(int depth){
        if (depth==m){
            for (int i=0; i<m; i++){
                sb.append(array[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        try{
            for (int i=array[depth-1]; i<=n; i++){
                if (visited[i]) continue;
                visited[i]=true;
                array[depth] = i;
                function(depth+1);
                visited[i]=false;
            }
        }
        catch(ArrayIndexOutOfBoundsException ignore){
            for (int i=1; i<=n; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                array[depth] = i;
                function(depth + 1);
                visited[i] = false;
            }
        }





    }
}
