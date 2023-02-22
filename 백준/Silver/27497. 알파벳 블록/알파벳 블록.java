import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==3){
                if(!stack.isEmpty()) stack.pop();
            }
            else{
                stack.add(new Node(order, st.nextToken().charAt(0)));
            }
        }
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        if(stack.isEmpty()){
            front.append(0);
        }
        else{
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(node.order==2){
                    front.append(node.c);
                }
                else{
                    back.append(node.c);
                }
            }
        }
        back.reverse();


        System.out.println(front.append(back));



    }
    public static class Node{
        int order;
        char c;
        Node(int order, char c){
            this.order = order;
            this.c = c;
        }
    }
}
