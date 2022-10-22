import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            Queue<Integer> queue = new LinkedList<>();
            int size = Integer.parseInt(br.readLine());
            boolean[][] tfArray = new boolean[size][size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(x);
            queue.add(y);
            tfArray[x][y] = true;
            st = new StringTokenizer(br.readLine());
            int endI = Integer.parseInt(st.nextToken());
            int endJ = Integer.parseInt(st.nextToken());

            if(x==endI && y==endJ) sb.append(0);

            else {

                int count = 0;
                int tmp = 1;
                while (!queue.isEmpty()) {
                    int startI = queue.poll();
                    int startJ = queue.poll();
                    if(startI==endI && startJ==endJ) break;
                    tmp--;
                    for (int i = 0; i < 8; i++) {
                        int newI = startI + dx[i];
                        int newJ = startJ + dy[i];
                        if (newI < size && newI >= 0 && newJ < size && newJ >= 0 && !tfArray[newI][newJ]) {
                            queue.add(newI);
                            queue.add(newJ);
                            tfArray[newI][newJ] = true;
                        }
                    }
                    if (tmp == 0) {
                        count++;
                        tmp = queue.size() / 2;
                    }
                }

                sb.append(count);
            }
            sb.append('\n');
        }
        System.out.println(sb);





    }
}