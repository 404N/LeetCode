package LeetCode.stack;

import java.util.Stack;

public class Num71 {
    public String simplifyPath(String path) {
        Stack<String> dir = new Stack<>();
        int len = path.length();
        int mark = 0;
        while (mark < len) {
            if (path.charAt(mark) == '/') {
                while (mark + 1 < len && path.charAt(mark + 1) == '/') {
                    mark++;
                }
            } else if (path.charAt(mark) == '.') {
                int cnt = 1;
                String temp = ".";
                while (mark + 1 < len && path.charAt(mark + 1) != '/') {
                    cnt++;
                    temp += path.charAt(mark + 1);
                    mark++;
                }
                if (cnt == 2) {
                    if (temp.charAt(1) == '.' && dir.size() > 0) {
                        dir.pop();
                    }
                } else if (cnt > 2) {
                    dir.push(temp);
                }
            } else {
                String temp = path.charAt(mark) + "";
                while (mark + 1 < len && path.charAt(mark + 1) != '/') {
                    temp += path.charAt(mark + 1);
                    mark++;
                }
                dir.push(temp);
            }
            mark++;
        }
        String res = "";
        if (dir.isEmpty()) {
            return "/";
        }
        while (!dir.isEmpty()) {
            res = "/" + dir.peek() + res;
            dir.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Num71 num71 = new Num71();
        String path = "/.hidden/hide..";
        System.out.println(num71.simplifyPath(path));
    }
}
