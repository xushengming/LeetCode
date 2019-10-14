public class _28_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        int[][] dfa = new int[26][needle.length()];
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < needle.length(); j++){
                dfa[i][j] = 0;
            }
        }
        int x = 0;
        dfa[getCharIndex(needle.charAt(0))][0] = 1;
        for (int j = 1; j < needle.length(); j++){
            for (int c = 0; c < 26; c++){
                dfa[c][j] = dfa[c][x];
            }
            dfa[getCharIndex(needle.charAt(j))][j] = j + 1;
            x = dfa[getCharIndex(needle.charAt(j))][x];
        }

        //search
        int j = 0, i = 0;
        for (i = 0; i < haystack.length() && j < needle.length(); i++){
           j = dfa[getCharIndex(haystack.charAt(i))][j];
        }
        if(j == needle.length()){
            return i - j;
        }else{
            return -1;
        }
    }

    private int getCharIndex(char ch){
        return ch - 'a';
    }

    public static void main(String[] args) {
        _28_Implement_strStr implement_strStr = new _28_Implement_strStr();
        String haystack = "heollo";
        String needle = "ll";
        int result = implement_strStr.strStr(haystack, needle);
        System.out.println("result: " + result);
    }
}
