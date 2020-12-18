package LeetCode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Num3 {
    public int lengthOfLongestSubstring(String s) {
        //最大长度
        int max = 0;
        //记录用子串
        String childStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (childStr.indexOf(s.charAt(i))!=-1) {
                childStr = childStr.substring(childStr.indexOf(s.charAt(i))+1);
            }
            childStr += s.charAt(i);
            if (max < childStr.length()) {
                max = childStr.length();
            }
        }
        return max;
    }

    static public int lengthOfLongestSubstring2(String s) {
        int start = 0;
        int max = 0;
        int n=s.length();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < n; ++i) {
           char child=s.charAt(i);
           //如果重复了，start右移
           if(map.containsKey(child)){
               //防止start左移
               start=Math.max(start,map.get(child)+1);
           }
            System.out.println();
           map.put(child,i);
           max=Math.max(max,i-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Num3.lengthOfLongestSubstring2("abba"));
    }
}
