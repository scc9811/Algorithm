import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int coumputerNum = Integer.parseInt(bf.readLine());
        int connectionNum = Integer.parseInt(bf.readLine());
        int[][] array = new int[connectionNum][2];
        int[] result = new int[coumputerNum+1];
        for (int i=1; i<result.length; i++){
            result[i] = i;
        }

        for (int i=0; i<connectionNum; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());


            int from = result[Integer.parseInt(st.nextToken())];
            int to = result[Integer.parseInt(st.nextToken())];
            int tmp = from;
            if (from > to){
                from = to;
                to = tmp;
            }

            result[to] = result[from];
            for (int j=1; j<result.length; j++)
                if (result[j]==to) result[j]=from;



        }

        int count =0;
        for (int i=2; i<result.length; i++){
            if(result[i]==1) count++;
        }
        System.out.println(count);
        



    }
}
