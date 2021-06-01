package LeetCode.stack;

import java.util.ArrayList;
import java.util.List;

public class Num155 {

    public Num155() {

    }

    List<Integer> list = new ArrayList<>();

    public void push(int val) {
        if(list.size()==0){
            list.add(val);
            list.add(val);
        }else{
            int temp=list.get(list.size()-1);
            list.add(val);
            if(temp>val){
                list.add(val);
            }else{
                list.add(temp);
            }
        }
    }

    public void pop() {
        list.remove(list.size()-1);
        list.remove(list.size()-1);
    }

    public int top() {
        if (list.size() > 0) {
            return list.get(list.size() - 2);
        }
        return -1;
    }

    public int getMin() {
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return -1;
    }
}
