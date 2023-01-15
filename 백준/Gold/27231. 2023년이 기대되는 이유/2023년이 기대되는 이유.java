import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String s;
    static Set<Long> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            set = new HashSet<>();
            s = br.readLine();
            int n = Integer.parseInt(s);
            boolean tf = true;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)-'0'>1){
                    tf = false;
                    break;
                }
            }
            if(tf){
                sb.append("Hello, BOJ 2023!").append('\n');
                continue;
            }


            for(int select=0; select<s.length(); select++){
                visited = new boolean[s.length()-1];
                back(0, select, 0);
            }

//            System.out.println(set);



            int[] arr = new int[s.length()];
            long[] sumArr = new long[s.length()];

            for(int i=0; i<s.length(); i++){
                arr[i] = s.charAt(i)-'0';
                sumArr[i] = s.charAt(i)-'0';
            }
//            System.out.println(Arrays.toString(arr));

            long sum = 0;
            for(int i=0; i<s.length(); i++){
                sum += sumArr[i];
            }
            int count = 0;
            if(set.contains(sum)) count++;


            while(true){
                sum = 0;
                for(int i=0; i<s.length(); i++){
                    sumArr[i] *= arr[i];
                    sum += sumArr[i];
                }
                if(set.contains(sum)) count++;
                if(sum>n) break;
            }
            sb.append(count).append('\n');









        }
        System.out.println(sb);









    }
    static boolean[] visited;
    public static void back(int depth, int want, int startId){
        if(depth==want){
            int sum = 0;
            int lastId = 0;
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    sum += Integer.parseInt(s.substring(lastId, i+1));
                    lastId = i+1;
                }
            }
            sum += Integer.parseInt(s.substring(lastId, s.length()));
            set.add((long)sum);
            return;
        }
        for(int i=startId; i<s.length()-1; i++){
            visited[i] = true;
            back(depth+1, want, i+1);
            visited[i] = false;
        }
    }
}

