import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int[] impCount = new int[10];
            for(int i=0; i<n; i++){
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, importance));
                impCount[importance]++;
            }
            int imp = 0;
            for(int i=1; i<10; i++){
                if(impCount[i]!=0) imp = i;
            }

            int count = 1;
            while(!queue.isEmpty()){
                Document document = queue.poll();
                if(document.importance<imp) queue.add(document);
                else{
                    if(document.importance==imp && document.index==m){
                        sb.append(count).append('\n');
                        break;
                    }
                    count++;
                    impCount[imp]--;
                    if(impCount[imp]==0){
                        for(int i=imp-1; i>=0; i--){
                            if(impCount[i]!=0){
                                imp = i;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sb);








    }
    public static class Document{
        int index, importance;
        Document(int index, int importance){
            this.index = index;
            this.importance = importance;
        }
    }
}