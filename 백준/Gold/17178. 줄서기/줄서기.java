import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 대기줄 내부
        Stack<Integer> stack = new Stack<>();
        // 대기줄 외부
        Queue<Integer> queue = new LinkedList<>();

        String[][] array = new String[5*n][2];

        // i번째 티켓이 대기줄 내부/외부 판별.
        boolean[] isInStack = new boolean[5*n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                array[i*5+j][0] = st.nextToken();
                array[i*5+j][1] = String.valueOf(i*5+j);
            }
        }
        Arrays.sort(array, (o1, o2) -> {
            if(o1[0].charAt(0)==o2[0].charAt(0)){
                return Integer.compare(Integer.valueOf(o1[0].substring(2)),Integer.valueOf(o2[0].substring(2)));
            }
            else{
                return o1[0].compareTo(o2[0]);
            }
        });



//        for(int i=0; i<5*n; i++){
//            System.out.println(Arrays.toString(array[i]));
//        }
        int[] sequence = new int[5*n];
        for(int i=0; i<5*n; i++){
//            sequence[i] = Integer.parseInt(array[i][1]);
            sequence[Integer.parseInt(array[i][1])] = i;
        }
        for(int i=0; i<5*n; i++){
            queue.add(sequence[i]);
        }

//        System.out.println(Arrays.toString(sequence));



        String s = "GOOD";

        // count 번째 티켓이 입장해야 될 차례.
        for(int count=0; count<5*n; count++){
            // stack (대기 공간) 안에 있는 경우.
            if(isInStack[count]){
                if(stack.peek()!=count){
                    s = "BAD";
                    break;
                }
                stack.pop();
            }
            else{
                while(true){
                    int tmp = queue.poll();
                    if(tmp==count) break;
                    if(!stack.isEmpty() && tmp>stack.peek()){
                        s = "BAD";
                        break;
                    }
                    stack.add(tmp);
                    isInStack[tmp]=true;
                }
                if(s.equals("BAD")) break;
            }
        }
        System.out.println(s);
//        System.out.println(queue);
//        System.out.println(stack);



    }
}
