class Solution {
    public int[] constructTransformedArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(i,nums[i]);
        } 

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                int a = (nums[i]+i+n)%n;
                nums[i] = map.get(a);
                // System.out.print(a+" ");
            }
            else if(nums[i]<0){
                int a = (nums[i]*(-1))%n;
                a = (i-a+n)%n;
                System.out.print(a+" ");
                nums[i] = map.get(a);
            }
        } 

        return nums;

    }
}