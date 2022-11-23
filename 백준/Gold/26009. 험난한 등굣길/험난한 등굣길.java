import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n, m, k, arr[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        arr = new int[n][m];
//        for(int i=0; i<n; i++){
//            Arrays.fill(arr[i], -1);
//        }

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());

            for(int j=-d; j<=d; j++){
                if(r+j<0) j = -r;
                if(r+j>=n) break;
                int y1 = c+(d-Math.abs(j));
                int y2 = c-(d-Math.abs(j));
                if(y1>=0 && y1<m) arr[r+j][y1] = 1;
                if(y2>=0 && y2<m) arr[r+j][y2] = 1;
            }




//            if(arr[r][c]>=d) continue;
//            fill(r,c,d);



//            for(int j=-d; j<=d; j++){
//                if(r+j<0) j = -r;
//                if(r+j>n) break;
//                int tmp = d - Math.abs(j);
//                if(c-tmp<0) tmp = c;
//                for(int l=-tmp; l<=tmp; l++){
//                    if(c+l>=m) break;
//                    if(r+j>=0 && r+j<n && c+l>=0 && c+l<m)
//                        arr[r+j][c+l] = Math.max(arr[r+j][c+l], d-(Math.abs(j)+Math.abs(l)));
//                }
//            }

        }
//        for(int j=0; j<n; j++){
//            System.out.println(Arrays.toString(arr[j]));
//        }


        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        arr[0][0] = 1;
        int tmp = 1;
        int count = 0;
        boolean tf = false;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }
            Point p = queue.poll();
            int startI = p.x;
            int startJ = p.y;
            for(int i=0; i<4; i++){
                int newI = startI+dx[i];
                int newJ = startJ+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]==0){
                    if(newI==n-1 && newJ==m-1){
                        tf = true;
                        queue = new LinkedList<>();
                        break;
                    }
                    arr[newI][newJ] = 1;
                    queue.add(new Point(newI, newJ));
                }
            }

        }
        if(tf) {
            System.out.println("YES");
            System.out.println(count);
        }
        else System.out.println("NO");


    }
    public static void fill(int x, int y, int count){
        if(arr[x][y]>=count) return;
        System.out.println("x = "+x);
        System.out.println("y = "+y);
        arr[x][y] = count;
        for(int i=0; i<4; i++){
            int newI = x+dx[i];
            int newJ = y+dy[i];
            if(newI>=0 && newI<n && newJ>=0 && newJ<m){
                fill(newI, newJ, count-1);
            }
        }



    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}