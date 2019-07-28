public class _10RegularExpressionMatching {
//    public boolean isMatch(String s, String p) {
//        if(s.length() == 0){
//            if(p.length() == 0){
//                return true;
//            }else{
//                if(p.length() >= 2 && p.charAt(1) == '*'){
//                    return isMatch(s, p.substring(2));
//                }else {
//                    return false;
//                }
//            }
//        }else if(p.length() == 0){
//            return false;
//        }
//
//        int pointerS = 0, pointerP = 0;
//        char charS = s.charAt(pointerS);
//        char charP = p.charAt(pointerP);
//        if(charS == charP || charP == '.'){
//            if(pointerP + 1 < p.length() && p.charAt(pointerP + 1) == '*'){
//                return isMatch(s.substring(pointerS + 1), p.substring(pointerP))
//                        || (s.length() == 1 && isMatch(s.substring(pointerS + 1), p.substring(pointerP + 2)))
//                        || (isMatch(s.substring(pointerS + 1), p.substring(pointerP + 2))
//                        || isMatch(s.substring(pointerS), p.substring(pointerP + 2)));
//            }else{
//                return isMatch(s.substring(pointerS + 1), p.substring(pointerP + 1));
//            }
//        }else {
//            if(pointerP + 1 < p.length() && p.charAt(pointerP + 1) == '*'){
//                return isMatch(s.substring(pointerS), p.substring(pointerP + 2));
//            }else{
//                return false;
//            }
//        }
//    }

    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length() == 0;
        }

        if(p.length() == 1 || p.charAt(1) != '*'){
            return s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
            && isMatch(s.substring(1), p.substring(1));
        }
        int indexS = 0;
        while (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(indexS) == p.charAt(0))){
            if(isMatch(s.substring(indexS++), p.substring(2))){
                return true;
            }
        }
        return isMatch(s.substring(1), p.substring(2));

    }


    public static void main(String[] args) {
        _10RegularExpressionMatching regularExpressionMatching = new _10RegularExpressionMatching();
        String s = "a";
        String p = "ab*";
        System.out.println("result = " + regularExpressionMatching.isMatch(s, p));
    }
}
