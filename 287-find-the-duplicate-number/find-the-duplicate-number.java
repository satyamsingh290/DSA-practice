class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]==nums[j]){
                return nums[i];
            }
            i++;
        }
        return -1;
    }
}