package main.java.mine;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int rtn = nums[0];
        int number;

        for (int i = 0; i < nums.length - 1; ++i) {
            rtn = nums[i] > rtn ? nums[i] : rtn;
            if (nums[i] > 0) {
                number = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (number + nums[j] > 0) {
                        number = nums[j] + number;
                        rtn = number > rtn ? number : rtn;
                    }
                    else {
                        break;
                    }
                }

            }
        }
        rtn = nums[nums.length - 1] > rtn ? nums[nums.length - 1] : rtn;
        return rtn;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray.maxSubArray(nums);
    }
}
