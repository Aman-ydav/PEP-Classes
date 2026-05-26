class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] l = new boolean[26];
        boolean[] u = new boolean[26];

        for(char c : word.toCharArray()){
            if(c>='a' && c<='z'){
                l[c-'a'] = true;
            }
            if(c>='A' && c<='Z'){
                u[c-'A']= true;
            }
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(l[i] && u[i]) count++;
        }
        return count;
    }
}