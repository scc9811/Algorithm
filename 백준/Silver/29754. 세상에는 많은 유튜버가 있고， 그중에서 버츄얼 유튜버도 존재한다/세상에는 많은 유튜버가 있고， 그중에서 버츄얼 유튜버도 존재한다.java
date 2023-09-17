import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // get number
        Map<String, Integer> get_number = new HashMap<>();
        // get name
        Map<Integer, String> get_name = new HashMap<>();

        int nameCount = 0;

        // 회수, 시간
        long[][][] arr = new long[n][(m-1)/7+1][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int number;
            if(get_number.containsKey(s)){
                number = get_number.get(s);
            }
            else{
                get_name.put(nameCount, s);
                get_number.put(s, nameCount++);
                number = nameCount-1;
            }
            int week = (Integer.parseInt(st.nextToken())-1)/7;
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(s1, ":");
            StringTokenizer st2 = new StringTokenizer(s2, ":");
            int weight = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken()) - (Integer.parseInt(st1.nextToken()) * 60 + Integer.parseInt(st1.nextToken()));
            arr[number][week][0]++;
            arr[number][week][1] += weight;
//            if(s.equals("ai")){
//                System.out.println(arr[number][week][1]);
//            }
        }


        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nameCount; i++){
//            System.out.println("name = "+i);
            boolean tf = true;
            for(int j=0; j<(m-1)/7+1; j++){
//                System.out.println(Arrays.toString(arr[i][j]));
                if(arr[i][j][0] < 5 || arr[i][j][1] < 3600){
                    tf = false;
                    break;
                }
            }
            if(tf){
                list.add(get_name.get(i));
            }
        }

        if(list.size()==0){
            System.out.println(-1);
        }
        else{
            Collections.sort(list);
            for(String s : list){
                sb.append(s).append('\n');
            }
            System.out.println(sb);
        }


















    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}