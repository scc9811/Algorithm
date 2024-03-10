import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node[][][] arr = new Node[7][7][7];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String s = st.nextToken();
            int a1 = getIdx(st.nextToken().charAt(0));
            int a2 = getIdx(st.nextToken().charAt(0));
            int a3 = getIdx(st.nextToken().charAt(0));
            arr[a1][a2][a3] = new Node(s, arr[a1][a2][a3]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a1 = getIdx(st.nextToken().charAt(0));
            int a2 = getIdx(st.nextToken().charAt(0));
            int a3 = getIdx(st.nextToken().charAt(0));
            if(arr[a1][a2][a3]==null){
                sb.append('!');
            }
            else if(arr[a1][a2][a3].next!=null){
                sb.append('?');
            }
            else{
                sb.append(arr[a1][a2][a3].s);
            }
            sb.append('\n');
        }
        System.out.println(sb);













    }
    static int getIdx(char c){
        if(c=='C') return 0;
        else if(c=='D') return 1;
        else if(c=='E') return 2;
        else if(c=='F') return 3;
        else if(c=='G') return 4;
        else if(c=='A') return 5;
        else if(c=='B') return 6;
        return 7;
    }
    static class Node{
        String s;
        Node next;
        Node(String s, Node next){
            this.s = s;
            this.next = next;
        }
    }
}