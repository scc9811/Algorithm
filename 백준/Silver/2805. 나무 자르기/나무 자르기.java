import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int trees = Integer.parseInt(st.nextToken());
        int needs = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[trees];
        long sum = 0;
        for (int i=0; i<trees; i++){
            array[i] = Integer.parseInt(st.nextToken());
            sum += array[i];
        }


        Arrays.sort(array);
        sum = sum- (long) array[0] *array.length;
        long result = array[0];
        int plus = array.length;
        for(int i=1; i<array.length; i++){
            if (sum<needs) {
                plus = array.length-i+1;
                break;
            }
            long tmp = array[i]-array[i-1];
            sum = sum-(tmp)*(array.length-i);
            result += tmp;
        }

        result = result-(needs-sum)/plus;
        if ((needs-sum)%plus!=0) result--;
        System.out.println(result);




















    }
}
