import java.util.Random;

public class QuickSelect {

    /**
     *  k-th the largest element in the array
     *  Runtime: O(log(n))
     *  Space: O(n)
     */
    int quickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivotIdx = new Random().nextInt(right - left + 1) + left;

        pivotIdx = partition(nums, left, right, pivotIdx);

        if (pivotIdx == k) {
            return nums[k];
        } else if (pivotIdx < k) {
            return quickSelect(nums, pivotIdx + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIdx - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIdx) {
        int pivot = nums[pivotIdx];

        swap(nums, pivotIdx, right);

        pivotIdx = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pivot++);
            }
        }
        return pivotIdx - 1;
    }

    private void swap(int[] nums, int a, int b) {
        int cachedA = nums[a];

        nums[a] = nums[b];
        nums[b] = cachedA;
    }
}
