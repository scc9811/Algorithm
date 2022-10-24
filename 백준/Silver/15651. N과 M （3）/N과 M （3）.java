import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    static int[] array;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];
        make(0);
        System.out.println(sb);





    }
    static void make(int depth){
        if(depth==m){
            for (int i=0; i<m; i++){
                sb.append(array[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i=1; i<n+1; i++){
            array[depth] = i;
            make(depth+1);
        }

    }
}

