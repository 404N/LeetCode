package LeetCode.sequence;

import java.util.*;

public class Num347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //统计出现次数
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //数字数组
        List<Integer> numList = new ArrayList<>();
        //数字出现次数
        List<Integer> cntList = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                numList.add(num);
                cntList.add(map.get(num));
                map.remove(num);
            }
        }
        numList = quickSort(numList, cntList, 0, numList.size() - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = numList.get(i);
        }
        return res;
    }

    private List<Integer> quickSort(List<Integer> numList, List<Integer> cntList, int start, int end, int k) {
        int key = cntList.get(start);
        int i = start, j = end;
        while (i < j) {
            while (i < j && cntList.get(j) < key) {
                j--;
            }
            while (i < j && cntList.get(i) > key) {
                i++;
            }
            if (cntList.get(i).equals(cntList.get(j)) && i < j) {
                i++;
            } else {
                Integer temp = cntList.get(i);
                cntList.set(i, cntList.get(j));
                cntList.set(j, temp);
                Integer temp2 = numList.get(i);
                numList.set(i, numList.get(j));
                numList.set(j, temp2);
            }
        }
        if(i==j&&i==k){
            return numList;
        }
        if (i - 1 > start&&start<k&&i-1>=k) {
            numList = quickSort(numList, cntList, start, i - 1, k);
        }
        if (j + 1 < end&&end>k&&j+1<=k) {
            numList = quickSort(numList, cntList, j + 1, end, k);
        }
        return numList;
    }

    public static void main(String[] args) {
        Num347 num347 = new Num347();
        int[] a = {1, 1, 1, 2, 2,2,2,2, 3, 3, 3,2,3,4,23,5,45,45546};
        System.out.println(Arrays.toString(num347.topKFrequent(a, 2)));
    }
}
