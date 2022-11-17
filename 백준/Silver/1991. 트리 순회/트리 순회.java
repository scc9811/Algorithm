import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        for(int i=0; i<n; i++){
            arr[i] = new Node((char)('A'+i));
        }
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.charAt(2)!='.') arr[s.charAt(0)-'A'].left = arr[s.charAt(2)-'A'];
            if(s.charAt(4)!='.') arr[s.charAt(0)-'A'].right = arr[s.charAt(4)-'A'];
        }

        
        preOrder(arr[0]);
        sb.append('\n');
        inOrder(arr[0]);
        sb.append('\n');
        postOrder(arr[0]);
        System.out.println(sb);


    }
    static StringBuilder sb  = new StringBuilder();
    public static void preOrder(Node node){
        if(node==null) return;
        sb.append(node.name);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        sb.append(node.name);
        inOrder(node.right);
    }
    public static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.name);
    }


//    public static Node makeNode(char name)throws IOException{
//        if(name=='.') return null;
//        String s = br.readLine();
//        Node tmp = new Node(name);
//        tmp.left = makeNode(s.charAt(2));
//        tmp.right = makeNode(s.charAt(4));
//        return tmp;
//    }
    static class Node{
        char name;
        Node left = null;
        Node right = null;
        Node(char name){
            this.name = name;
        }
    }
}
