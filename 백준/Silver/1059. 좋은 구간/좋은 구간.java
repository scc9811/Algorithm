import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] array = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Arrays.sort(array);


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            if(n<=array[i]){
                try{
                    min = array[i-1]+1;
                }
                catch(ArrayIndexOutOfBoundsException ignore){
                    min = 1;
                }
                max = array[i]-1;
                break;
            }
        }

        int step = max-n+1;
        int count =0;
        count += step*(n-min);
        count += step-1;





        if(min-1==n || max+1==n) System.out.println(0);
        else System.out.println(count);










    }
}