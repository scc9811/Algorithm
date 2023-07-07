import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1;
        for (int i = n; i >= 2; i--) {
            if (arr[i - 1] > arr[i]) {
                idx = i - 1;
                break;
            }
        }
        if (idx == -1) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= idx - 1; i++) {
                sb.append(arr[i]).append(' ');
                visited[arr[i]] = true;
            }


            for (int i = arr[idx] - 1; i >= 1; i--) {
                if (!visited[i]) {
                    sb.append(i).append(' ');
                    visited[i] = true;
                    break;
                }
            }
            for (int i = n; i >= 1; i--) {
                if (!visited[i]) {
                    sb.append(i).append(' ');
                }
            }
            System.out.println(sb);
        }


    }
}
