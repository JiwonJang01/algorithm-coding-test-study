class Solution {
    public String solution(String p) {
        // 빈 문자열
        if (p.isEmpty()) {
            return "";
        }
        
        // u, v 분리
        int idx = split(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        // u가 올바른 경우
        if (isCorrect(u)) {
            return u + solution(v);  
        }
        
        // u가 올바르지 않은 경우
        StringBuilder result = new StringBuilder();
        result.append("(");
        result.append(solution(v));
        result.append(")");
        
        String temp = u.substring(1, u.length() - 1);
        result.append(reverse(temp));
        
        return result.toString();
    }
    
    int split(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count == 0) return i + 1;
        }
        return s.length();
    }
    
    boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
    
    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}
