public class Leetcode697 {
 public int findShortestDuration(int[] nums) {
        int max = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            if (count > max) {
                max = count;

            }
            counts.put(num, count);
        }

        Set<Integer> set = new HashSet<>();
        for (Integer key : counts.keySet()) {
            if (counts.get(key) == max) {
                set.add(key);
            }
        }


        int res = nums.length;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            int left = 0;
            int right = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    left = i;
                    break;
                }
            }

            for (int j = nums.length - 1; j > 0; j--) {
                if (nums[j] == key) {
                    right = j;
                    break;
                }
            }

            if (right - left + 1 < res) {
                res = right - left + 1;
            }
        }

        return res;
    }

   public int findShortestDuration2(int[] nums) {
        Map<Integer, Integer> left = new HashMap()；
        Map<Integer, Integer> right = new HashMap()；
       Map<Integer, Integer> count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(new Demo().findShortestDuration(nums));
    }
}
