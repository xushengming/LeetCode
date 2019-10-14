public class _29_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        boolean resultNegative = (dividend ^ divisor) >>> 31 == 1;
        int quotient = 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        long dividendPositive = Math.abs((long)dividend);
        long divisorPositive = Math.abs((long)divisor);
        while (dividendPositive >= divisorPositive){
            long q = 1, tmp = divisorPositive;
            while (dividendPositive >= (tmp << 1)){
                tmp <<= 1;
                q <<= 1;
            }
            dividendPositive -= tmp;
            quotient += q;
        }
        if(resultNegative){
            return -quotient;
        }else{
            return quotient;
        }
    }

    public static void main(String[] args) {
        _29_Divide_Two_Integers divide_two_integers = new _29_Divide_Two_Integers();
        int result = divide_two_integers.divide(-2147483648, -1);
        System.out.println(result);
    }
}
