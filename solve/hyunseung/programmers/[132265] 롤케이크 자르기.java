class Solution {
    public int solution(int[] topping) {
        int maxType = 10000; // 토핑 번호 최대
        int[] left = new int[maxType + 1];
        int[] right = new int[maxType + 1];

        int rightKinds = 0;
        int leftKinds = 0;

        // 1. 처음에는 모든 조각이 "오른쪽"에 있다고 보고 종류 수 세기
        for (int t : topping) {
            if (right[t] == 0) {
                rightKinds++;
            }
            right[t]++;
        }

        int answer = 0;

        // 2. 왼쪽으로 하나씩 옮겨가며 비교 (마지막 조각 직전까지만)
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            // t를 오른쪽에서 하나 빼기
            right[t]--;
            if (right[t] == 0) {
                rightKinds--;
            }

            // t를 왼쪽에 하나 추가
            if (left[t] == 0) {
                leftKinds++;
            }
            left[t]++;

            // 3. 종류 수가 같으면 공평하게 자른 위치
            if (leftKinds == rightKinds) {
                answer++;
            }
        }

        return answer;
    }
}
