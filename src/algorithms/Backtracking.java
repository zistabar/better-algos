import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Return all possible subsets/permutations/combinations
 */
public class Backtracking {

    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }

    private void subsets(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);

            subsets(subsets, subset, nums, i + 1);

            subset.remove(subset.size() - 1);
        }
    }

    List<List<Integer>> subsetsWithDups(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        Arrays.sort(nums);

        subsets(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }

    private void subsetsWithDups(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);

            subsets(subsets, subset, nums, i + 1);

            subset.remove(subset.size() - 1);
        }
    }
}
