import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m;
    static char[][] arr;
    static boolean visited[][][][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m][n][m];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                if(s.charAt(j)=='R') {
                    rx = i;
                    ry = j;
                    arr[i][j] = '.';
                }
                else if(s.charAt(j)=='B') {
                    bx = i;
                    by = j;
                    arr[i][j] = '.';
                }
                else arr[i][j] = s.charAt(j);
            }
        }
        visited[rx][ry][bx][by] = true;
        int res = BFS(new Loc(rx, ry, bx, by, -1, null));
        if(res==-1) System.out.println(-1);
        else {           
            System.out.println(res);
        }




    }
    static Loc result;
    // r,b 같은 행 또는 열에 있는 경우 예외처리
    public static int BFS(Loc st){
        Queue<Loc> queue = new LinkedList<>();
        queue.add(st);
        int count = 0;
        int tmp = 1;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }
            Loc current = queue.poll();
            if(current.rx==-1) continue;

            int rx = 0;
            int ry = 0;
            int bx = 0;
            int by = 0;


            // left

            // red, blue 같은행
            if(current.rx==current.bx){
                // red 가 더 왼쪽
                if(current.ry < current.by){
                    boolean redIsIn = false;
                    //red 먼저 이동
                    for(int j=current.ry-1; j>=0; j--){
                        if(arr[current.rx][j]=='#'){
                            rx = current.rx;
                            ry = j+1;
                            break;
                        }
                        else if(arr[current.rx][j]=='O'){
                            redIsIn = true;
                            rx = -2;
                            break;
                        }
                    }

                    // blue left 이동
                   for(int j=current.by-1; j>=0; j--){
                        if(arr[current.bx][j]=='#' || j == ry){
                            bx = current.bx;
                            by = j+1;
                            break;
                        }
                        else if(arr[current.bx][j]=='O'){
                            rx = -1;
                            break;
                        }
                   }
                   if(redIsIn && rx==-2) {
                       result = new Loc(rx, ry, bx, by, 0, current);
                       return count;
                   }
                }

                // blue 가 더 왼쪽
                else{
                    // blue 먼저 이동
                    boolean blueIsIn = false;
                    for(int j=current.by-1; j>=0; j--){
                        if(arr[current.bx][j]=='#'){
                            bx = current.bx;
                            by = j+1;
                            break;
                        }
                        else if(arr[current.bx][j]=='O'){
                            rx = -1;
                            blueIsIn = true;
                            break;
                        }
                    }

                    // red 이동
                    if(!blueIsIn) {
                        for (int j = current.ry - 1; j >= 0; j--) {
                            if (arr[current.rx][j] == '#' || j == by) {
                                rx = current.rx;
                                ry = j + 1;
                                break;
                            } else if (arr[current.rx][j] == 'O') {
                                result = new Loc(rx, ry, bx, by, 0, current);
                                return count;
                            }
                        }
                    }
                }



            }
            // red, blue 다른행
            else{
                for(int j=current.ry-1; j>=0; j--){
                    if(arr[current.rx][j]=='#'){
                        rx = current.rx;
                        ry = j+1;
                        break;
                    }
                    else if(arr[current.rx][j]=='O') {
                        result = new Loc(rx, ry, bx, by, 0, current);
                        return count;
                    }
                }
                for(int j=current.by-1; j>=0; j--){
                    if(arr[current.bx][j]=='#'){
                        bx = current.bx;
                        by = j+1;
                        break;
                    }
                    else if(arr[current.bx][j]=='O'){
                        rx = -1;
                        break;
                    }
                }
            }

            if(rx>-1 && !visited[rx][ry][bx][by]){
                visited[rx][ry][bx][by] = true;
                queue.add(new Loc(rx, ry, bx, by, 0, current));
            }


            //right
            rx = 0;
            ry = 0;
            bx = 0;
            by = 0;
            // red, blue 같은행
            if(current.rx==current.bx){
                // red 가 더 오른쪽
                if(current.ry > current.by){
                    boolean redIsIn = false;
                    //red 먼저 이동
                    for(int j=current.ry+1; j<m; j++){
                        if(arr[current.rx][j]=='#'){
                            rx = current.rx;
                            ry = j-1;
                            break;
                        }
                        else if(arr[current.rx][j]=='O'){
                            redIsIn = true;
                            rx = -2;
                            break;
                        }
                    }


                    // blue right 이동
                    for(int j=current.by+1; j<m; j++){
                        if(arr[current.bx][j]=='#' || j == ry){
                            bx = current.bx;
                            by = j-1;
                            break;
                        }
                        else if(arr[current.bx][j]=='O'){
                            rx = -1;
                            break;
                        }
                    }
                    if(redIsIn && rx==-2){
                        result = new Loc(rx, ry, bx, by, 1, current);
                        return count;
                    }
                }

                // blue 가 더 오른쪽
                else{
                    // blue 먼저 이동
                    boolean blueIsIn = false;
                    for(int j=current.by+1; j<m; j++){
                        if(arr[current.bx][j]=='#'){
                            bx = current.bx;
                            by = j-1;
                            break;
                        }
                        else if(arr[current.bx][j]=='O'){
                            rx = -1;
                            blueIsIn = true;
                            break;
                        }
                    }
                    // red right 이동
                    if(!blueIsIn) {
                        for (int j = current.ry + 1; j < m; j++) {
                            if (arr[current.rx][j] == '#' || j == by) {
                                rx = current.rx;
                                ry = j - 1;
                                break;
                            } else if (arr[current.rx][j] == 'O') {
                                result = new Loc(rx, ry, bx, by, 1, current);
                                return count;
                            }
                        }
                    }
                }
            }

            // red, blue 다른행
            else{
                for(int j=current.ry+1; j<m; j++){
                    if(arr[current.rx][j]=='#'){
                        rx = current.rx;
                        ry = j-1;
                        break;
                    }
                    else if(arr[current.rx][j]=='O') {
                        result = new Loc(rx, ry, bx, by, 1, current);
                        return count;
                    }
                }
                for(int j=current.by+1; j<m; j++){
                    if(arr[current.bx][j]=='#'){
                        bx = current.bx;
                        by = j-1;
                        break;
                    }
                    else if(arr[current.bx][j]=='O'){
                        rx = -1;
                        break;
                    }
                }
            }

            if(rx>-1 && !visited[rx][ry][bx][by]){
                visited[rx][ry][bx][by] = true;
                queue.add(new Loc(rx, ry, bx, by, 1, current));
            }




            //up
            rx = 0;
            ry = 0;
            bx = 0;
            by = 0;
            // red, blue 같은열
            if(current.ry==current.by){
                // red 가 더 위
                if(current.rx < current.bx){
                    boolean redIsIn = false;
                    //red 먼저 이동
                    for(int i=current.rx-1; i>=0; i--){
                        if(arr[i][current.ry]=='#'){
                            rx = i+1;
                            ry = current.ry;
                            break;
                        }
                        else if(arr[i][current.ry]=='O'){
                            redIsIn = true;
                            rx = -2;
                            break;
                        }
                    }

                    // blue up 이동
                    for(int i=current.bx-1; i>=0; i--){
                        if(arr[i][current.by]=='#' || i == rx){
                            bx = i+1;
                            by = current.by;
                            break;
                        }
                        else if(arr[i][current.by]=='O'){
                            rx = -1;
                            break;
                        }
                    }
                    if(redIsIn && rx==-2){
                        result = new Loc(rx, ry, bx, by, 2, current);
                        return count;
                    }
                }

                // blue 가 더 위
                else{
                    // blue 먼저 이동
                    boolean blueIsIn = false;
                    for(int i=current.bx-1; i>=0; i--){
                        if(arr[i][current.by]=='#'){
                            bx = i+1;
                            by = current.by;
                            break;
                        }
                        else if(arr[i][current.by]=='O'){
                            rx = -1;
                            blueIsIn = true;
                            break;
                        }
                    }
                    // red 이동
                    if(!blueIsIn) {
                        for (int i = current.rx - 1; i >= 0; i--) {
                            if (arr[i][current.ry] == '#' || i == bx) {
                                rx = i + 1;
                                ry = current.ry;
                                break;
                            } else if (arr[i][current.ry] == 'O') {
                                result = new Loc(rx, ry, bx, by, 2, current);
                                return count;
                            }
                        }
                    }
                }



            }
            // red, blue 다른열
            else{
                for(int i=current.rx-1; i>=0; i--){
                    if(arr[i][current.ry]=='#'){
                        rx = i+1;
                        ry = current.ry;
                        break;
                    }
                    else if(arr[i][current.ry]=='O'){
                        result = new Loc(rx, ry, bx, by, 2, current);
                        return count;
                    }
                }

                for(int i=current.bx-1; i>=0; i--){
                    if(arr[i][current.by]=='#'){
                        bx = i+1;
                        by = current.by;
                        break;
                    }
                    else if(arr[i][current.by]=='O'){
                        rx = -1;
                        break;
                    }
                }
            }

            if(rx>-1 && !visited[rx][ry][bx][by]){
                visited[rx][ry][bx][by] = true;
                queue.add(new Loc(rx, ry, bx, by, 2, current));
            }





            //down
            rx = 0;
            ry = 0;
            bx = 0;
            by = 0;
            // red, blue 같은열
            if(current.ry==current.by){
                // red 가 더 아래
                if(current.rx > current.bx){
                    boolean redIsIn = false;
                    //red 먼저 이동
                    for(int i=current.rx+1; i<n; i++){
                        if(arr[i][current.ry]=='#'){
                            rx = i-1;
                            ry = current.ry;
                            break;
                        }
                        else if(arr[i][current.ry]=='O'){
                            redIsIn = true;
                            rx = -2;
                            break;
                        }
                    }

                    // blue up 이동
                    for(int i=current.bx+1; i<n; i++){
                        if(arr[i][current.by]=='#' || i == rx){
                            bx = i-1;
                            by = current.by;
                            break;
                        }
                        else if(arr[i][current.by]=='O'){
                            rx = -1;
                            break;
                        }
                    }
                    if(redIsIn && rx==-2){
                        result = new Loc(rx, ry, bx, by, 3, current);
                        return count;
                    }
                }

                // blue 가 더 아래
                else{
                    // blue 먼저 이동
                    boolean blueIsIn = false;
                    for(int i=current.bx+1; i<n; i++){
                        if(arr[i][current.by]=='#'){
                            bx = i-1;
                            by = current.by;
                            break;
                        }
                        else if(arr[i][current.by]=='O'){
                            rx = -1;
                            blueIsIn = true;
                            break;
                        }
                    }
                    // red 이동
                    if(!blueIsIn) {
                        for (int i = current.rx + 1; i < n; i++) {
                            if (arr[i][current.ry] == '#' || i == bx) {
                                rx = i - 1;
                                ry = current.ry;
                                break;
                            } else if (arr[i][current.ry] == 'O') {
                                result = new Loc(rx, ry, bx, by, 3, current);
                                return count;
                            }
                        }
                    }
                }
            }


            // red, blue 다른열
            else{
                for(int i=current.rx+1; i<n; i++){
                    if(arr[i][current.ry]=='#'){
                        rx = i-1;
                        ry = current.ry;
                        break;
                    }
                    else if(arr[i][current.ry]=='O') {
                        result = new Loc(rx, ry, bx, by, 3, current);
                        return count;
                    }
                }

                for(int i=current.bx+1; i<n; i++){
                    if(arr[i][current.by]=='#'){
                        bx = i-1;
                        by = current.by;
                        break;
                    }
                    else if(arr[i][current.by]=='O'){
                        rx = -1;
                        break;
                    }
                }
            }


            if(rx>-1 && !visited[rx][ry][bx][by]){
                visited[rx][ry][bx][by] = true;
                queue.add(new Loc(rx, ry, bx, by, 3, current));
            }

        }

        //
        return -1;
    }

    public static class Loc{
        int rx, ry, bx, by, dir;
        Loc par;
        Loc(int rx, int ry, int bx, int by, int dir, Loc par){
            this.rx = rx; this.ry = ry; this.bx = bx; this.by = by; this.dir = dir;
            this.par = par;
        }
    }
}
