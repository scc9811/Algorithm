import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int dx[] = {1,1,0,-1,-1,-1,0,1};
    static int dy[] = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Point> map = new HashMap<>();
        String[][] arr = new String[9][9];
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = st.nextToken();
            }
        }
        String[] middle = new String[8];
        middle[0] = arr[1][1];
        map.put(arr[1][1], new Point(1, 1));
        middle[1] = arr[1][4];
        map.put(arr[1][4], new Point(1, 4));
        middle[2] = arr[1][7];
        map.put(arr[1][7], new Point(1, 7));

        middle[3] = arr[4][1];
        map.put(arr[4][1], new Point(4, 1));
        middle[4] = arr[4][7];
        map.put(arr[4][7], new Point(4, 7));

        middle[5] = arr[7][1];
        map.put(arr[7][1], new Point(7, 1));
        middle[6] = arr[7][4];
        map.put(arr[7][4], new Point(7, 4));
        middle[7] = arr[7][7];
        map.put(arr[7][7], new Point(7, 7));

        Arrays.sort(middle);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++){
            sb.append('#').append(i+1).append(". ").append(middle[i]).append('\n');
            String[] down = new String[8];
            Point p = map.get(middle[i]);
            for(int j=0; j<8; j++){
                int newX = p.x+dx[j];
                int newY = p.y+dy[j];
                down[j] = arr[newX][newY];
            }
            Arrays.sort(down);
            for(int j=0; j<8; j++) {
                sb.append('#').append(i+1).append('-').append(j+1).append(". ").append(down[j]).append('\n');
            }
        }
        System.out.println(sb);





    }
    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
