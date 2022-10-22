import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int[] array = new int[size+1];
        int testCase = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        array[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=size; i++){
            array[i] = array[i-1] + Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(array[end]-array[start-1]).append('\n');
        }

        System.out.println(sb);



    }
}
