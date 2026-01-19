import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int box = 1;
        int idx = 0;
        
        while (box <= order.length){
            while(!sub.isEmpty() && sub.peek() == order[idx]){
                sub.pop();
                idx++;
            }
            if(box == order[idx]){
                idx++;
            }
            else {
                sub.push(box);
            }
            box++;
        }
        while(!sub.isEmpty() && sub.peek() == order[idx]){
            sub.pop();
            idx++;
        }
        return idx;
    }
}
