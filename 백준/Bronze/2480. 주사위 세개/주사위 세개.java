import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        int result;
        if(first==second && second==third){
            result = 10000+first*1000;
        }
        else if (first!=second && second!=third && first!=third){
            result = Math.max(Math.max(first,second),third)*100;
        }
        else if (first==second) result = 1000+first*100;
        else result = 1000+third*100;

        bw.write(String.valueOf(result));
        bw.close();

    }
}
