import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int count = 0;
            int idx = -1;
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i)==' '){
                    count++;
                    if(count==2){
                        idx = i+1;
                        break;
                    }
                }
            }


            String s = input.substring(idx, input.length());


            int[][] arr = new int[n][m];


            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};
            // 0 : right, 1 : down, 2 : left, 3 : up
            int dir = 0;
            int x = 0;
            int y = 0;

            int top = 0;
            int bottom = n-1;
            int left = 0;
            int right = m-1;

            for(int i=0; i<s.length(); i++){
                String binC = c_to_b(s.charAt(i));
//                System.out.printf("%c = %s\n",s.charAt(i), binC);
                for(int j=0; j<5; j++){
//                    System.out.printf("%d, %d = %d\n", x, y, binC.charAt(j)-'0');
                    arr[x][y] = binC.charAt(j)-'0';
                    x += dx[dir];
                    y += dy[dir];
                    if(x<top || x>bottom || y<left || y>right){
                        if(dir==0) top++;
                        else if(dir==1) right--;
                        else if(dir==2) bottom--;
                        else if(dir==3) left++;
                        x -= dx[dir];
                        y -= dy[dir];
                        dir = (dir+1)%4;
                        x += dx[dir];
                        y += dy[dir];
                    }
                }
            }


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    sb.append(arr[i][j]);
                }
            }
            sb.append('\n');


        }
        System.out.println(sb);





    }
    static String c_to_b(char c){
        StringBuilder sb = new StringBuilder();
        if(c==' ') return "00000";
        int cur = c - 'A'+1;
        if(cur/16==1){
            sb.append(1);
            cur %= 16;
        }
        else sb.append(0);

        if(cur/8==1){
            sb.append(1);
            cur %= 8;
        }
        else sb.append(0);

        if(cur/4==1){
            sb.append(1);
            cur %= 4;
        }
        else sb.append(0);

        if(cur/2==1){
            sb.append(1);
            cur %= 2;
        }
        else sb.append(0);

        if(cur==1){
            sb.append(1);
            cur %= 1;
        }
        else sb.append(0);

        return sb.toString();
    }
    static class Node{
        char c;
        int left, right;
        Node(char c, int left, int right){
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }
    static int[] par;
    static int find(int a) {
        if (par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a<p_b) par[p_b] = p_a;
        else par[p_a] = p_b;
    }
}