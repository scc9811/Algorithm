import java.util.Stack;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int size = numbers.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<size; i++){
            if(!stack.isEmpty() && numbers[i]>numbers[stack.peek()]){
                while(!stack.isEmpty()){
                    if(numbers[i]<=numbers[stack.peek()]) break;
                    numbers[stack.pop()] = numbers[i];
                }
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            numbers[stack.pop()] = -1;
        }
        
        
        
        return numbers;
    }
}