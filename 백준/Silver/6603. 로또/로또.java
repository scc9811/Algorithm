import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] array;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n= Integer.parseInt(st.nextToken());
            if(n==0) break;

            array = new int[n];
            for (int i=0; i<n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            rotto(0,0);
            bw.write('\n');



        }
        bw.close();



    }
    public static void rotto(int depth, int startIndex)throws IOException{
        if(depth==6){
            bw.write(sb.toString());
            bw.write('\n');
            return;
        }
        for(int i=startIndex; i<n; i++){
            int length = sb.length();
            sb.append(array[i]).append(' ');
            rotto(depth+1,i+1);
            sb.delete(length,sb.length());
        }


    }
}