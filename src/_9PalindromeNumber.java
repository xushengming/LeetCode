public class _9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int reverse = 0;
        int origin = x;
        while (origin != 0){
            reverse = reverse * 10 + origin % 10;
            origin /= 10;
        }
        return reverse == x;
    }

    public boolean isPalindrome2(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int reverse = 0;
        while (x > reverse){
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return (reverse == x) || (x == reverse / 10);
    }

    public static void main(String[] args) {
        _9PalindromeNumber palindromeNumber = new _9PalindromeNumber();
        int x = 121;
        System.out.println("palindromeNumber = " + palindromeNumber.isPalindrome2(x));
        int y = 0;
        System.out.println("palindromeNumber = " + palindromeNumber.isPalindrome(y));
        int z = -121;
        System.out.println("palindromeNumber = " + palindromeNumber.isPalindrome(z));
    }
}
