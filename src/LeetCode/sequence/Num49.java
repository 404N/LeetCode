package LeetCode.sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int cnt=0;
        for (String str :strs) {
            String sKey = sortStr(str.toCharArray());
            Integer sValue=map.get(sKey);
            if (sValue == null) {
                map.put(sKey, cnt);
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
                cnt++;
            } else {
                res.get(sValue).add(str);
            }
        }
        return res;
    }

    String sortStr(char[] str) {
        for (int i = 1; i < str.length; i++) {
            boolean flag = true;
            for (int j = 0; j < str.length-i; j++) {
                if (str[j] > str[j + 1]) {
                    flag = false;
                    char temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        String[] s={"eat","tea","tan","ate","nat","bat"};
        Num49 num49=new Num49();
        System.out.println(num49.groupAnagrams(s));
    }
}
