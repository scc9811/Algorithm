import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Point leftTop, leftBottom, rightTop, rightBottom;
    static int n, arr[][], sum;
    static StringBuilder res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = new StringBuilder();
        leftTop = new Point(n/2-1, n/2-1);
        leftBottom = new Point(n/2, n/2-1);
        rightTop = new Point(n/2-1, n/2);
        rightBottom = new Point(n/2, n/2);


        sum = 0;
        while(true){
            expand();
        }






    }
    // 0: 상 1: 하 2: 좌 3: 우
    static void expand(){
        int[][] tmp = new int[4][2];
        for(int i=0; i<4; i++){
            tmp[i][1] = i;
        }
        if(leftTop.x>0) {
            for (int j = leftTop.y; j< rightTop.y+1; j++){
                tmp[0][0] += arr[leftTop.x-1][j];
            }
        }
        if(leftBottom.x<n-1){
            for(int j=leftBottom.y; j< rightBottom.y+1; j++){
                tmp[1][0] += arr[leftBottom.x+1][j];
            }
        }
        if(leftTop.y>0){
            for(int i=leftTop.x; i<leftBottom.x+1; i++){
                tmp[2][0] += arr[i][leftTop.y-1];
            }
        }
        if(rightTop.y<n-1){
            for(int i=rightTop.x; i<rightBottom.x+1; i++){
                tmp[3][0] += arr[i][rightTop.y+1];
            }
        }



        Arrays.sort(tmp, ((o1, o2) -> {
            if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o2[0], o1[0]);
        }));

//        for(int i=0; i<4; i++){
//            System.out.println(Arrays.toString(tmp[i]));
//        }

        if(tmp[0][0]<=0){
            System.out.println(sum);
            System.out.println(res);
            System.exit(0);
        }

        sum += tmp[0][0];
        // 좌표갱신


        // 방향추가
        if(tmp[0][1]==0){
            res.append('U');
            leftTop = new Point(leftTop.x-1, leftTop.y);
            rightTop = new Point(rightTop.x-1, rightTop.y);
        }
        else if(tmp[0][1]==1){
            res.append('D');
            leftBottom = new Point(leftBottom.x+1, leftBottom.y);
            rightBottom = new Point(rightBottom.x+1, rightBottom.y);
        }
        else if(tmp[0][1]==2){
            leftTop = new Point(leftTop.x, leftTop.y-1);
            leftBottom = new Point(leftBottom.x, leftBottom.y-1);
            res.append('L');
        }
        else if(tmp[0][1]==3){
            rightTop = new Point(rightTop.x, rightTop.y+1);
            rightBottom = new Point(rightBottom.x, rightBottom.y+1);
            res.append('R');
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
