
/**
 * 删除排序数组中的重复项
 * 双指针法
 */
public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
