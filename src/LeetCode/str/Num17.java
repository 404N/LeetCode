package LeetCode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num17 {
    static public List<String> letterCombinations(String digits) {

        List<String> stringList = new ArrayList<>();
        //判空处理
        if (digits.length() == 0) {
            return stringList;
        }
        //一个HashMap，初始化值为9键数字键盘对应的字母
        Map<String, String> numMap = new HashMap<String, String>(){
            {
                put("2","abc");
                put("3","def");
                put("4","ghi");
                put("5","jkl");
                put("6","mno");
                put("7","pqrs");
                put("8","tuv");
                put("9","wxyz");
            }
        };

        for (int i = 0; i < digits.length(); i++) {
            String temp = numMap.get(digits.substring(i, i + 1));
            if (i == 0) {
                for (int j = 0; j < temp.length(); j++) {
                    stringList.add(temp.substring(j, j + 1));
                }
            } else {
                int len = stringList.size();
                for (int k = 0; k < len; k++) {
                    for (int j = 0; j < temp.length(); j++) {
                        stringList.add(stringList.get(k) + temp.charAt(j));
                    }

                }

            }
        }
        for (int i = stringList.size() - 1; i >= 0; i--) {
            if (stringList.get(i).length() < digits.length()) {
                stringList.remove(i);
            }
        }
        return stringList;
    }

    public static void main(String[] args) {
        System.out.println(Num17.letterCombinations("23"));
    }
}
