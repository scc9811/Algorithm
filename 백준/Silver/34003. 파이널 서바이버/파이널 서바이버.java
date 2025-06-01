import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][8];
        int total = 0;
        for(int i=0; i<8; i++) {
            String s = br.readLine();
            for(int j=0; j<8; j++) {
                if(s.charAt(j) == 'O') {
                    arr[i][j] = 1;
                    total++;
                }
            }
        }

        int max = -1;
        int x = -1;
        int y = -1;

        int[] dx = {0,1,0,1};
        int[] dy = {0,0,1,1};
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                int sum = 0;
                for(int k=0; k<4; k++) {
                    sum += arr[i+dx[k]][j+dy[k]];
                }
                if (sum > max) {
                    max = sum;
                    x = i+1;
                    y = j+1;
                }
            }
        }

        System.out.printf("%d %d\n", x, y);
        double res = 1.0;
        if (total - max >= 4) {
            int tmp = (total * (total-1) * (total-2) * (total-3)) / (4*3*2);

            int k = total-max;
            int t = total - max - 4;
            int tmp2 = comb(k, t);
            res = 1 - ((double) tmp2) / ((double) tmp);

//            System.out.println("tmp = " + tmp);
//            System.out.println("tmp2 = " + tmp2);
//            System.out.println("k  = " + k);
//            System.out.println("t = " + t);
        }
        System.out.println(res);




    }
    static int comb(int n, int k) {
        if (k > n/2) k = n-k;
        int res = 1;
        for(int i=0; i<k; i++) {
            res *= n;
            n--;
        }
        for(int i=1; i<=k; i++) {
            res /= i;
        }
        return res;
    }
}