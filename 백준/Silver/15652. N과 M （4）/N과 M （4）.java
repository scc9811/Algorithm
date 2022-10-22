import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        backTracking(0,1);
        bw.close();








    }
    public static void backTracking(int depth, int startIndex) throws IOException {
        if(depth==m){
            bw.write(sb.toString());
            bw.write('\n');
            return;
        }

        for(int i=startIndex; i<n+1; i++){
            sb.append(i).append(' ');
            backTracking(depth+1,i);
            sb.delete(sb.length()-2,sb.length());
        }
    }
}

