import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        int level=1;
        int[] levelCount = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==')') {
                level--;
                int tmp=0;
                while(stack.pop()!='(') tmp++;
                levelCount[level] += (levelCount[level+1]+tmp)*(stack.pop()-'0');
                levelCount[level+1] = 0;

//                System.out.println(Arrays.toString(levelCount));
            }

            else {
                if(c=='(') level++;
                stack.add(c);
            }
        }
        System.out.println(levelCount[1]+stack.size());
















    }
}