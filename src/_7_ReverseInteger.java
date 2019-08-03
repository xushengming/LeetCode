public class _7_ReverseInteger {
    public int reverse(int x) {
        if( x == 0){
            return x;
        }
        if(x > Math.pow(2, 31) - 1 || x < -Math.pow(2, 31)){
            return 0;
        }
        int result = 0;
        boolean negative = x < 0;
        if(negative){
            x = -x;
        }
        while (x != 0){
            if(x < 10){
                if(result > Math.pow(2, 31) / 10){
                    return 0;
                }
            }
            result *= 10;
            if(x < 10){
                if(result > Math.pow(2, 31) - x % 10){
                    return 0;
                }
            }
            result += x % 10;
            if(result < 0){
                return 0;
            }
            x = x / 10;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        _7_ReverseInteger reverseInteger = new _7_ReverseInteger();
        System.out.println("result: " + reverseInteger.reverse(x));
    }
}
