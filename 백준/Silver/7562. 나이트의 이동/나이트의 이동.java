import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {2,1,-1,-2,-2,-1,1,2};
    static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    static boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            int size = Integer.parseInt(br.readLine());
            visited = new boolean[size][size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startI = Integer.parseInt(st.nextToken());
            int startJ = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endI = Integer.parseInt(st.nextToken());
            int endJ = Integer.parseInt(st.nextToken());

            if(startI==endI && startJ==endJ){
                sb.append(0).append('\n');
                continue;
            }
            Queue<Point> queue = new LinkedList<>();
            visited[startI][startJ] = true;
            queue.add(new Point(startI, startJ));
            int count = 1;
            int tmp = 1;
            while(!queue.isEmpty()){
                Point p = queue.poll();
                startI = p.x;
                startJ = p.y;
//                if(startI==endI && startJ==endJ) break;

                for(int i=0; i<8; i++){
                    int newI = startI+dx[i];
                    int newJ = startJ+dy[i];
                    if(newI>=0 && newI<size && newJ>=0 && newJ<size && !visited[newI][newJ]){
                        if(newI==endI && newJ==endJ){
                            queue = new LinkedList<>();
                            break;
                        }
                        queue.add(new Point(newI, newJ));
                        visited[newI][newJ] = true;

                    }
                }
                if(queue.isEmpty()) break;
                tmp--;
                if(tmp==0){
                    count++;
                    tmp = queue.size();
                }
            }

            sb.append(count).append('\n');







        }
        System.out.println(sb);







    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
