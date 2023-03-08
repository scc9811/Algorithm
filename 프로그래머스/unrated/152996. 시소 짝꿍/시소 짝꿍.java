import java.util.Arrays;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int size = weights.length;
        long[] counts = new long[1001];
        for(int i=0; i<size; i++){
            counts[weights[i]]++;
        }
        
        for(int i=100; i<=1000; i++){
            if(counts[i]==0) continue;
            answer += (counts[i]*(counts[i]-1))/2;
            if(i%2==0 && i*3/2<=1000) answer += counts[i]*counts[i*3/2];
            if(i%3==0 && i*4/3<=1000) answer += counts[i]*counts[i*4/3];
            if(i*2<=1000) answer += counts[i]*counts[i*2];
        }
        
        
        return answer;
    }
}