import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = 0;
        Stack<Element> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int cur = Integer.parseInt(br.readLine());
            int lastId = -1;
            while(!stack.isEmpty()){
                if(stack.peek().height>cur){
                    Element e = stack.pop();
                    res = Math.max(res, (i - e.id)*e.height);
                    lastId = (int) e.id;
                }
                else break;
            }
            if(lastId==-1) stack.add(new Element(cur, i));
            else stack.add(new Element(cur, lastId));
        }

        while(!stack.isEmpty()){
            Element e = stack.pop();
            res = Math.max(res, (n-e.id)*e.height);
        }
        System.out.println(res);


        














    }
    static class Element{
        long height, id;
        Element(long height, int id){
            this.height = height;
            this.id = id;
        }
    }
}