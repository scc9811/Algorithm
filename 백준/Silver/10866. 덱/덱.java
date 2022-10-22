import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            int size = 0;
            if(s1.equals("push_back")) arrayList.add(Integer.parseInt(st.nextToken()));
            else if (s1.equals("push_front")) {
                arrayList.add(0,Integer.parseInt(st.nextToken()));
            }

            else if (s1.equals("pop_front")) {
                if (arrayList.size()==0) System.out.println(-1);
                else System.out.println(arrayList.remove(0));
            }
            else if (s1.equals("pop_back")){
                if (arrayList.size()==0) System.out.println(-1);
                else System.out.println(arrayList.remove(arrayList.size()-1));
            }
            else if (s1.equals("size")) System.out.println(arrayList.size());
            else if (s1.equals("empty")) {
                if (arrayList.size()==0) System.out.println(1);
                else System.out.println(0);
            }
            else if (s1.equals("front")){
                if (arrayList.isEmpty()) System.out.println(-1);
                else System.out.println(arrayList.get(0));
            }
            else if (s1.equals("back")) {
                if (arrayList.isEmpty()) System.out.println(-1);
                else System.out.println(arrayList.get(arrayList.size()-1));
            }
        }
























//        Deque<Integer> deque = new LinkedList<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        while (N-->0){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String s1 = st.nextToken();
//            if(s1.equals("push_back")) deque.addLast(Integer.parseInt(st.nextToken()));
//            else if (s1.equals("push_front")) deque.addFirst(Integer.parseInt(st.nextToken()));
//            else if (s1.equals("pop_front")) {
//                if (deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.pollFirst());
//            }
//            else if (s1.equals("pop_back")){
//                if (deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.pollLast());
//            }
//            else if (s1.equals("size")) System.out.println(deque.size());
//            else if (s1.equals("empty")) {
//                if (deque.isEmpty()) System.out.println(1);
//                else System.out.println(0);
//            }
//            else if (s1.equals("front")) {
//                if (deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.getFirst());
//            }
//            else if (s1.equals("back")) {
//                if (deque.isEmpty()) System.out.println(-1);
//                else System.out.println(deque.getLast());
//            }
//        }








    }
}
