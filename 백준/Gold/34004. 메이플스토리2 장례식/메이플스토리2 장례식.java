import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        arr[1] = 4;
        arr[2] = 2;
        arr[3] = 2;
        arr[4] = 0;
        int lastIdx = 4;
        for(int i=3; i<=100; i++) {
            arr[lastIdx+1] = 2;
            arr[lastIdx+i] = 2;
            lastIdx = lastIdx + (i*2-1);
        }

        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            int tmp = 1;
            while (tmp*tmp*tmp <= n) {
                tmp++;
            }
            tmp--;
            int res = (tmp*tmp)*6;
            int diff = n - tmp*tmp*tmp;

//            System.out.println("tmp = " + tmp);
            for(int i=1; i<=tmp*tmp; i++) {
                if(diff == 0) break;
                res += arr[i];
                diff--;
            }
//            System.out.println("res1 = " + res);

            for(int i=1; i<=tmp*tmp; i++) {
                if(diff == 0) break;
                res += arr[i];
                diff--;
            }
//            System.out.println("res2 = " + res);

            // ahtjfl
            if (diff >= 1) {
                res += 2;
                diff -= tmp;
            }
//            System.out.println("res3 = " + res);
//            System.out.println("diff = " + diff);

            if (diff >= 1) {
                for (int i=1; i <= Math.min((tmp+1)*(tmp+1), diff); i++) {
                    res += arr[i];
                }
            }
//            System.out.println("res4 = " + res);
            sb.append(res);


            sb.append('\n');
        }




        System.out.println(sb);







    }
}