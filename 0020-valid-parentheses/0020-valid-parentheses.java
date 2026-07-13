class Solution {
    public boolean isValid(String s) {
    Deque <Character> s1 = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {

        char ch = s.charAt(i);

        if (!s1.isEmpty() && s1.peek() == '(' && ch == ')') {
            s1.pop();
        }
        else if (!s1.isEmpty() && s1.peek() == '[' && ch == ']') {
            s1.pop();
        }
        else if (!s1.isEmpty() && s1.peek() == '{' && ch == '}') {
            s1.pop();
        }
        else {
            s1.push(ch);
        }
    }

    return s1.isEmpty();
}
}