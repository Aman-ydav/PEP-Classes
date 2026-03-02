class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans[] = new int[nums.length];
        List<Integer>[] arr = new ArrayList[nums.length+1];
        for(int num: map.keySet()){
            int l = map.get(num);
            if(arr[l]==null){
                arr[l] = new ArrayList<>();
            }
            arr[l].add(num);
        }
         for(int i=0;i<arr.length;i++ ){
            if(arr[i]!=null){
                Collections.sort(arr[i],Collections.reverseOrder());
            }
         }
        int x=0;
        for(int i=0;i<arr.length;i++ ){
            if(arr[i]!=null){
                for(int nb : arr[i]){
                    for(int k=0;k<i;k++){
                        ans[x++] = nb;
                    }
                }
            }
        }
        return ans;
    }
}