public class _8StringtoInteger {
    public int myAtoi(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        boolean negative = false;
        if(i < str.length()){
            if(str.charAt(i) == '+'){
                negative = false;
                i++;
            }else if(str.charAt(i) == '-') {
                negative = true;
                i++;
            }
        }
        int result = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            if(negative){
                if(result > Integer.MAX_VALUE / 10
                || result == Integer.MAX_VALUE / 10 && str.charAt(i) > '8'){
                    return Integer.MIN_VALUE;
                }
            }else{
                if(result > Integer.MAX_VALUE / 10
                        || result == Integer.MAX_VALUE / 10 && str.charAt(i) > '7'){
                    return Integer.MAX_VALUE;
                }
            }
            result = result * 10 + (str.charAt(i) - '0');
            i++;

        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        _8StringtoInteger stringtoInteger = new _8StringtoInteger();
        String input = "   +434fdsf323 vcvads";
        System.out.println("result: " + stringtoInteger.myAtoi(input));
    }
}
