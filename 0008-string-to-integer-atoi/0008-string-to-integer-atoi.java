import java.util.*;

class Solution {
    public int myAtoi(String s) {

        StringBuilder ans = new StringBuilder();
        boolean started = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!started && ch == ' ') {
                continue;
            }

            // Sign
            if (!started && (ch == '+' || ch == '-')) {
                ans.append(ch);
                started = true;
                continue;
            }

            // Digit
            if (Character.isDigit(ch)) {
                ans.append(ch);
                started = true;
            } else {
                break;
            }
        }

        String a = ans.toString();

        // No valid number
        if (a.isEmpty() || a.equals("+") || a.equals("-")) {
            return 0;
        }

        // Remove leading zeros after optional sign
        int sign = 0;
        if (a.charAt(0) == '+' || a.charAt(0) == '-') {
            sign = 1;
        }

        while (sign < a.length() - 1 && a.charAt(sign) == '0') {
            a = a.substring(0, sign) + a.substring(sign + 1);
        }

        try {
            long num = Long.parseLong(a);

            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            return (int) num;

        } catch (NumberFormatException e) {
            if (a.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }
}