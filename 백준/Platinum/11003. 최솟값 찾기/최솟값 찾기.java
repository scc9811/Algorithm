import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();
        int[] arr = new int[n];
        // value : numberCount
//        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<l; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Element(arr[i], i));
//            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            res.append(priorityQueue.peek().value).append(' ');
        }

        for(int i=l; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Element(arr[i], i));
            while(!priorityQueue.isEmpty()){
                Element e = priorityQueue.peek();
                if(e.id<=i-l) priorityQueue.poll();
                else break;
            }
            res.append(priorityQueue.peek().value).append(' ');
        }
        System.out.println(res);


    }
    static class Element implements Comparable<Element>{
        int value, id;
        Element(int value, int id){
            this.value = value;
            this.id = id;
        }
        public int compareTo(Element e){
            return Integer.compare(this.value, e.value);
        }

    }
}