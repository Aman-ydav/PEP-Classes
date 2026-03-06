class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int l =0;
        int[] arr = new int[nums.length-k+1];
        int a=0;
        for(int i=0;i<nums.length;i++){

            if(nums[i]<0) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(i-l+1>k){
                if(map.containsKey(nums[l])){
                    map.put(nums[l],map.get(nums[l])-1);
                    if(map.get(nums[l])==0) map.remove(nums[l]);
                }
                l++;
            }
            if(i-l+1==k){
                int b = 0;
                int beauty = 0;
                for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                    b += entry.getValue();
                    if(b>=x){
                        beauty = entry.getKey();
                        break;
                    }
                }
                arr[a++] = beauty;
            }
        }
        return arr;
    }
}