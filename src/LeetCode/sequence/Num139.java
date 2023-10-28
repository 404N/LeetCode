package LeetCode.sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Num139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] list = new boolean[s.length() + 1];
        list[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0;j<i;j++){
                if(list[j]&&wordDict.contains(s.substring(j,i))){
                    list[i]=true;
                    break;
                }
            }
        }
        return list[s.length()];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leett");
        list.add("code");
        System.out.println(new Num139().wordBreak("leetcode", list));
    }
}
