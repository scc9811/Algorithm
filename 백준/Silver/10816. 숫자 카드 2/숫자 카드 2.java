import java.io.*;
import java.util.*;


public class Main {
    static int[] array = new int[20000001];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (size-->0){
            array[Integer.parseInt(st.nextToken())+10000000]++;
        }

        int testCase = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){

            sb.append(array[Integer.parseInt(st.nextToken())+10000000]).append(' ');
        }
        sb.delete(sb.length()-1,sb.length());
        bw.write(sb.toString());
        bw.close();

    }

}
