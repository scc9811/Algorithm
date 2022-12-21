import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Queue<Point> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] visited = new int[200001];
        Arrays.fill(visited, (int) 1e9);
        if (n >= m) System.out.println(n - m);
        else {
            queue.add(new Point(0, n));
            visited[n] = 0;
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int sec = p.sec;
                int loc = p.loc;


                if (loc == m) {
                    break;
                }
                if (loc > 0 && sec + 1 < visited[loc - 1]) {
                    queue.add(new Point(sec + 1, loc - 1));
                    visited[loc - 1] = sec + 1;
                }
                if (loc < 200000 && sec + 1 < visited[loc + 1]) {
                    queue.add(new Point(sec + 1, loc + 1));
                    visited[loc + 1] = sec + 1;
                }
                if (loc <= 100000 && sec < visited[2*loc]) {
                    queue.add(new Point(sec, loc * 2));
                    visited[2*loc] = sec;
                }
            }
            System.out.println(visited[m]);


        }


    }

    public static class Point {
        int sec, loc;

        Point(int sec, int loc) {
            this.sec = sec;
            this.loc = loc;
        }
    }
}