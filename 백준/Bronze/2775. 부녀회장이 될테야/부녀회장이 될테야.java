import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
    static int[][] array = new int[15][15];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<15; i++){
            array[1][i]=i*(i+1)/2;
        }

        for(int i=2; i<15; i++){
            array[i][1] = array[i-1][1];
            for(int j=2; j<15; j++){
                array[i][j]=array[i][j-1]+array[i-1][j];
            }
        }


        while(testCase-->0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(array[k][n]).append('\n');




        }
        System.out.println(sb);





    }
}