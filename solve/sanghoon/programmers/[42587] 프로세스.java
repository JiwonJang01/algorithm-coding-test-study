import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐에 프로세스 삽입
        Queue<Process> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(priorities[i], i));
        }

        // 우선순위 정렬
        Arrays.sort(priorities);

        int cursor = priorities.length - 1; // 오름차순 정렬이므로 역순으로 탐색
        int count = 0;
        while (!queue.isEmpty()) {
            int priority = priorities[cursor];
            Process p = queue.poll();

            if (p.priority == priority) {
                cursor--;
                count++;

                if (p.location == location) {
                    return count;
                }
            } else {
                queue.offer(p);
            }
        }

        return priorities.length;
    }

    static class Process {
        int priority;
        int location;

        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}