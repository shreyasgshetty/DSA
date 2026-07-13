class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s1.isEmpty()) {
                s1.push(s.charAt(i));
                continue;
            }
            if(s1.peek()=='(' && s.charAt(i) == ')') s1.pop();
            else if(s1.peek()=='[' && s.charAt(i) == ']') s1.pop();
            else if(s1.peek() == '{' && s.charAt(i) == '}') s1.pop();
            else s1.push(s.charAt(i));
        }
        if(s1.isEmpty()) return true;
        return false;
    }
}