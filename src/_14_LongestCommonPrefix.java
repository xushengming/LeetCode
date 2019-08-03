public class _14_LongestCommonPrefix {
    public String longestCommonPrefix_whole(String[] strs) {
        int length = strs.length;
        if(length == 0){
            return "";
        }
        if(length == 1){
            return strs[0];
        }
        int strs0Length = strs[0].length();
        int startIndex = 0;
        int endIndex = 0;
        int j = 1;
        String result = "";
        for (int i = 0; i < strs0Length; i++) {
            for (j = 1; j < length; j++) {
                if (strs[j].contains(strs[0].substring(i, i + 1))) {
                    continue;
                } else {
                    break;
                }
            }
            if (j == length) {
                startIndex = i;
                int k;
                for (k = i + 1; k <= strs0Length; k++) {
                    for (j = 1; j < length; j++) {
                        if (strs[j].contains(strs[0].substring(i, k))) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    if (j != length) {
                        break;
                    }
                }
                endIndex = k - 1;

                if (result.length() < endIndex - startIndex) {
                    result = strs[0].substring(startIndex, endIndex);
                }
            }
        }
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 0){
            return "";
        }
        if(length == 1){
            return strs[0];
        }
        int strs0Length = strs[0].length();
        int j;
        String result = "";
        int i = 0;
        for (i = 0; i < strs0Length; i++){
            for (j = 1; j < length; j++){
                if(i < strs[j].length()
                        && strs[j].charAt(i) == strs[0].charAt(i)){
                    continue;
                }else{
                    break;
                }
            }
            if(j != length){
                result = strs[0].substring(0, i);
                break;

            }
        }
        if(i == strs0Length){
            result = strs[0];
        }
        return result;
    }
    public static void main(String[] args) {
        _14_LongestCommonPrefix longestCommonPrefix = new _14_LongestCommonPrefix();
        String[] intput = new String[]{"ac","c","c"};
        System.out.println("longestCommonPrefix = " + longestCommonPrefix.longestCommonPrefix(intput));
    }
}
