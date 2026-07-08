import java.util.*;

class Solution {
    private static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;


        return (int) ((myPow(5,even) * myPow(4,odd)) % MOD);
    }

    public long myPow(long x, long n) {
    long ans = 1;

    while (n > 0) {
        if (n % 2 == 1) {
            ans = (ans * x) % MOD;
            n--;
        } else {
            x = (x * x) % MOD;
            n /= 2;
        }
    }

    return ans;
}
}
