import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static Node[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Node[n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start] = new Node(end, arr[start]);
            arr[end] = new Node(start, arr[end]);
        }

        visited = new boolean[n];
        for(int i=0; i<n; i++){
            visited[i] = true;
            back(0, i);
            visited[i] = false;
        }
        System.out.println(0);




    }
    static boolean[] visited;
    public static void back(int depth, int node){
        if(depth==4){
            System.out.println(1);
            System.exit(0);
        }
        for(Node n = arr[node]; n!=null; n=n.next){
            if(!visited[n.friend]){
                visited[n.friend] = true;
                back(depth+1, n.friend);
                visited[n.friend] = false;
            }
        }
//        for(int i=0; i<n; i++){
//            if(arr[node][i]==1 && !visited[i]){
//                visited[i] = true;
//                back(depth+1, i);
//                visited[i] = false;
//            }
//        }


    }
    public static class Node{
        int friend;
        Node next;
        Node(int friend, Node next){
            this.friend = friend;
            this.next = next;
        }
    }
}