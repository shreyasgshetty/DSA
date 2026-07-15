class Solution {
    public int reverse(int x) {
        boolean sign = true;
        if(x<0){
            sign = false;
            x = (-1)*x;
        }
        int ans = 0;
        while(x>0){
            int n = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && n > 7)){
            return 0;
            }
            ans = ans * 10 + n;
            x = x/10;
        }
        return sign?ans:((-1)*ans);
    }
}