package LeetCode.sequence;

import java.util.HashMap;
import java.util.Map;

public class Num242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        boolean flag=true;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(map.containsKey(s.charAt(i))){
                int temp=map.get(s.charAt(i));
                if(temp-1>0){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                }else{
                    map.remove(s.charAt(i));
                }
            }else{
                flag=false;
            }
        }
        return flag;
    }


    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] str=new int[26];
        for(int i=0;i<s.length();i++){
            str[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            str[t.charAt(i)-'a']--;
            if(str[t.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Num242 num242=new Num242();
        String a="anagram";
        String b="nagaram";
        System.out.println(num242.isAnagram2(a,b));
    }
}
