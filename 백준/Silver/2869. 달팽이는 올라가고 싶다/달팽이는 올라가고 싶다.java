import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int go = Integer.parseInt(st.nextToken());
        int back = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int step = go-back;
        height -= go;

        if(height%step==0) System.out.println(height/step+1);
        else System.out.println(height/step+2);







    }
}