import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Point startP = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);
        Point endP = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);

        boolean[][][] visited = new boolean[4][n][m];
        Queue<Point> queue = new LinkedList<>();
        List<Point> ghost = new ArrayList<>();
        char[][] arr = new char[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == '0' || arr[i][j] == '1' || arr[i][j] == '2' || arr[i][j] == '3') ghost.add(new Point(i, j, 0));
            }
        }
        char[][][] boards = new char[4][n][m];
        for(int k=0; k<4; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    boards[k][i][j] = arr[i][j];
                }
            }
        }




        // status 0
        for(Point p : ghost){
            if(arr[p.x][p.y] == '0'){
                arr[p.x][p.y] = '1';
                for(int j=p.y+1; j<m; j++){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[0][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '1'){
                arr[p.x][p.y] = '2';
                for(int i=p.x+1; i<n; i++){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[0][i][p.y] = '*';
                }
            }
            else if(arr[p.x][p.y] == '2'){
                arr[p.x][p.y] = '3';
                for(int j=p.y-1; j>=0; j--){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[0][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '3'){
                arr[p.x][p.y] = '0';
                for(int i=p.x-1; i>=0; i--){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[0][i][p.y] = '*';
                }
            }
        }

        // status 1
        for(Point p : ghost){
            if(arr[p.x][p.y] == '0'){
                arr[p.x][p.y] = '1';
                for(int j=p.y+1; j<m; j++){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[1][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '1'){
                arr[p.x][p.y] = '2';
                for(int i=p.x+1; i<n; i++){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[1][i][p.y] = '*';
                }
            }
            else if(arr[p.x][p.y] == '2'){
                arr[p.x][p.y] = '3';
                for(int j=p.y-1; j>=0; j--){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[1][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '3'){
                arr[p.x][p.y] = '0';
                for(int i=p.x-1; i>=0; i--){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[1][i][p.y] = '*';
                }
            }
        }

        // status 2
        for(Point p : ghost){
            if(arr[p.x][p.y] == '0'){
                arr[p.x][p.y] = '1';
                for(int j=p.y+1; j<m; j++){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[2][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '1'){
                arr[p.x][p.y] = '2';
                for(int i=p.x+1; i<n; i++){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[2][i][p.y] = '*';
                }
            }
            else if(arr[p.x][p.y] == '2'){
                arr[p.x][p.y] = '3';
                for(int j=p.y-1; j>=0; j--){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[2][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '3'){
                arr[p.x][p.y] = '0';
                for(int i=p.x-1; i>=0; i--){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[2][i][p.y] = '*';
                }
            }
        }

        // status 3
        for(Point p : ghost){
            if(arr[p.x][p.y] == '0'){
                arr[p.x][p.y] = '1';
                for(int j=p.y+1; j<m; j++){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[3][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '1'){
                arr[p.x][p.y] = '2';
                for(int i=p.x+1; i<n; i++){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[3][i][p.y] = '*';
                }
            }
            else if(arr[p.x][p.y] == '2'){
                arr[p.x][p.y] = '3';
                for(int j=p.y-1; j>=0; j--){
                    if(arr[p.x][j] == '#') break;
                    if(arr[p.x][j] == '0' || arr[p.x][j] == '1' || arr[p.x][j] == '2' || arr[p.x][j] == '3') break;
                    boards[3][p.x][j] = '*';
                }
            }
            else if(arr[p.x][p.y] == '3'){
                arr[p.x][p.y] = '0';
                for(int i=p.x-1; i>=0; i--){
                    char c = arr[i][p.y];
                    if(c == '#') break;
                    if(c == '0' || c=='1' || c=='2' || c=='3') break;
                    boards[3][i][p.y] = '*';
                }
            }
        }

//
//        for(int i=0; i<4; i++){
//            for(int j=0; j<n; j++){
//                System.out.println(Arrays.toString(boards[i][j]));
//            }
//            System.out.println();
//        }
//        System.out.println();






        visited[0][startP.x][startP.y] = true;
        queue.add(startP);
        while(!queue.isEmpty()){
            Point curP = queue.poll();
            int count = curP.count+1;
            for(int i=0; i<5; i++){
                int newI = curP.x + dx[i];
                int newJ = curP.y + dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[count%4][newI][newJ]){
                    if(boards[count%4][newI][newJ] != '.') continue;
                    visited[count%4][newI][newJ] = true;
                    queue.add(new Point(newI, newJ, count));
                    if(newI == endP.x && newJ == endP.y){
                        System.out.println(count);
                        System.exit(0);
                    }
                }
            }
        }


        System.out.println("GG");



















    }
    // 0, 1, 2, 3
    static int[] dx = {0,0,1,0,-1};
    static int[] dy = {0,1,0,-1,0};
    static class Point{
        int x, y, count;
        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static class Node{
        int to;
        Node next;
        Node(int to, Node next){
            this.to = to;
            this.next = next;
        }
    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}