import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int k=0; k<testCase; k++) {


            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] array = new int[N][M];
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();

            int m;
            int n;
            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st2.nextToken());
                n = Integer.parseInt(st2.nextToken());
                array[n][m] = 1;
            }


//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(array[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            boolean tf = true;
            while (tf) {
                tf = false;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (array[i][j] == 1) {
                            queue.add(i);
                            queue.add(j);
                            count++;
                            array[i][j] = 0;
                            tf = true;
                            break;
                        }
                    }
                    if (tf == true) break;
                }
                while (!queue.isEmpty()) {
                    n = queue.poll();
                    m = queue.poll();
                    if (n < N - 1 && (array[n + 1][m] == 1)) {
                        queue.add(n + 1);
                        queue.add(m);
                        array[n + 1][m] = 0;
                    }
                    if (m < M - 1 && (array[n][m + 1] == 1)) {
                        queue.add(n);
                        queue.add(m + 1);
                        array[n][m + 1] = 0;
                    }
                    if (n != 0 && (array[n - 1][m] == 1)) {
                        queue.add(n - 1);
                        queue.add(m);
                        array[n - 1][m] = 0;
                    }
                    if (m != 0 && array[n][m - 1] == 1) {
                        queue.add(n);
                        queue.add(m - 1);
                        array[n][m - 1] = 0;
                    }
                }
            }
            System.out.println(count);
        }









    }
}
