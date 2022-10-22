import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int[] array;
    static int[] printArray;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        printArray = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);





        backTracking(0,0);
        System.out.println(sb);







    }
    public static void backTracking(int depth, int startIndex){
        if(depth==m){
            for(int i=0; i<m; i++){
                sb.append(printArray[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=startIndex; i<n; i++){
            printArray[depth] = array[i];
            backTracking(depth+1, i);
        }





    }
}