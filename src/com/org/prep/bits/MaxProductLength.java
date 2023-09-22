package com.org.prep.bits;

public class MaxProductLength {
    public static void main(String args[]){
        String[] s={"abcw","baz","foo","bar","xtfn","abcdef"};
        maxProduct(s);
    }



    public static int maxProduct(String[] words) {
        if(words==null || words.length==0) return 0;
        int [] state= new int [words.length];
        for(int i=0;i<words.length;i++){
            state[i]=getState(words[i]);
        }
        int maxProd=0;
        for(int j=0;j<words.length-1;j++){
            for(int k=j+1;k<words.length;k++){
                if((state[j] & state[k])==0){
                    maxProd=Math.max(maxProd,words[j].length()*words[k].length());
                }
            }
        }
        return maxProd;
    }
    private static int getState(String s){
        int state=0;
        for(char c:s.toCharArray()){
            int indx=c-'a';
            state |= 1<<(indx); // to activate the bit by using the left shift
        }
        return state;
    }
}
