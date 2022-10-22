import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = i;
        }
        Arrays.sort(array, Comparator.comparing(o1 -> o1[0]));

        int tmp = array[0][0];
        array[0][0] = 0;
        for(int i=1; i<n; i++){
            if(tmp==array[i][0]) array[i][0]=array[i-1][0];
            else{
                tmp = array[i][0];
                array[i][0] = array[i-1][0]+1;
            }
        }

        Arrays.sort(array, Comparator.comparing(o1 -> o1[1]));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(array[i][0]).append(' ');
        }
        System.out.println(sb);














    }
}