import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {

    int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }
        int[] topKFrequent = new int[k];
        int j = 0;

        for (int i = buckets.length - 1; i >= 0 && j < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    topKFrequent[j++] = num;

                    if (j == k) {
                        break;
                    }
                }
            }
        }
        return topKFrequent;
    }
}
