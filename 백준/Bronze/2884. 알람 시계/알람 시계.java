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

        if(m>=45){
            sb.append(h).append(" ").append(m-45);
            bw.write(sb.toString());
        }
        else if (h==0) {
            sb.append(23).append(" ").append(m+60-45);
            bw.write(sb.toString());
        }
        else {
            sb.append(h-1).append(" ").append(m+60-45);
            bw.write(sb.toString());
        }
        bw.close();
    }
}
