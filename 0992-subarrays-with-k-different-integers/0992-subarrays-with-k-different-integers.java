class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int K) {
        int[] freq = new int[nums.length + 1];
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            // New distinct element entering the window
            if (freq[nums[right]] == 0) {
                K--;
            }
            freq[nums[right]]++;

            while (K < 0) {
                freq[nums[left]]--;
                // Element completely left the window
                if (freq[nums[left]] == 0) {
                    K++;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
