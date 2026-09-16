class Solution {

    int maxSubarraySum(int[] arr) {
        // Code here
        int n=arr.length;
        int [] dp=new int[n];

        dp[0]=arr[0];
        int ans = dp[0];
        for(int i=1;i<n;i++){

            int notpick=arr[i]+dp[i-1];
            int pick=arr[i];

            dp[i]=Math.max(notpick,pick);

            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}