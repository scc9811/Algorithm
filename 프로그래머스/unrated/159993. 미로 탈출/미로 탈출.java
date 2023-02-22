import java.util.*;
class Solution {
    static char[][] arr;
    static int n, m;
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
    
        arr = new char[n][m];
        for(int i=0; i<n; i++){
            arr[i] = maps[i].toCharArray();
        }
        Point start =null;
        Point laber = null;
        Point exit = null;
        
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]=='S') start = new Point(i, j);
                else if(arr[i][j]=='L') laber = new Point(i, j);
                else if(arr[i][j]=='E') exit = new Point(i, j);
            }
        }
        int toLaber = BFS(start, laber);
        if(toLaber==-1) return-1;
        
        int toExit = BFS(laber, exit);
        if(toExit==-1) return -1;
        
        answer += toLaber + toExit;
        
        
        
        return answer;
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static int BFS(Point start, Point end){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[n][m];
        visited[start.x][start.y] = true;
        int count = 0;
        int tmp = 1;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int newX = p.x+dx[i];
                int newY = p.y+dy[i];
                if(newX<n && newX>=0 && newY<m && newY>=0 && arr[newX][newY]!='X' && !visited[newX][newY]){
                    if(newX==end.x && newY==end.y) return count;
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));
                }
            }
        }
        return -1;
        
    
        
    }
    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}