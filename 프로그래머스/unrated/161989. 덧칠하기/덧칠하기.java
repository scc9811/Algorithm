class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int size = section.length;
        int last = 0;
        for(int i=0; i<size; i++){
            if(section[i]<=last) continue;
            answer++;
            last = section[i] + m-1;
        }
        
        
        
        
        
        
        
        return answer;
    }
}