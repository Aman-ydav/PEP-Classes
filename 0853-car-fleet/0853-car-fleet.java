class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        ArrayList<float[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            float time = (float)(target-position[i])/(float)speed[i];
            list.add(new float[]{position[i],time});
        }

        Collections.sort(list, (a, b) -> Float.compare(b[0], a[0]));

        Deque<Float> st = new ArrayDeque<>();

        for(float[] car : list){
            float currTime = car[1];

            if (st.isEmpty() || currTime > st.peek()) {
                st.push(currTime);
            }
        }

        return st.size();
    }
}