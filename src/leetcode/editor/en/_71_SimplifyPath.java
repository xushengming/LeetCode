//Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path. 
//
// In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix 
//
// Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path. 
//
// 
//
// Example 1: 
//
// 
//Input: "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory name.
// 
//
// Example 2: 
//
// 
//Input: "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
// 
//
// Example 4: 
//
// 
//Input: "/a/./b/../../c/"
//Output: "/c"
// 
//
// Example 5: 
//
// 
//Input: "/a/../../b/../c//.//"
//Output: "/c"
// 
//
// Example 6: 
//
// 
//Input: "/a//b////c/d//././/.."
//Output: "/a/b/c"
// 
// Related Topics String Stack

  package leetcode.editor.en;

import java.util.Stack;

public class _71_SimplifyPath{
      public static void main(String[] args) {
           Solution solution = new _71_SimplifyPath().new Solution();
           System.out.println(solution.simplifyPath("/a//b////c/d//././/..") + " ==== /a/b/c");
          System.out.println(solution.simplifyPath("/a/../../b/../c//.//") + " ==== /c");
          System.out.println(solution.simplifyPath("/a/./b/../../c/") + " ==== /c");
          System.out.println(solution.simplifyPath("/home//foo/") + " ==== /home/foo");
          System.out.println(solution.simplifyPath("/home/") + " ==== /home");
          System.out.println(solution.simplifyPath("/../") + " ==== /");
          System.out.println(solution.simplifyPath("/...") + " ==== /...");
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "/";
        }
        Stack<String> pathStack = new Stack<>();
        pathStack.push("/");
        int i = 0;
        while (i < path.length()){
            char ch = path.charAt(i);
            if(ch == '/'){
                if(!pathStack.peek().equals("/")){
                    pathStack.push(path.substring(i, i + 1));
                }
                i++;
            } else if(ch == '.'  && (i + 1 >= path.length() || path.charAt(i + 1) == '/')
                    || (i + 1 < path.length() && path.charAt(i + 1) == '.'
                    && (i + 2 >= path.length() || path.charAt(i + 2) == '/'))){
                if(i + 1 < path.length() && path.charAt(i + 1) == '.'
                        && (i + 2 >= path.length() || path.charAt(i + 2) == '/')){
                    if(pathStack.size() > 2){
                        pathStack.pop();
                        pathStack.pop();
                        i++;
                    }
                    i++;
                }else{
                    i++;
                }
            }else{
                int j = getNextWordEnd(path, i);
                pathStack.push(path.substring(i, j));
                i = j;
            }
        }
        if(pathStack.size() > 1 && pathStack.peek().equals("/")){
            pathStack.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!pathStack.empty()){
            stringBuilder.insert(0, pathStack.pop());
        }
        return stringBuilder.toString();
    }

    private int getNextWordEnd(String path, int startIndex){
        while (startIndex < path.length()){
            if(path.charAt(startIndex) != '/'){
                startIndex++;
            }else{
                break;
            }
        }
        return startIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
