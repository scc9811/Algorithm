import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while(size-->0){
            int k = Integer.parseInt(st.nextToken());
            if (k<n) sb.append(k+" ");
        }
        sb.delete(sb.length()-1,sb.length());
        bw.write(sb.toString());
        bw.close();

    }
}
