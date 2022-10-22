import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] array1;
    static boolean[][] tfArray1,tfArray2;
    static int n, m, max_safetyArea, min_virus, count_wall;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max_safetyArea = 0;
        count_wall=0;
        min_virus = Integer.MAX_VALUE;
        array1 = new int[n][m];
        tfArray1 = new boolean[n][m];
        tfArray2 = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array1[i][j] = Integer.parseInt(st.nextToken());
                if(array1[i][j]==1) count_wall++;
            }
        }


        backTracking(0);
        max_safetyArea = n*m-(count_wall+3+min_virus);
        System.out.println(max_safetyArea);




    }
    

    public static void backTracking(int depth) {
        if (depth == 3) {
            min_virus = Math.min(min_virus,viral_transmission());
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // (i,j) 에 벽을 세우지 않았으면
                if (array1[i][j] == 0 && !tfArray1[i][j]) {
                    // 벽을 세우고
                    array1[i][j] = 1;
                    // 방문 기록 남김.
                    tfArray1[i][j] = true;
                    backTracking(depth + 1);
                    array1[i][j] = 0;
                    tfArray1[i][j] = false;
                }
            }
        }
    }


    // 바이러스 개수 반환.
    public static int viral_transmission() {
        int virus_count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array1[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                    virus_count++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int startI = queue.poll();
            int startJ = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newI = startI + dx[i];
                int newJ = startJ + dy[i];
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                    if(array1[newI][newJ]==0 && !tfArray2[newI][newJ]) {
                        queue.add(newI);
                        queue.add(newJ);
                        tfArray2[newI][newJ] = true;
                        virus_count++;
                    }
                }

            }
        }

        for(int i=0; i<n; i++){
            Arrays.fill(tfArray2[i], false);
        }
        return virus_count;

    }


}
