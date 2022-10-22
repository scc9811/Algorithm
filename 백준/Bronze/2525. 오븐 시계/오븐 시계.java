import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());

        h = (h+(m+c)/60)%24;
        m = (m+c)%60;
        sb.append(h).append(" ").append(m);



        bw.write(sb.toString());
        bw.close();


    }
}
