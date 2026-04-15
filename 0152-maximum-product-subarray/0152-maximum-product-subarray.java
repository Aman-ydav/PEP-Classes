class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int s[] = new int[n];
        int p[] = new int[n];
        int prod = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            s[i] = nums[i] * prod;
            if(s[i]==0) s[i] = nums[i];
            prod = s[i];
        }
        for(int i=0;i<n;i++){
            System.out.print(s[i]+" ");
        }
        System.out.println();
        prod = 1;
        for(int i=n-1;i>=0;i--){
            p[i] = nums[i] * prod;
            if(p[i]==0) p[i] = nums[i];
            prod = p[i];
        }
        for(int i=0;i<n;i++){
            System.out.print(p[i]+" ");
        }
         for(int i=0;i<n;i++){
            ans = Math.max(ans,Math.max(p[i],s[i]));
        }
        return ans;
    }
}