import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n,m;
    static int[] array, printArray;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        array = new int[n];
        printArray = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        backTracking(0);
        System.out.println(sb);




    }
    public static void backTracking(int depth){
        if(depth==m){
            for(int i=0; i<m; i++){
                sb.append(printArray[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            visited[i]=true;
            printArray[depth] = array[i];
            backTracking(depth+1);
            visited[i]=false;
        }




    }
}