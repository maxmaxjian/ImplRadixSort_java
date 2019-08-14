import java.util.*;

public class RadixSort {

    public void sort(List<Integer> nums) {
        int max = nums.stream().max(Integer::compare).get();
        int exp = 1;
        while (max != 0) {
            max /= 10;
            countSort(nums, exp);
            exp++;
        }
    }

    private void countSort(List<Integer> nums, int n) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for (int num : nums) {
            int digit = digitAt(num, n);
            if (!map.containsKey(digit)) {
                map.put(digit, new ArrayList<>());
            }
            map.get(digit).add(num);
        }
        List<Integer> sorted = new ArrayList<>();
        map.forEach((k, v) -> sorted.addAll(v));
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, sorted.get(i));
        }
        sorted.forEach(i -> System.out.print(i + " "));
    }

    private int digitAt(int num, int n) {
        return (num/(int)Math.pow(10, n-1)) % 10;
    }
    
}
