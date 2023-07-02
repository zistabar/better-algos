public class Kadanes {

    /**
     *  Find min/max sum of contiguous subarray
     */
    int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
