import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n0 = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            int m0 = max[0];
            int m1 = max[1];
            int m2 = max[2];
            max[0] = n0 + Math.max(m0, m1);
            max[1] = n1 + Math.max(Math.max(m0, m1), m2);
            max[2] = n2 + Math.max(m1, m2);


            m0 = min[0];
            m1 = min[1];
            m2 = min[2];
            min[0] = n0 + Math.min(m0, m1);
            min[1] = n1 + Math.min(Math.min(m0, m1), m2);
            min[2] = n2 + Math.min(m1, m2);

//            System.out.println(Arrays.toString(max));
//            System.out.println(Arrays.toString(min));
        }
        System.out.print(Math.max(Math.max(max[0], max[1]), max[2])+" ");
        System.out.print(Math.min(Math.min(min[0], min[1]), min[2]));



    }
}