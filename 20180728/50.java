class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = myPow(x, n/2);
        if (n % 2 == 0) {
            return result*result;
        } else {
            if (n > 0) {
                return result*result*x;    
            } else {
                return (result * result)/x;
            }
        }
    }
}

class Solution {
    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0) {
            // remainder equals 1
            if ((m & 1) == 1) {
                ans *= x;
            }
            x *= x;
            m >>= 1;
        }
        return n > 0 ? ans : 1/ans;
    }
}
