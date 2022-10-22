import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            int t = Integer.parseInt(br.readLine());
            while(t-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                if(st.nextToken().charAt(0)=='I'){
                    int k = Integer.parseInt(st.nextToken());
                    max.add(k);
                    min.add(k);
                    if(map.get(k)==null || map.get(k)==0){
                        map.put(k,1);
                    }
                    else{
                        map.put(k,map.get(k)+1);
                    }
                }

                else {
                    int k = Integer.parseInt(st.nextToken());
                    if(k==1){
                        while(!max.isEmpty()){
                            int tmp = max.poll();
                            if(map.get(tmp)>0){
                                map.put(tmp,map.get(tmp)-1);
                                break;
                            }
                        }




                    }
                    else{
                        while(!min.isEmpty()){
                            int tmp = min.poll();
                            if(map.get(tmp)>0){
                                map.put(tmp,map.get(tmp)-1);
                                break;
                            }
                        }
                    }
                }

            }



            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;
            int zeroCount=0;
            for(Integer key : map.keySet()){
                if(map.get(key)>0){
                    maxValue = Math.max(maxValue, key);
                    minValue = Math.min(minValue, key);
                }
                else zeroCount++;
            }
            if(zeroCount==map.size()) sb.append("EMPTY");

            else sb.append(maxValue).append(' ').append(minValue);
            sb.append('\n');

        }
        
        System.out.println(sb);









    }
}
