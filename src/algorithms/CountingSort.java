import java.util.ArrayList;
import java.util.List;

/**
 *  Time/Space complexity: O(n + k), where k is the range of the non-negative key values.
 *  It is only suitable for direct use in situations
 *  where the variation in keys is not significantly greater than the number of items.
 */
public class CountingSort {
    List<Integer> countingSort(List<Integer> nums) {
        int min = 1;
        int max = 100;

        int len = max - min + 1;
        int[] counts = new int[len];

        for (int num : nums) {
            counts[num - min]++;
        }
        List<Integer> sortedNums = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int count = counts[i]; count > 0; count--) {
                sortedNums.add(i + min);
            }
        }
        return sortedNums;
    }
}
