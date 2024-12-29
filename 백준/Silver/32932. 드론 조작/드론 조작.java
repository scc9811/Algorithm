import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 0 -> -500,   500 -> 0,   1000 -> 500
        boolean[][] isObstacle = new boolean[1001][1001];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            isObstacle[Integer.parseInt(st.nextToken()) + 500][Integer.parseInt(st.nextToken()) + 500] = true;
        }

        String s = br.readLine();
        int x = 0;
        int y = 0;
        for(int i=0; i<m; i++) {
            int idx = getMoveIdx(s.charAt(i));
            int nextX = x + dx[idx];
            int nextY = y + dy[idx];
            if (!isObstacle[nextX+500][nextY+500]) {
                x = nextX;
                y = nextY;
            }
        }
        System.out.printf("%d %d\n", x, y);













    }
    static int getMoveIdx(char c) {
        if (c=='U') return 0;
        else if(c=='D') return 1;
        else if(c=='R') return 2;
        else return 3;
    }
}